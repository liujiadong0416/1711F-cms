package com.liujiadong.cms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liujiadong.cms.bean.Category;
import com.liujiadong.cms.bean.Channel;
import com.liujiadong.cms.service.ChannelService;


@RequestMapping("channel")
@Controller
public class ChannelController {
	@Resource
	private ChannelService channelService;
	/**
	 * 
	 * @ClassName: ChannelController 
	 * @Description: 查询所有栏目
	 * @author: 刘嘉栋
	 * @date: 2020年3月5日 上午10:28:14
	 */
	@ResponseBody
	@RequestMapping("channels")
	public List<Channel> selects(){
		List<Channel> selects = channelService.selects();
		return selects;
	}
	
	/**
	 * 
	 * @ClassName: ChannelController 
	 * @Description:根据栏目查分类
	 * @author: 刘嘉栋
	 * @date: 2020年3月5日 上午10:28:14
	 */
	@ResponseBody
	@RequestMapping("selectsCategory")
	public List<Category> selectsCategory(Integer id){
		List<Category> selects = channelService.selectsCategory(id);
		return selects;
	}
}
