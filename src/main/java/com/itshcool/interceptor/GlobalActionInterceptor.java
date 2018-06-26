package com.itshcool.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

/**
 * 全局拦截器
 * @author chaojunma
 * @date 2018年6月26日
 */
public class GlobalActionInterceptor implements Interceptor{

	/**
	 * 常规拦截器
	 */
	public void intercept(Invocation inv) {
		Controller controller = inv.getController();
		String username = controller.getSessionAttr("username");
		// 用户如果没有登录，那么就跳转到登录页面
		if (username == null || username.equals("")) {
			controller.setAttr("statusCode", 200);
			controller.setAttr("message", "用户未登录");
			controller.renderJson();
		} else {
			inv.invoke();
		}
	}
}
