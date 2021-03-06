package com.tianrui.app.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSON;
import com.tianrui.api.req.app.AppMemberReq;
import com.tianrui.common.utils.Md5Utils;
import com.tianrui.common.vo.AppParam;
import com.tianrui.common.vo.Head;

public class TestAppConnection {

	
	
	public static void main(String[] args) throws Exception {
		
		//!&@#2016#  1fdc30df364d9936fce1d7ade7391954
		//String rs="{\"head\":{\"account\":\"18039330360\",\"appVersion\":\"1.0.0\",\"callType\":\"ios\"},\"sign\":\"!&@#2016#\",\"body\":{\"account\":\"18039330360\",\"pswdMd5\":\"f379eaf3c831b04de153469d1bec345e\"}}";
		//System.out.println(Md5Utils.MD5(rs));
		
		//URL url = new URL("http://127.0.0.1:8080/app/member/login");
		//URL url = new URL("http://172.19.4.23:8091/app/member/login");
		URL url = new URL("http://172.20.10.206:80/app/member/login");
		//URL url = new URL("http://172.19.4.23:8091/app/planvender/page");
		//URL url = new URL("http://172.20.10.90/tcp/payinvoice/queryPayStatus");
		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 设置url请求方式 ‘get’ 或者 ‘post’
		connection.setRequestMethod("POST");
		StringBuffer params = new StringBuffer();
		
		
		AppParam<AppMemberReq> appParam =new AppParam<AppMemberReq>();
		Head head = new Head();
//		head.setTokenId("52ff72b6499945c5ba84335411d1027e");
//		head.setAccount("15234567891");
//		head.setAppVersion("1.0.0");
//		head.setCallType("ios");
		
		AppMemberReq req =new AppMemberReq();
		req.setAccount("15234567891");
		req.setPswdMd5(Md5Utils.MD5("666666"));
		
		
		appParam.setHead(head);
		appParam.setBody(req);
		
		appParam.setSign("!&@#2016#");
		
		String sign = Md5Utils.MD5(JSON.toJSONString(appParam));
		appParam.setSign(sign);
		
	    // 表单参数与get形式一样
		connection.setDoOutput(true);// 是否输入参数
        params.append("param").append("=").append(JSON.toJSONString(appParam));
        
        String aa =params.toString();
        System.out.println(aa);
        byte[] bypes = params.toString().getBytes();
        connection.getOutputStream().write(bypes);// 输入参数
		
		
		// 发送
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String response = in.readLine();
		System.out.println(response);
		
		
	}
	
	public static void queryParams(String path, String id, String tokenId, String Account, Object obj) throws Exception{
		URL url = new URL("http://172.20.10.206:80"+path);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		StringBuffer params = new StringBuffer();
		AppParam<Object> appParam =new AppParam<Object>();
		Head head = new Head();
//		head.setId("3fe63075979d451e8e4095ad8e697e4f");
//		head.setTokenId("52ff72b6499945c5ba84335411d1027e");
//		head.setAccount("15234567891");
		head.setId(id);
		head.setTokenId(tokenId);
		head.setAccount(Account);
		appParam.setHead(head);
		appParam.setBody(obj);
		appParam.setSign("!&@#2016#");
		String sign = Md5Utils.MD5(JSON.toJSONString(appParam));
		appParam.setSign(sign);
		connection.setDoOutput(true);
        params.append("param").append("=").append(JSON.toJSONString(appParam));
        String aa =params.toString();
        System.out.println(aa);
        byte[] bypes = params.toString().getBytes();
        connection.getOutputStream().write(bypes);// 输入参数
		// 发送
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String response = in.readLine();
		System.out.println(response);
	}
	
}
