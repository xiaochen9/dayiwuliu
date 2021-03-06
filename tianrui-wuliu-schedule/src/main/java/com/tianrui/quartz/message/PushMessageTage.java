package com.tianrui.quartz.message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tianrui.api.intf.IMemberPushService;
import com.tianrui.api.intf.ISendMobileMessage;
import com.tianrui.api.intf.ISystemMemberService;
import com.tianrui.api.message.intf.IMessagePushService;
import com.tianrui.api.req.common.SmsDetails;
import com.tianrui.api.resp.front.member.MemberResp;
import com.tianrui.api.resp.money.MessagePushResp;
import com.tianrui.common.enums.MessageCodeEnum;
import com.tianrui.common.utils.DateUtil;
import com.tianrui.common.vo.Result;
import com.tianrui.service.bean.MemberPush;
import com.tianrui.service.cache.CacheClient;
import com.tianrui.service.cache.CacheHelper;
import com.tianrui.service.cache.CacheModule;
import com.tianrui.service.util.BaiduPushUtils;
/**
 * 定时推送消息
 * @author Administrator
 *
 */
@Component 
public class PushMessageTage {
	
	private Logger logger = LoggerFactory.getLogger(PushMessageTage.class);
	/**
	 * 定时任务参数
	 */
	@Autowired
	protected IMessagePushService messagePushService;
	@Autowired
	private ISystemMemberService systemMemberService;
	@Autowired
	IMemberPushService pushService;
	@Autowired
	ISendMobileMessage sendMobileMessage;
	@Autowired
	CacheClient cacheClient;
	
	static String push_tage = "vender_push_tage";
	/**
	 * 创建推送分组 并塞入用户
	 * @throws Exception 
	 */
	@Scheduled(cron="0 0 0/2  * * ? ")
	public void savePushTage() throws Exception{
		Long st = new Date().getTime();
    	logger.info("定时器[savePushTage]启动创建消息分组.时间是 :" + DateUtil.getDateString());  
		//删除原有分组
		BaiduPushUtils.deleteTage(push_tage, 3);
		BaiduPushUtils.deleteTage(push_tage, 4);
		//创建分组
		BaiduPushUtils.createTage(push_tage, 3);
		BaiduPushUtils.createTage(push_tage, 4);
		
		List<String> android = new ArrayList<String>();
		List<String> ios = new ArrayList<String>();

		//获取推送目标车主集合
		List<MemberResp> memberList = systemMemberService.findAllVender();
		logger.info("车主集合数="+memberList.size());
		StringBuffer sb = new StringBuffer(1024);
		for(int i = 0;  i < memberList.size();i++ ){
			MemberResp member = memberList.get(i);
			sb.append(member.getCellPhone());
			if(i%200 == 0 && i > 0 && i != memberList.size()-1){
				sb.append("-");
			}else if (i != memberList.size()-1) {
				sb.append(",");
			}
			Result rs = pushService.selectChannelId(member.getId());
			if(rs.getCode().equals("000000")){
				MemberPush push = (MemberPush) rs.getData();
				logger.info("推送用户 及 pushid"+member.getCellPhone()+push.getPushid());
				if(push.getApptype()==(byte)1){//adnroid
					android.add(push.getPushid());
					logger.info("android.size()"+android.size());
					if(android.size()>=9){
						//最多保存9 推送并清空
						String[] ids = android.toArray(new String[android.size()]);
						BaiduPushUtils.addUserToTage(push_tage, 3, ids);
						logger.info("添加用户至分组 android:"+ids.toString());
						android.clear();
					}
				}else if(push.getApptype()==(byte)2){//ios
					ios.add(push.getPushid());
					logger.info("ios.size()"+ios.size());
					if(ios.size()>=9){
						//最多保存9 推送并清空
						String[] ids = ios.toArray(new String[ios.size()]);
						BaiduPushUtils.addUserToTage(push_tage, 4, ids);
						logger.info("添加用户至分组 ios:"+ids.toString());
						ios.clear();
					}
				}
			}else{
				logger.info("未找到用户推送id"+member.getCellPhone());
			}
		}
		logger.info("android.size()"+android.size());
		String[] and_ = android.toArray(new String[android.size()]);
		BaiduPushUtils.addUserToTage(push_tage, 3, and_);
		logger.info("添加用户至分组 android:"+and_.toString());
		
		logger.info("ios.size()"+ios.size());
		String[] ios_ = ios.toArray(new String[ios.size()]);
		BaiduPushUtils.addUserToTage(push_tage, 4, ios_);
		logger.info("添加用户至分组 ios:"+ios_.toString());
		
		//设置短信发送群成员
		String key = CacheHelper.buildKey(CacheModule.SMS_TEL, "push");
		cacheClient.saveString(key, sb.toString(), -1);
		logger.info("短信推送成员："+cacheClient.getString(key));
		
		logger.info("定时任务[savePushTage]完成.耗时：{}",new Object[]{(new Date().getTime()-st)});
	}
	
