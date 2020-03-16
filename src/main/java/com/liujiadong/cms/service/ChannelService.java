package com.liujiadong.cms.service;

import java.util.List;

import com.liujiadong.cms.bean.Category;
import com.liujiadong.cms.bean.Channel;

public interface ChannelService {
	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询所有栏目
	 * @return
	 * @return: List<Channel>
	 */
	List<Channel> selects();
	/**
	 * 
	 * @Title: selects 
	 * @Description: 根据栏目查询分类
	 * @return
	 * @return: List<Channel>
	 */
	List<Category> selectsCategory(Integer id);
}
