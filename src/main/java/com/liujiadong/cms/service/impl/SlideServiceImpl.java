package com.liujiadong.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liujiadong.cms.bean.Slide;
import com.liujiadong.cms.dao.SlideDao;
import com.liujiadong.cms.service.SlideService;
@Service
public class SlideServiceImpl implements SlideService {
	@Resource
	private SlideDao slideDao;
	@Override
	public List<Slide> selects() {
		// TODO Auto-generated method stub
		return slideDao.selects();
	}

}
