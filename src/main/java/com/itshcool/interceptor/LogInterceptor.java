package com.itshcool.interceptor;

import java.util.Map;
import com.itshcool.constant.Constants;
import com.itshcool.model.SysLog;
import com.itshcool.model.UserInfo;
import com.itshcool.util.CommUtil;
import com.itshcool.util.Result;
import com.itshcool.util.ResultCode;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.json.JFinalJson;
import com.jfinal.render.JsonRender;

/**
 * 日志拦截器
 * @author chaojunma
 * @date 2018年7月3日
 */
public class LogInterceptor implements Interceptor{

	@Override
	public void intercept(Invocation inv) {
		SysLog log = doBefore(inv);
		try {
			inv.invoke();
			log.set("level", "info");
			//操作结果
			String result = ((JsonRender)inv.getController().getRender()).getJsonText();
			result = result.replaceAll("\"data\":.*,", "");
			log.set("result", result);
		} catch (Exception e) {
			inv.getController().renderJson(new Result(ResultCode.SERVER_ERROR));
			log.set("result", e.getMessage());
			log.set("level", "error");
		}
		// 保存log信息
		log.save();
	}
	
	
	public SysLog doBefore(Invocation inv){
		SysLog log = new SysLog();
		Controller controller = inv.getController();
		UserInfo user = controller.getSessionAttr(Constants.CURRENT_USER);
		if(user != null) {
			// 设置操作用户
			log.set("user_id", user.get("id"));
		}
		// 设置请求地址
		log.set("url", inv.getActionKey());
		// 设置请求参数
		Map<String, String[]> params= controller.getRequest().getParameterMap();
		log.set("params", JFinalJson.getJson().toJson(params));
		// 设置请求IP
		log.set("ip", CommUtil.getIpAddress(controller.getRequest()));
		return log;
	}
	
	

}
