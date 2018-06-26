package com.itshcool.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;


/**
 * 登录验证
 * @author chaojunma
 * @date 2018年6月26日
 */
public class LoginValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		validateRequiredString("userName", "nameMsg", "请输入用户名");
		validateRequiredString("password", "passMsg", "请输入密码");
	}

	@Override
	protected void handleError(Controller c) {
		c.render("/WEB-INF/views/login.html");
	}

}
