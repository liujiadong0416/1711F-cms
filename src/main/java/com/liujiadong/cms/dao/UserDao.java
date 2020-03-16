package com.liujiadong.cms.dao;

import java.util.List;

import com.liujiadong.cms.bean.User;

public interface UserDao {
	/**
	 * 
	 * @Title: select 
	 * @Description: 查找用户
	 * @param user
	 * @return
	 * @return: List<User>
	 */
	List<User> select(User user);
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改用户信息
	 * @param user
	 * @return
	 * @return: int
	 */
	int update(User user);
	/**
	 * 
	 * @Title: update 
	 * @Description: 添加用户信息
	 * @param user
	 * @return
	 * @return: int
	 */
	int insert(User user);
	/**
	 * 
	 * @Title: update 
	 * @Description: 查询用户信息
	 * @param user
	 * @return
	 * @return: int
	 */
	User username(String username);
}
