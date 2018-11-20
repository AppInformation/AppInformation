package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.User;

public interface UserListDao {
	/**
	 *用户列表查询总行数
	 * @return
	 */
	public int SelectUser();
	/**
	 * 分页
	 * @param index
	 * @param sum
	 * @return
	 */
	public List<User> PageUser(int index,int sum);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int delete(int id);
	/**
	 * 修改用户
	 */
	public int update(User user);
	/**
	 * 根据id查询用户
	 */
	public User SelectId(int dd);
}
