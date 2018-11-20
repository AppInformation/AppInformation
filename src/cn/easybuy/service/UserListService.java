package cn.easybuy.service;

import cn.easybuy.entity.Page;
import cn.easybuy.entity.User;

public interface UserListService {
	/**
	 * 分页
	 * @param index
	 * @param sum
	 * @return
	 */
	public Page Select(int index);
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
