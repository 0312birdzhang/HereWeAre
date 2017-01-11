/**
 * Coypright © 2016 Flamingo inc
 */
package com.birdzhang.controller;



import com.birdzhang.impl.Ret;
import com.demo.common.model.User;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * @author debo.zhang
 *	上报
 */
public class ReportController extends Controller{
	
	@Before(ReportValidate.class)
	public void index(){
		String imei = getPara("imei");
		String nickName = getPara("nickname");
		String longitude = getPara("longitude");
		String latitude = getPara("latitude");
		String token = getPara("token");
		String osType = getPara("ostype");
		User user = new User();
		Ret ret = new Ret();
		user.setImei(imei);
		user.setLatitude(latitude);
		user.setLongitude(longitude);
		user.setNickName(nickName);
		user.setToken(token);
		user.setOsType(osType);
		boolean flag = user.save();
		ret.setResult(flag);
		if(flag){
			ret.setCode(200);
			ret.setExt(String.valueOf(user.getId()));
			ret.setMsg("You are registed");
		}else{
			ret.setCode(521);
		}
		
		renderJson(ret);
	}
	
	@Before(ReportValidate.class)
	public void update(){
		Integer id = getParaToInt("id");
		Ret ret = new Ret();
		if(null == id){
			ret.setMsg("Your id is empty");
			ret.setCode(403);
			ret.setResult(false);
			renderJson(ret);
		}
		String imei = getPara("imei");
		String token = getPara("token");
		String longitude = getPara("longitude");
		String latitude = getPara("latitude");
		User user = new User();
		user.upLaLo(longitude, latitude, imei, token);
		
		ret.setCode(200);
		ret.setMsg("Position updated");
		ret.setResult(true);
		renderJson(ret);
	}
}
