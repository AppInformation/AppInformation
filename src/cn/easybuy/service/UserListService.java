package cn.easybuy.service;

import cn.easybuy.entity.Page;
import cn.easybuy.entity.User;

public interface UserListService {
	/**
	 * ��ҳ
	 * @param index
	 * @param sum
	 * @return
	 */
	public Page Select(int index);
	/**
	 * ɾ���û�
	 * @param id
	 * @return
	 */
	public int delete(int id);
	/**
	 * �޸��û�
	 */
	public int update(User user);
	/**
	 * ����id��ѯ�û�
	 */
	public User SelectId(int dd);
}
