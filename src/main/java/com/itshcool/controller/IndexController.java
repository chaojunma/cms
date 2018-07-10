package com.itshcool.controller;

import java.util.List;
import com.itshcool.annotation.JAction;
import com.itshcool.constant.Constants;
import com.itshcool.model.Classify;
import com.itshcool.model.UserInfo;
import com.itshcool.service.ClassifyService;
import com.itshcool.service.UserService;
import com.itshcool.util.Result;
import com.itshcool.util.ResultCode;
import com.itshcool.validator.LoginValidator;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;

/**
 * 控制器
 * @author chaojunma
 * @date 2018年6月26日
 */


@JAction("/")
public class IndexController extends Controller{
	
	private static final UserService userService = new UserService();
	
	private static final ClassifyService classifyService = new ClassifyService();
	
	/**
	 * 跳转登录页
	 */
	@Clear
	public void index(){
		render("login.html");
	}
	
	/**
	 * 跳转主页
	 */
	public void admin(){
		render("index.html");
	}
	
	
	/**
	 * 用户登录
	 */
	@Clear
	@Before(LoginValidator.class)
	public void login(){
		String userName = getPara("userName");
		String password = getPara("password");
		UserInfo user = userService.findByName(userName, password);
		if(user != null) {
			user.set("online", 1);
			// 更新在线状态
			userService.saveOrUpdate(user);
			setSessionAttr(Constants.CURRENT_USER, user);
			redirect("/admin");
		} else {
			setAttr("result", new Result(ResultCode.LOGIN_VALID_ERROR));
			render("login.html");
		}
	}
	
	
	/**
	 * 用户注销
	 */
	public void logout(){
		// 清空session
		getSession().invalidate();
		redirect("/");
	}
	
	
	/**
	 * 跳转系列表单页
	 */
	public void series_form(){
		List<Classify> data	= classifyService.findAll();
		setAttr("data", data);
		render("series_form.html");
	}
	
}
