package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.User;

public interface UserListDao {
	/**
	 *�û��б��ѯ������
	 * @return
	 */
	public int SelectUser();
	/**
	 * ��ҳ
	 * @param index
	 * @param sum
	 * @return
	 */
	public List<User> PageUser(int index,int sum);
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
