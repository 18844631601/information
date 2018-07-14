package com.smg.ssm.po;

/**
 * <p>Title: PatentCustom</p>
 * <p>Description: 专利拓展类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年7月7日 上午8:42:42
 * @version 1.0
 */
public class PatentCustom extends Patent{
   
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}