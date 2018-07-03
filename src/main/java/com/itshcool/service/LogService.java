package com.itshcool.service;

import com.itshcool.model.SysLog;
import com.itshcool.param.LogQueryParam;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.SqlPara;

public class LogService {

	private static final SysLog dao = new SysLog();
	
	/**
	 * 日志分页查询
	 * @param param
	 * @return
	 */
	public Page<SysLog> list(LogQueryParam param){
		Kv para = Kv.by("key", param.getKey())
								.set("order", param.getOrder())
								.set("createTime", param.getCreateTime())
								.set("level", param.getLevel());
		SqlPara sqlPara = Db.getSqlPara("log.findByPage", para);
		return dao.paginate(param.getPage(), param.getLimit(), sqlPara);
	}
	
}
