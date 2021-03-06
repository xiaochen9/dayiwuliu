package com.tianrui.api.req.app;

import com.tianrui.api.req.BaseReq;

public class AppMemberReq extends BaseReq{

	private static final long serialVersionUID = 1L;
	//登录手机号
	private String account;
	//密码加密串
	private String pswdMd5;
	//验证码
	private String authCode;
	// 0:密码登录  1:验证码登录
	private int loginType=0;
	//默认为空  1为强制登录
	private String loginMast;
	//用户名
	private String nickname;
	//头像
	private String imgStr;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPswdMd5() {
		return pswdMd5;
	}
	public void setPswdMd5(String pswdMd5) {
		this.pswdMd5 = pswdMd5;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public int getLoginType() {
		return loginType;
	}
	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}
	public String getLoginMast() {
		return loginMast;
	}
	public void setLoginMast(String loginMast) {
		this.loginMast = loginMast;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getImgStr() {
		return imgStr;
	}
	public void setImgStr(String imgStr) {
		this.imgStr = imgStr;
	}
	
}
