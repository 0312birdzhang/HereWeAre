/**
 * Coypright © 2016 Flamingo inc
 */
package com.birdzhang.controller;

import com.demo.common.model.Kuaidi;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;

/**
 * @author debo.zhang
 *
 */
public class KuaidiController extends Controller{
	
	public void index(){
		renderJson();
	}

	public void getName(){
		String posttype = getPara("posttype");
		if(StrKit.isBlank(posttype)){
			renderJson();
			return;
		}
		Kuaidi kuaidi = Kuaidi.dao.findById(posttype);
		if(null != kuaidi){
			renderJson(kuaidi);
		}else{
			renderJson();
		}
		
	}
}
