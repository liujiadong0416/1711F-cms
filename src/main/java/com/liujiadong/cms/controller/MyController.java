package com.liujiadong.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.liujiadong.cms.bean.Article;
import com.liujiadong.cms.bean.Collect;
import com.liujiadong.cms.bean.User;
import com.liujiadong.cms.service.ArticleService;
import com.liujiadong.cms.service.CollectService;

/**
 * 
 * @ClassName: MyController 
 * @Description: 个人中心
 * @author: 刘嘉栋
 * @date: 2020年3月4日 上午10:50:46
 */
@RequestMapping("my")
@Controller
public class MyController {
	@Resource
	private ArticleService articleService;
	@Resource
	private CollectService collectService;
	/**
	 * 
	 * @Title: index 
	 * @Description: 进入个人中心的首页
	 * @return
	 * @return: String
	 */
	@RequestMapping(value={"","/","index"})
	public String index(){
		
		return "my/index";
	}
	/**
	 * 
	 * @Title: articles 
	 * @Description: 我的文章
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles")
	public String articles(Model model,HttpSession session, @RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "3")Integer pagesize){
		Article articles = new Article();
		User user = (User) session.getAttribute("user");
		articles.setUserId(user.getId());
		PageInfo<Article> selects = articleService.selects(articles, pageNum, pagesize);
		model.addAttribute("info", selects);
		return "my/article";
	}
	/**
	 * 
	 * @Title: publish 
	 * @Description: 去发布文章
	 * @return
	 * @return: String
	 */
	@GetMapping("publish")
	public String publish(){
		
		return "my/publish";
	}
	/**
	 * 
	 * @Title: publish 
	 * @Description: 去发布文章
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@RequestMapping("articleDetail")
	public Article articleDetail(Integer id){
		Article a=articleService.sele(id);
		return a;
	}
	/**
	 * 
	 * @Title: articles 
	 * @Description: 发布文章
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@PostMapping("publish")
	public boolean publish(MultipartFile file,Article article,HttpSession session){
		//文件上传
		if(!file.isEmpty()){
			String path="d:/pic/";
			String originalFilename = file.getOriginalFilename();
			String end = originalFilename.substring(originalFilename.lastIndexOf("."));
			String start = UUID.randomUUID().toString();
			File file2 = new File(path+start+end);
			try {
				file.transferTo(file2);
				article.setPicture(start+end);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//文章初始数据
		User user = (User) session.getAttribute("user");
		article.setUserId(user.getId());
		article.setCreated(new Date());
		article.setHits(0);//点击量默认 0
		article.setDeleted(0);//默认未删除
		article.setHot(0);//默认非热门
		article.setStatus(0);//默认待审核
		return articleService.insert(article)>0;
	}
	/**
	 * 
	 * @Title: publish 
	 * @Description: 我的收藏
	 * @return
	 * @return: String
	 */
	
	@RequestMapping("collect")
	public String collect(HttpSession session,Model model,@RequestParam(defaultValue="1")Integer pageNum){
		User u = (User) session.getAttribute("user");
		PageInfo<Collect> selects = collectService.selects(u.getId(),pageNum);
		model.addAttribute("info", selects);
		return "my/collect";
	}
}
