package com.liujiadong.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liujiadong.cms.bean.Category;
import com.liujiadong.cms.bean.Channel;
import com.liujiadong.cms.dao.ChannelDao;
import com.liujiadong.cms.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService {
	@Resource
	private ChannelDao channelDao;
	@Override
	public List<Channel> selects() {
		// TODO Auto-generated method stub
		return channelDao.selects();
	}
	@Override
	public List<Category> selectsCategory(Integer id) {
		// TODO Auto-generated method stub
		return channelDao.selectsCategory(id);
	}

}
