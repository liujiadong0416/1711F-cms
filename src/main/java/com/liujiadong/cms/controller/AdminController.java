package com.liujiadong.cms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/**
 * 
 * @ClassName: AdminController 
 * @Description: 绠＄悊鍛樹腑蹇�
 * @author: 鍒樺槈鏍�
 * @date: 2020骞�3鏈�6鏃� 涓婂崍10:01:00
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.stat.TableStat.Mode;
import com.github.pagehelper.PageInfo;
import com.liujiadong.cms.bean.Article;
import com.liujiadong.cms.bean.User;
import com.liujiadong.cms.service.ArticleService;
import com.liujiadong.cms.service.UserService;
@RequestMapping("admin")
@Controller
public class AdminController {
	@Resource
	private ArticleService articleService;
	
	@Resource
	private UserService userService;
	/**
	 * 
	 * @Title: admin 
	 * @Description: 杩涘叆绠＄悊棣栭〉
	 * @return
	 * @return: String
	 */
	@RequestMapping(value={"","/","index"})
	public String admin(){
		
		return "admin/index";
	}
	
	/**
	 * 
	 * @Title: articles 
	 * @Description: 
	 * @return:鏌ヨ鏂囩珷鎵�鏈変俊鎭�
	 * @return: String
	 */
	@RequestMapping("articles")
	public String articles(Model model,Article article,@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "3")Integer pagesize){
		
		PageInfo<Article> selects = articleService.selects(article, pageNum, pagesize);
		model.addAttribute("info", selects);
		return "admin/article";
	}
	/**
	 * 
	 * @Title: publish 
	 * @Description: 鍘诲彂甯冩枃绔�
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
	 * @Title: admin 
	 * @Description: 淇敼鏂囩珷鐘舵��
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@RequestMapping("update")
	public Boolean update(Article article){
		
		int update = articleService.update(article);
		return update>0;
	}
	
	@RequestMapping("users")
	public String users(Model model,User user,@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "3")Integer pagesize){
		PageInfo<User> select = userService.select(user, pageNum, pagesize);
		model.addAttribute("info", select);
		model.addAttribute("user", user);
		return "admin/users";
	}
	
	@ResponseBody
	@RequestMapping("updateUser")
	public Boolean updateUser(User user){
		int update = userService.update(user);
		return update>0;
	}
}
