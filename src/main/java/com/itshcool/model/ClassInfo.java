package com.itshcool.model;

import com.itshcool.annotation.JTable;
import com.jfinal.plugin.activerecord.Model;

/**
 * 课程表实体类
 * @author chaojunma
 * @date 2018年7月9日
 */
@JTable(tableName="class_info", sqlTemplate="class_info.sql")
public class ClassInfo extends Model<ClassInfo>{

	private static final long serialVersionUID = 1L;

}
