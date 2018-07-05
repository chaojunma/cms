package com.itshcool.controller;

import java.util.HashMap;
import java.util.Map;
import com.itshcool.annotation.JAction;
import com.itshcool.interceptor.LogInterceptor;
import com.itshcool.util.QiniuFileUtil;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.jfinal.upload.UploadFile;

/**
 * 文件上传控制器
 * @author chaojunma
 * @date 2018年7月5日
 */
@JAction("/upload")
public class FileUploadController extends Controller{

	@Before(LogInterceptor.class)
	public void index() throws Exception{
		UploadFile file = getFile();
		// 获取文件的后缀 
		String type = file.getFileName().substring(file.getFileName().lastIndexOf("."));  
		// 对文件重命名取得的文件名+后缀  
		String  fileName = System.currentTimeMillis() + type; 
		String cover = QiniuFileUtil.upload(file);
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> data = new HashMap<String,Object>();
		result.put("code",0);//0表示成功，1失败
		result.put("msg","上传成功");//提示消息
        data.put("src",PropKit.get("path") + cover);//图片url
        data.put("title", fileName);//图片名称，这个会显示在输入框里
        result.put("data",data);
        renderJson(result);
	}
	
}
