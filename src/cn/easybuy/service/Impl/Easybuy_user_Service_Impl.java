package cn.easybuy.service.Impl;

import cn.easybuy.dao.Easybuy_user_Dao;
import cn.easybuy.dao.Impl.Easybuy_user_Dao_Impl;
import cn.easybuy.entity.User;
import cn.easybuy.service.Easybuy_user_Service;

public class Easybuy_user_Service_Impl implements Easybuy_user_Service {

	@Override
	public User Login(String loginName, String password) {
		Easybuy_user_Dao esd = new Easybuy_user_Dao_Impl();
		User es = null;
		try {
			es = esd.Login(loginName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return es;
	}

	@Override
	public int Register(User id) {
		int se = 0;
		try {
			se = new Easybuy_user_Dao_Impl().Register(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return se;
	}

	@Override
	public int Verification(String yan) {
		Easybuy_user_Dao ad = new Easybuy_user_Dao_Impl();
		int result = 0;
		try {
			result = ad.Verification(yan);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
