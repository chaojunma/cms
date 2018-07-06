package com.itshcool.model;

import com.itshcool.annotation.JTable;
import com.jfinal.plugin.activerecord.Model;

/**
 * 课程分类
 * @author chaojunma
 * @date 2018年7月6日
 */
@JTable(tableName="classify", sqlTemplate="classify.sql")
public class Classify extends Model<Classify>{
	
	private static final long serialVersionUID = 1L;

}
