package com.liujiadong.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liujiadong.cms.bean.Article;
import com.liujiadong.cms.bean.Comment;
import com.liujiadong.cms.dao.CommentDao;
import com.liujiadong.cms.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
	@Resource
	private CommentDao commentDao;
	@Override
	public int insert(Comment comment) {
		try {
			//增加评论
			commentDao.insert(comment);
			//改变文章评论数据
			commentDao.updateArticle(comment.getArticleId());
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public PageInfo<Comment> selects(Article article,Integer pageNum) {
		PageHelper.startPage(pageNum, 10);
		List<Comment> selects = commentDao.selects(article);
		return new PageInfo<>(selects);
	}

	@Override
	public PageInfo<Article> select(int pageNum) {
		PageHelper.startPage(pageNum, 10);
		List<Article> selects = commentDao.select();
		return new PageInfo<>(selects);
	}

}
