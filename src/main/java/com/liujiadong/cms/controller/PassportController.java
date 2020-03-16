package com.liujiadong.cms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liujiadong.cms.bean.User;
import com.liujiadong.cms.service.UserService;
import com.liujiadong.cms.utils.CMSException;
import com.liujiadong.cms.utils.Result;

@RequestMapping("passport")
@Controller
public class PassportController {
	@Resource
	private UserService userService;
	/**
	 * 
	 * @Title: reg 
	 * @Description: 去注册页面
	 * @return
	 * @return: String
	 */
	@RequestMapping("reg")
	public String reg(){
		
		return "passport/reg";
	}
	/**
	 * 
	 * @Title: reg 
	 * @Description: 去登陆页面
	 * @return
	 * @return: String
	 */
	@RequestMapping("login")
	public String login(){
		
		return "passport/login";
	}
	/**
	 * 
	 * @Title: adminlogin 
	 * @Description: 管理员登录页面
	 * @return
	 * @return: String
	 */
	@RequestMapping("adminlogin")
	public String adminlogin(){
		
		return "passport/adminlogin";
	}
	/**
	 * 
	 * @Title: reg 
	 * @Description: 注册
	 * @return
	 * @return: boolean
	 */
	@PostMapping("reg")
	@ResponseBody
	public Result<User> reg(User user,Model model) {
		Result<User> result = new Result<User>();
		try {
			if(userService.insert(user) >0){
				result.setCode(200);
				result.setMsg("注册成功");
			}
		} catch (CMSException e) {
			result.setCode(300);
			result.setMsg("注册失败"+e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setMsg("注册失败,请联系管理员");
		}
		return result;
		
	}
	/**
	 * 
	 * @Title: login 
	 * @Description: 登录
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 * @return: Result<User>
	 */
	@PostMapping("login")
	@ResponseBody
	public Result<User> login(User user,Model model,HttpSession session) {
		Result<User> result = new Result<User>();
		try {
			User login = userService.login(user);
			if(null!=login){
				result.setCode(200);
				result.setMsg("登录成功");
				if(login.getRole()==0){
					session.setAttribute("user", login);
				}else{
					session.setAttribute("admin", login);
				}
			}
		} catch (CMSException e) {
			e.printStackTrace();
			result.setCode(300);
			result.setMsg("登录失败"+e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setMsg("登录失败,遇到不可预测错误,请联系管理员");
		}
		return result;
		
	}
	/**
	 * 
	 * @Title: logout 
	 * @Description:注销
	 * @return
	 * @return: String
	 */
	@GetMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	/**
	 * 
	 * @Title: logout 
	 * @Description: 根据名字查找用户
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@PostMapping("checkName")
	public boolean checkName(String username){
		return	userService.username(username)==null;
	}
}
