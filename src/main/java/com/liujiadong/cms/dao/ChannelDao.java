package com.liujiadong.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liujiadong.cms.bean.Category;
import com.liujiadong.cms.bean.Channel;

public interface ChannelDao {
	List<Channel> selects();

	List<Category> selectsCategory(@Param("id")Integer id);
}
