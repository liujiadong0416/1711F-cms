package com.liujiadong.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liujiadong.cms.bean.Collect;
import com.liujiadong.cms.dao.CollectDao;
import com.liujiadong.cms.service.CollectService;
@Service
public class CollectServiceImpl implements CollectService {
	@Resource
	private CollectDao collectDao;
	@Override
	public int insert(Collect collect) {
		// TODO Auto-generated method stub
		return collectDao.insert(collect);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return collectDao.delete(id);
	}

	@Override
	public PageInfo<Collect> selects(Integer userId,Integer pageNum) {
		PageHelper.startPage(pageNum, 5);
		List<Collect> selects = collectDao.selects(userId);
		return new PageInfo<>(selects);
	}

	@Override
	public Collect selectByTitleAndUserId(String title, Integer userId) {
		// TODO Auto-generated method stub
		return collectDao.selectByTitleAndUserId(title, userId);
	}

}
