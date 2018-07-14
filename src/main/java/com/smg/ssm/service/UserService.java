package com.smg.ssm.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smg.ssm.po.User;
import com.smg.ssm.po.UserCustom;

public interface UserService {

	/**
	 * <p>Title: selectUser</p>
	 * <p>Description: 查询单个用户</p>
	 * @return
	 */
	User selectUser(Integer userId);


	/**
	 * <p>Title: selectUserList</p>
	 * <p>Description:  查询用户集合</p>
	 * @param index
	 * @param type
	 * @param selectString
	 * @return
	 */
/*	List<UserCustom> selectUserList(Integer index, String selectString);
*/

	
	
	/**
	 * <p>Title: selectUserByIdAndPw</p>
	 * <p>Description: 根据账号密码查用户</p>
	 * @param user
	 * @return int
	 */
	int selectUserByIdAndPw(User user);


	/**
	 * <p>Title: addUser</p>
	 * <p>Description: 添加用户</p>
	 * @param user
	 * @return int
	 */
	int addUser(User user);

}