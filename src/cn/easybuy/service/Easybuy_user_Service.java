package cn.easybuy.service;

import cn.easybuy.entity.User;

public interface Easybuy_user_Service {
	/**
	 * µÇÂ½
	 * @param loginName µÇÂ½ÕË»§
	 * @param password µÇÂ½ÃÜÂë
	 * @return
	 */
	public User Login(String loginName,String password);
	/**
	 * ×¢²á
	 * @param id
	 * @return
	 */
	public int Register(User id);
	/**
	 * ÑéÖ¤
	 * @return
	 */
	public int Verification(String yan);
}
