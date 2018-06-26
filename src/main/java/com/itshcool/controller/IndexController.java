package com.itshcool.controller;

import com.itshcool.annotation.JAction;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;

/**
 * 控制器
 * @author chaojunma
 * @date 2018年6月26日
 */


@JAction("/")
public class IndexController extends Controller{

	@Clear
	public void index(){
		render("login.html");
	}
	
}
