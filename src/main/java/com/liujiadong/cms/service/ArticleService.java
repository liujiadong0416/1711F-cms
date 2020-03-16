package com.liujiadong.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.liujiadong.cms.bean.Article;

public interface ArticleService {
	/**
	 * 
	 * @Title: insert 
	 * @Description:添加文章
	 * @param article
	 * @return
	 * @return: int
	 */
	int insert(Article article);
	/**
	 * 
	 * @Title: selects 
	 * @Description:查询文章
	 * @param articles
	 * @return
	 * @return: List<Article>
	 */
	PageInfo<Article>  selects(Article articles,Integer pageNum,Integer pagesize);
	/**
	 * 
	 * @Title: sele 
	 * @Description: 查询文章为模态框赋值
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article sele(Integer id);
	/**
	 * 
	 * @Title: selects 
	 * @Description:修改文章热门
	 * @param articles
	 * @return
	 * @return: List<Article>
	 */
	int update(Article articles);
}
