package com.itshcool.controller;

import com.itshcool.annotation.JAction;
import com.jfinal.core.Controller;

/**
 * 页面跳转控制器
 * @author chaojunma
 * @date 2018年6月27日
 */
@JAction("/jump")
public class JumpController extends Controller{

	public void index() {
		String view = getPara(0) + ".html";
		render(view);
	}
	
}
