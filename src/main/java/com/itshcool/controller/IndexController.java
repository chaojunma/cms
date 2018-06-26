package com.itshcool.controller;

import com.itshcool.annotation.JAction;
import com.itshcool.model.UserInfo;
import com.itshcool.service.UserService;
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
	
	/**
	 * 跳转登录页
	 */
	@Clear
	public void index(){
		render("login.html");
	}
	
	
	/**
	 * 用户登录
	 */
	@Clear
	@Before(LoginValidator.class)
	public void login(){
		UserInfo user = userService.findByName(getPara("userName"), getPara("password"));
		if(user != null) {
			renderJson(user);
		} else {
			renderText("未查询到相关用户");
		}
	}
	
}
