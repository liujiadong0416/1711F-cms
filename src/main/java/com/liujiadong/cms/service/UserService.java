package com.liujiadong.cms.service;

import com.github.pagehelper.PageInfo;
import com.liujiadong.cms.bean.User;

public interface UserService {
	/**
	 * 
	 * @Title: select 
	 * @Description: 查找用户信息
	 * @param user
	 * @param pageNum
	 * @param pagesize
	 * @return
	 * @return: PageInfo<User>
	 */
	PageInfo<User> select(User user,Integer pageNum,Integer pagesize);
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
	/**
	 * 
	 * @Title: update 
	 * @Description: ��¼
	 * @param user
	 * @return
	 * @return: int
	 */
	User login(User user);
}
