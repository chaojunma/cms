package com.itshcool.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jfinal.handler.Handler;


/**
 * XssHandler类(实现类似Filter过滤器功能)
 * @author chaojunma
 * @date 2018年7月12日
 */
public class XssHandler extends Handler{

	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		request = new XsslHttpServletRequestWrapper(request);
		 next.handle(target, request, response, isHandled);
	}

}
