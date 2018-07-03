package com.itshcool.model;

import com.itshcool.annotation.JTable;
import com.jfinal.plugin.activerecord.Model;

/**
 * 系统日志实体类
 * @author chaojunma
 * @date 2018年7月3日
 */

@JTable(tableName = "sys_log", sqlTemplate = "syslog.sql")
public class SysLog extends Model<SysLog> {

	private static final long serialVersionUID = 1L;

}
