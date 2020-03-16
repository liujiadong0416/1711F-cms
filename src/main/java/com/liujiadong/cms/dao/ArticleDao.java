package com.liujiadong.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liujiadong.cms.bean.Article;

public interface ArticleDao {
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
	List<Article>  selects(Article articles);
	/**
	 * 
	 * @Title: selects 
	 * @Description:查询文章为模态框赋值
	 * @param articles
	 * @return
	 * @return: List<Article>
	 */
	Article sele(@Param("id")Integer id);
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