	@Scheduled(cron="0 0/5 *  * * ? ")
    public void getMessageAndPush() {  
    	Long st = new Date().getTime();
    	logger.info("定时器[PushMessageTrigger]启动.时间是 :" + DateUtil.getDateString());  
    	int count =0;
        try {
        	//获取待推送的消息
        	List<MessagePushResp> ls = messagePushService.findPendingMessage();
        	if(ls != null && ls.size() > 0){
        		logger.info("本次待推送消息条数" + ls.size()); 
        		for(MessagePushResp message :ls){//循环待推送消息
        			try {
        				Long beginTime = new Date().getTime();
        				int sendCount =0;
            			if(message.getChannel() == 1){//推送APP消息
            				BaiduPushUtils.pushMsgToTage(push_tage, 3, message.getMessageContent(), MessageCodeEnum.MSG_ALL_OWNER.getCode()+"");
            				BaiduPushUtils.pushMsgToTage(push_tage, 4, message.getMessageContent(), MessageCodeEnum.MSG_ALL_OWNER.getCode()+"");
    						count++;
    						sendCount++;
    					}else if (message.getChannel() == 2) {//发送短信通知
    						String key = CacheHelper.buildKey(CacheModule.SMS_TEL, "push");
    						String tels = cacheClient.getString(key);
    						if(null != tels && ! "".equalsIgnoreCase(tels)){
    							String [] ts = tels.split("-");
    							for(String cells :ts){
    								SmsDetails sms = new SmsDetails();
    	    						sms.setTelephoneReceiver(cells);
    	    						sms.setSmsContent(message.getMessageContent());
    	    						sendMobileMessage.sendMobileMessage(sms);
    	    						count+=cells.split(",")   .length;
    	    						sendCount+=cells.split(",").length;
    							}
    						}
    					}else if (message.getChannel() == 3) {//推送APP消息和发送短信通知
    						String key = CacheHelper.buildKey(CacheModule.SMS_TEL, "push");
    						String tels = cacheClient.getString(key);
    						if(null != tels && ! "".equalsIgnoreCase(tels)){
    							String [] ts = tels.split("-");
    							for(String cells :ts){
    								SmsDetails sms = new SmsDetails();
    	    						sms.setTelephoneReceiver(cells);
    	    						sms.setSmsContent(message.getMessageContent());
    	    						sendMobileMessage.sendMobileMessage(sms);
    	    						count+=cells.split(",").length;
    	    						sendCount+=cells.split(",").length;
    							}
    						}
    						BaiduPushUtils.pushMsgToTage(push_tage, 3, message.getMessageContent(), MessageCodeEnum.MSG_ALL_OWNER.getCode()+"");
            				BaiduPushUtils.pushMsgToTage(push_tage, 4, message.getMessageContent(), MessageCodeEnum.MSG_ALL_OWNER.getCode()+"");
    						count++;
    						sendCount++;
    					}
        				messagePushService.updatePushState(message.getId(),sendCount,beginTime);
					} catch (Exception e) {
						logger.error(e.getMessage(),e);
					}
            	}
        	}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
        logger.info("定时任务[PushMessageTrigger]完成.推送消息{}条,耗时：{}",new Object[]{count,(new Date().getTime()-st)});
    }
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(1024);
		for(int i = 0;  i < 1001;i++ ){
			sb.append("AAAAA");
			if(i%20 == 0 && i > 0 && i != 1001-1){
				sb.append("-");
			}else if (i != 1001-1) {
				sb.append(",");
			}
		}
		System.out.println(sb.toString());
	}
}
