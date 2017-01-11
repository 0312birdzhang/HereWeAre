/**
 * Coypright © 2016 Flamingo inc
 */
package com.birdzhang.controller;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * @author debo.zhang
 *
 */
public class ReportValidate extends Validator{

	@Override
	protected void validate(Controller c) {
		validateRequiredString("imei", "tips", "imei不能为空");
		validateRequiredString("token", "tips", "token不能为空");
		String key = getActionKey();
		if(key.equals("index")){
			validateRequiredString("nickname", "tips", "nickname不能为空");
			validateRequiredString("latitude", "tips", "latitude不能为空");
			validateRequiredString("longtude", "tips", "longtude不能为空");
			validateRequiredString("ostype", "tips", "ostype不能为空");
		}
		
	}

	@Override
	protected void handleError(Controller c) {
		
	}

}
