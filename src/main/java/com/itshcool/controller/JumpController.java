package com.itshcool.controller;

import com.itshcool.annotation.JAction;
import com.itshcool.constant.Constants;
import com.itshcool.model.UserInfo;
import com.jfinal.core.Controller;

/**
 * 页面跳转控制器
 * @author chaojunma
 * @date 2018年6月27日
 */
@JAction("/jump")
public class JumpController extends Controller{

	public void index() {
		// 获取当前登录用户
		UserInfo user = getSessionAttr(Constants.CURRENT_USER);
		// 重新放入session, 否则模板不会渲染
		setSessionAttr(Constants.CURRENT_USER, user);
		String view = getPara(0) + ".html";
		render(view);
	}
	
}
