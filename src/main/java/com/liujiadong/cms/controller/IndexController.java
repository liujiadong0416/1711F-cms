package com.liujiadong.cms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.liujiadong.cms.bean.Article;
import com.liujiadong.cms.bean.Category;
import com.liujiadong.cms.bean.Channel;
import com.liujiadong.cms.bean.Collect;
import com.liujiadong.cms.bean.Comment;
import com.liujiadong.cms.bean.Slide;
import com.liujiadong.cms.bean.User;
import com.liujiadong.cms.service.ArticleService;
import com.liujiadong.cms.service.ChannelService;
import com.liujiadong.cms.service.CollectService;
import com.liujiadong.cms.service.CommentService;
import com.liujiadong.cms.service.SlideService;

@Controller
public class IndexController {
	@Resource
	private ChannelService channelService;
	@Resource
	private ArticleService articleService;
	@Resource
	private SlideService slideService;
	@Resource
	private CommentService commentService;
	@Resource
	private CollectService collectService;
	
	@RequestMapping(value={"","/","index"})
	public String index(Model model,Article article,@RequestParam(defaultValue="1")int pageNum){
		//分装数据
		article.setStatus(1);
		article.setDeleted(0);
		model.addAttribute("article", article);
		//宸︿晶鏍忕洰
		List<Channel> channels = channelService.selects();
		model.addAttribute("channels", channels);
		//栏目为空,没有点击栏目,默认热点文章
		if(article.getChannelId()!=null){
			List<Category> selectsCategory = channelService.selectsCategory(article.getChannelId());
			model.addAttribute("selectsCategory", selectsCategory);
		}
		
		if(article.getChannelId()==null){
			article.setHot(1);
			
			List<Slide> list=slideService.selects();
			model.addAttribute("list", list);
		}
		//鏌ヨ鎵�鏈夋枃绔�
		PageInfo<Article> selects = articleService.selects(article, pageNum, 5);
		model.addAttribute("info", selects);
		//鏌ヨ鏈�鏂版枃绔�
		Article article2 = new Article();
		article2.setStatus(1);
		article2.setDeleted(0);
		PageInfo<Article> selects2 = articleService.selects(article2, 1, 10);
		model.addAttribute("selects2", selects2);
		return "index/index";
	}
	/**
	 * 
	 * @Title: articleDetail 
	 * @Description: 查询单个文章
	 * @param id
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("articleDetail")
	public String articleDetail(HttpSession session,int id,Model model,@RequestParam(defaultValue="1")int pageNum){
		Article sele = articleService.sele(id);
		model.addAttribute("article", sele);
		//查询出当前文章的评论
		PageInfo<Comment> selects = commentService.selects(sele, pageNum);
		model.addAttribute("info", selects);
		//查询出所有文章的评论
		PageInfo<Article> selects2 = commentService.select(pageNum);
		model.addAttribute("info2", selects2);
		//判断当前文章是否收藏
		User u = (User) session.getAttribute("user");
		Collect c=null;
		if(u!=null){
			c = collectService.selectByTitleAndUserId(sele.getTitle(), u.getId());
		}
		model.addAttribute("collect", c);
		
		return "index/articleDetail";
	}
	/**
	 * 
	 * @Title: addComment 
	 * @Description: 添加评论
	 * @param comment
	 * @param articleId
	 * @param session
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("addComment")
	public boolean addComment(Comment comment,Integer articleId,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(null ==user)
		return false;//没有登录的用户不能评论
		comment.setUserId(user.getId());
		comment.setArticleId(articleId);
		comment.setCreated(new Date());
		
		return commentService.insert(comment)>0;
	}
	/**
	 * 
	 * @Title: addComment 
	 * @Description: 收藏
	 * @param comment
	 * @param articleId
	 * @param session
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("addCollect")
	public boolean addCollect(Collect collect,HttpSession session) {
		User u = (User) session.getAttribute("user");
		if (u==null) {
			return false;
		}
		collect.setUser(u);
		collect.setCreated(new Date());
		return collectService.insert(collect)>0;
	}
	/**
	 * 
	 * @Title: addComment 
	 * @Description: 取消收藏
	 * @param comment
	 * @param articleId
	 * @param session
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("deleteCollect")
	public boolean deleteCollect(int id) {
		
		return collectService.delete(id)>0;
	}
}
