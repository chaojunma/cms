package com.itshcool.controller;

import com.itshcool.annotation.JAction;
import com.itshcool.interceptor.LogInterceptor;
import com.itshcool.model.UserInfo;
import com.itshcool.param.UserQueryParam;
import com.itshcool.service.UserService;
import com.itshcool.util.PageResult;
import com.itshcool.util.Result;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

/**
 * 用户控制器
 * @author chaojunma
 * @date 2018年6月29日
 */
@JAction("/user")
public class UserController extends Controller{
	
	private static final UserService userService = new UserService();

	/**
	 * 用户分页查询
	 */
	public void list(){
		UserQueryParam param = getBean(UserQueryParam.class, "");
		Page<UserInfo> data = userService.list(param);
		PageResult<UserInfo> result = new PageResult<>(data);
		renderJson(result);
	}
	
	
	/**
	 * 用户锁定或解锁
	 */
	@Before(LogInterceptor.class)
	public void lockOrUnlock(){
		int userId = getParaToInt("userId");
		int isLock = getParaToInt("isLock");
		UserInfo user = userService.findById(userId);
		user.set("is_lock", isLock);
		userService.saveOrUpdate(user);
		renderJson(new Result());
	}
}
