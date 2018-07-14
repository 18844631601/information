package com.smg.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smg.ssm.mapper.UserMapper;
import com.smg.ssm.mapper.UserMapperCustom;
import com.smg.ssm.po.User;
import com.smg.ssm.po.UserCustom;
import com.smg.ssm.po.UserVo;
import com.smg.ssm.service.UserService;

/**
 * <p>Title: UserServiceImpl</p>
 * <p>Description: 用户服务实现类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年6月19日 下午12:48:03
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserMapperCustom userMapperCustom;

	/**
	 * <p>Title: selectUser</p>
	 * <p>Description: 查询单个用户</p>
	 * @param userId
	 * @return User
	 */
	@Override
	public User selectUser(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	/**(non-Javadoc)
	 * <p>Title: selectUserByIdAndPw</p>
	 * <p>Description: 根据账号密码查用户</p>
	 * @param userId
	 * @param userPw
	 * @return int
	 * @see com.smg.ssm.service.UserService#selectUserByIdAndPw(java.lang.Integer, java.lang.String)
	 */
	@Override
	public int selectUserByIdAndPw(User user) {
		int result = 0;
		if(user.getUserId() == null || user.getUserPw() == null || user.getUserPw() == "") {
			return result;
		}
		user =  userMapperCustom.selectUserByIdAndPw(user);
		if(user != null) {
			result = 1;
		}
		return result;
	}

	/**(non-Javadoc)
	 * <p>Title: addUser</p>
	 * <p>Description: </p>
	 * @param user
	 * @return int
	 * @see com.smg.ssm.service.UserService#addUser(com.smg.ssm.po.User)
	 */
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		user.setUserType(1);
		user.setUserIsadmin(0);
		user.setUserState(1);
		return userMapper.insertSelective(user);
	}

	/*@Override
	public List<UserCustom> selectUserList(Integer index, String selectString) {
		List<UserCustom> userCustomList = new ArrayList<UserCustom>();
		UserCustom userCustom = new UserCustom();
		UserVo userVo = new UserVo();
		switch(index) {
			case 1:
				userCustom.setUserType(1);break;
			case 2:
				userCustom.setUserType(2);break;
			default:return userCustomList;
		}
		userCustom.setUserName(selectString);
		
		userVo.setUserCustom(userCustom);
		userCustomList = userMapperCustom.selectUserList(userVo);
		return userCustomList;
	}*/
	
}
