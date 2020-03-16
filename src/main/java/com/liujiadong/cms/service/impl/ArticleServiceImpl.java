package com.liujiadong.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liujiadong.cms.bean.Article;
import com.liujiadong.cms.dao.ArticleDao;
import com.liujiadong.cms.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {
	@Resource
	private ArticleDao articleDao;
	@Override
	public int insert(Article article) {
		//增加评论
		return articleDao.insert(article);
	}

	@Override
	public PageInfo<Article> selects(Article articles,Integer pageNum,Integer pagesize) {
		PageHelper.startPage(pageNum, pagesize);
		List<Article> selects = articleDao.selects(articles);
		return new PageInfo<>(selects);
	}

	@Override
	public Article sele(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.sele(id);
	}

	@Override
	public int update(Article articles) {
		// TODO Auto-generated method stub
		System.out.println(articles);
		return articleDao.update(articles);
	}

}
