package com.smg.ssm.po;

import java.util.List;

/**
 * <p>Title: UserVo</p>
 * <p>Description: 用户封装类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年6月19日 下午12:56:42
 * @version 1.0
 */
public class UserVo {
	private User user;
	
	private UserCustom userCustom;
	
	private List<UserCustom> userCustomList;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<UserCustom> getUserCustomList() {
		return userCustomList;
	}

	public void setUserCustomList(List<UserCustom> userCustomList) {
		this.userCustomList = userCustomList;
	}
}
