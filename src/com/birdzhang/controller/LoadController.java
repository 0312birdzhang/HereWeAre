/**
 * Coypright © 2016 Flamingo inc
 */
package com.birdzhang.controller;

import com.birdzhang.impl.Ret;
import com.demo.common.model.User;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.kit.StrKit;

/**
 * @author debo.zhang
 *	获取附近的人
 */
public class LoadController extends Controller{
	
	
	public void index(){
		String osType = getPara("ostype");
		String longitude = getPara("longitude");
		String latitude = getPara("latitude");
		Ret msg = new Ret();
		if(StrKit.isBlank(osType) || StrKit.isBlank(latitude)||StrKit.isBlank(longitude)){
			msg.setResult(false);
			msg.setMsg("latlong is need");
			msg.setCode(403);
			renderJson(msg);
			return;
		}
		User user = new User();
		Integer scale = getParaToInt("scale",1000); //1000米之内
		int pageNumber = getParaToInt("pagenum", 1);
		int pageSize = getParaToInt("pagesize", Integer.MAX_VALUE);
		renderJson(JsonKit.toJson(user.nearBy(pageNumber, pageSize, scale, osType, latitude, longitude)));
	}
	
	
}
