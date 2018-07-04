package com.itshcool.model;

import com.itshcool.annotation.JTable;
import com.jfinal.plugin.activerecord.Model;

/**
 * 课程系列
 * @author chaojunma
 * @date 2018年7月4日
 */
@JTable(tableName="class_series", sqlTemplate="class_series.sql")
public class ClassSeries extends Model<ClassSeries>{

	private static final long serialVersionUID = 1L;

}
