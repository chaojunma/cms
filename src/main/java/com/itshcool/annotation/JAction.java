package com.itshcool.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * controller扫描,自动分发controller路径
 * @author chaojunma
 * @date 2018年6月26日
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface JAction {

	/**
	 * controller路由,请求链接
	 */
	String value();

	/**
	 * 请求页面位置
	 */
	String viewPath() default "";
}
