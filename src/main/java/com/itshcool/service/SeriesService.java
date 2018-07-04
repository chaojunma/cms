package com.itshcool.service;

import com.itshcool.model.ClassSeries;
import com.itshcool.param.SeriesQueryParam;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.SqlPara;

public class SeriesService {
	
	private static final ClassSeries dao = new ClassSeries();
	
	
	/**
	 * 分页查询
	 * @param param
	 * @return
	 */
	public Page<ClassSeries> list(SeriesQueryParam param){
    	Kv para = Kv.by("key", param.getKey())
    			                .set("order", param.getOrder())
    			                .set("createTime", param.getCreateTime());
    	SqlPara sqlPara = Db.getSqlPara("series.findByPage", para);
    	return dao.paginate(param.getPage(), param.getLimit(), sqlPara);
    }
}
