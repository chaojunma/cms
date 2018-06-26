package com.itshcool.config;

import com.itshcool.interceptor.GlobalActionInterceptor;
import com.itshcool.routes.AutoBindRoutes;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.template.Engine;


/**
 * 全局配置
 * @author chaojunma
 * @date 2018年6月26日
 */
public class GlobalConfig extends JFinalConfig{

	
	/**
	 * 配置Jfinal常量值
	 */
	@Override
	public void configConstant(Constants me) {
		// 设置开发模式
		me.setDevMode(true);
		// 初始化配置文件
		PropKit.use("config.properties"); 
	}

	
	/**
	 * 路由配置
	 */
	@Override
	public void configRoute(Routes me) {
		//扫描的包为cn,baseViewPath为WEB-INF/views
        me.add(new AutoBindRoutes("com.itshcool.controller","WEB-INF/views"));
	}

	
	/**
	 * 模板引擎配置
	 */
	@Override
	public void configEngine(Engine me) {
		// devMode 配置为 true，将支持模板实时热加载
		me.setDevMode(true);
	}

	
	/**
	 * 插件配置
	 */
	@Override
	public void configPlugin(Plugins me) {
		
	}

	
	/**
	 * 拦截器配置
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		// 设置全局拦截器
		me.addGlobalActionInterceptor(new GlobalActionInterceptor());
	}

	
	/**
	 * 处理器
	 */
	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("contextPath"));
	}

}
