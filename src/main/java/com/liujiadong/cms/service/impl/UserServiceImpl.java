package com.liujiadong.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liujiadong.cms.bean.User;
import com.liujiadong.cms.dao.UserDao;
import com.liujiadong.cms.service.UserService;
import com.liujiadong.cms.utils.CMSException;
import com.liujiadong.cms.utils.Md5Util;
import com.liujiadong.commoon.utils.StringUtil;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Override
	public PageInfo<User> select(User user,Integer pageNum,Integer pagesize) {
		PageHelper.startPage(pageNum, pagesize);
		List<User> select = userDao.select(user);
		PageInfo<User> info=new PageInfo<>(select);
		return info;
	}
	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}
	@Override
	public int insert(User user) {
		//用户名
		if(!StringUtil.hasText(user.getUsername()))
		throw new CMSException("用户名不能为空");
		if(!(user.getUsername().length()>=2&&user.getUsername().length()<=10))
		throw new CMSException("用户名长度2-10之间");
		User username = this.username(user.getUsername());
		if(null!=username){
			throw new CMSException("鐢ㄦ埛鍚嶅凡瀛樺湪");
		}
		//密码
		if(!StringUtil.hasText(user.getPassword()))
		throw new CMSException("密码不能为空");
		if(!(user.getPassword().length()>=6&&user.getPassword().length()<=10))
		throw new CMSException("密码长度6-10之间");
		
		//确认密码
		if(!StringUtil.hasText(user.getRepassword()))
		throw new CMSException("确认密码不能为空");
		if(!user.getRepassword().equals(user.getPassword()))
		throw new CMSException("两次密码不一致");
		
		
		//初始化
		user.setPassword(Md5Util.encode(user.getPassword()));
		user.setCreated(new Date());
		user.setNickname(user.getUsername());
		user.setLocked("0");
		return userDao.insert(user);
	}
	@Override
	public User username(String username) {
		// TODO Auto-generated method stub
		return userDao.username(username);
	}
	@Override
	public User login(User user) {
		
		if(!StringUtil.hasText(user.getUsername()))
		throw new CMSException("用户不能为空");
		
		User username = this.username(user.getUsername());
		if(null==username){
			throw new CMSException("用户不存在");
		}
		
		if(!Md5Util.encode(user.getPassword()).equals(username.getPassword())){
			throw new CMSException("密码不正确");
		}
		
		if(username.getLocked().equals("1")){
			throw new CMSException("用户已禁用");
		}
		return username;
	}

}
