package com.itshcool.service;

import com.itshcool.model.ClassInfo;
import com.itshcool.param.PageParam;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.SqlPara;

public class ClassService {
	
	private static final ClassInfo dao = new ClassInfo();
	
	/**
	 * 分页查询
	 * @param param
	 * @return
	 */
	public Page<ClassInfo> list(PageParam param){
    	Kv para = Kv.by("key", param.getKey())
    			                .set("createTime", param.getCreateTime())
    			                .set("order", param.getOrder());
    	SqlPara sqlPara = Db.getSqlPara("class.findByPage", para);
    	return dao.paginate(param.getPage(), param.getLimit(), sqlPara);
    }
	
}
