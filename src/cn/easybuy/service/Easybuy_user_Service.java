package cn.easybuy.service;

import cn.easybuy.entity.User;

public interface Easybuy_user_Service {
	/**
	 * ��½
	 * @param loginName ��½�˻�
	 * @param password ��½����
	 * @return
	 */
	public User Login(String loginName,String password);
	/**
	 * ע��
	 * @param id
	 * @return
	 */
	public int Register(User id);
	/**
	 * ��֤
	 * @return
	 */
	public int Verification(String yan);
}
