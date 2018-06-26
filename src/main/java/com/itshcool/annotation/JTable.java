package com.itshcool.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据表扫描,自动为数据表添加映射
 * @author chaojunma
 * @date 2018年6月26日
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface JTable {

	  /**
     * 数据源绑定的数据库名称
     */
    String DB_NAME = "default-db";

    /**
     * 数据表名
     */
    String tableName();

    /**
     * 数据表主键
     */
    String id() default "id";

    /**
     * 数据库名称
     */
    String dbName() default DB_NAME;

    /**
     * sql路径
     */
    String sqlTemplate() default "";
    
}
