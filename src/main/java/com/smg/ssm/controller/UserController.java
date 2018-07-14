package com.smg.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.smg.ssm.po.User;
import com.smg.ssm.service.UserService;

/**
 * <p>Title: UserController</p>
 * <p>Description: 用户控制类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年7月2日 上午7:28:56
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * <p>Title: addUser</p>
	 * <p>Description: 添加用户</p>
	 * @param user
	 * @return int
	 */
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	@ResponseJSONP
	public int addUser(User user) {
		return userService.addUser(user);
	}
	
	/**
	 * <p>Title: selectUserByIdAndPw</p>
	 * <p>Description: 根据账号密码查用户</p>
	 * @param user
	 * @return
 	 */
	@RequestMapping(value="/selectUserByIdAndPw",method=RequestMethod.POST)
	@ResponseJSONP
	public int selectUserByIdAndPw(User user) {
		return userService.selectUserByIdAndPw(user);
	}
	
	/**
	 * <p>Title: selectUser</p>
	 * <p>Description: 根据id查找用户</p>
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectUser/{userId}",method=RequestMethod.GET)
	@ResponseJSONP
	public String selectUser(@PathVariable("userId") Integer userId) {
		return JSON.toJSONString(userService.selectUser(userId));
	}
	
	/**
	 * <p>Title: selectUserList</p>
	 * <p>Description: 根据选择查找符合条件的用户</p>
	 * @param index
	 * @param selectString
	 * @return
	 */
	/*@RequestMapping(value="/selectUserList/{index}/{selectString}")
	@ResponseJSONP
	public String selectUserList(@PathVariable("index") Integer index, @PathVariable("selectString") String selectString){
		
		return JSON.toJSONString(userService.selectUserList(index, selectString));
	} */
	
	
}
