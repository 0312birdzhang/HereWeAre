/**
 * Coypright © 2016 Flamingo inc
 */
package com.birdzhang.controller;

import com.demo.common.model.User;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;

/**
 * @author debo.zhang
 *	获取附近的人
 */
public class LoadController extends Controller{
	
	public void index(){
		String osType = getPara("ostype");
		User user = new User();
		Integer scale = getParaToInt("scale",2000); //缩放比例
		int pageNumber = getParaToInt("pagenum", 1);
		int pageSize = getParaToInt("pagesize", Integer.MAX_VALUE);
		renderJson(JsonKit.toJson(user.nearBy(pageNumber, pageSize, scale, osType)));
	}
	
	
}
