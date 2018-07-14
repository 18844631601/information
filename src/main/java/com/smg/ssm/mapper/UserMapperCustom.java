package com.smg.ssm.mapper;

import java.util.List;

import com.smg.ssm.po.User;
import com.smg.ssm.po.UserCustom;
import com.smg.ssm.po.UserVo;

/**
 * <p>Title: UserMapperCustom</p>
 * <p>Description: 用户映射接口扩展类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年6月19日 下午1:03:28
 * @version 1.0
 */
public interface UserMapperCustom {
	/**
	 * <p>Title: selectUserList</p>
	 * <p>Description: 根据不同条件查询用户集合</p>
	 * @param userVo
	 * @return
	 */
	List<UserCustom> selectUserList(UserVo userVo);
	
	/**
	 * <p>Title: selectUserByIdAndPw</p>
	 * <p>Description: 根据账号密码查用户</p>
	 * @param user
	 * @return
	 */
	User selectUserByIdAndPw(User user);
}
