package com.demo.common.model;

import java.util.List;

import com.demo.common.model.base.BaseUser;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	public static final User dao = new User();
	
	/**
	 * 分页查询用户
	 * @author debo.zhang
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<User> paginate(int pageNumber, int pageSize,String osType) {
		return paginate(pageNumber, pageSize, "select nickName,latitude,longitude,id ", "from user where osType = ? order by id asc",osType);
	}
	
	/**
	 * 更新坐标
	 * @author debo.zhang
	 */
	public void upLaLo(String longitude,String latitude,String imei,String token){
		String sql = "update user set longitude = ?,latitude = ? where imei = ? and token = ?";
		Db.update(sql, longitude,latitude,imei,token);
	}
	
	/**
	 * 寻找附件的人
	 * @author debo.zhang
	 * @param pageNumber
	 * @param pageSize
	 * @param scale
	 * @param osType
	 * @return
	 */
	public List<User> nearBy(int pageNumber, int pageSize,Integer scale,String osType,String latitude,String longitude){
		String sql = "SELECT id, (3959 * acos(cos(radians( ? )) * cos(radians(latitude)) * cos(radians(longitude) - radians(?)) + sin(radians(?)) * sin(radians(latitude )))) AS distance,"
				+ " latitude,longitude,nickName,osType" +
					" FROM `user` " +
				" HAVING distance < ? and osType = ?" +
				" ORDER BY distance";
		return find(sql, latitude,longitude,latitude,scale,osType);
	}
	
}
