package cn.easybuy.service.Impl;

import java.util.List;

import cn.easybuy.dao.UserListDao;
import cn.easybuy.dao.Impl.UserListDaoImpl;
import cn.easybuy.entity.Page;
import cn.easybuy.entity.User;
import cn.easybuy.service.UserListService;

public class UserListServiceImpl implements UserListService {

	@Override
	public Page Select(int index) {
		int num  = 10;
		UserListDao user = new UserListDaoImpl();
		List<User> list = user.PageUser(index, num);
		System.out.println("list是"+list);
		int count = user.SelectUser();
		System.out.println("总行数是"+count+"-----------------------------------------");
		int pageCount = count % num  == 0?count/num :count/num +1;
		System.out.println("总页数是"+pageCount+"++++++++++++++++++++++++++++++++++++++++++");
		Page page = new Page();
		page.setPageCount(pageCount);
		page.setList(list);
		page.setPageIndex(index);
		return page;
	}

	@Override
	public int delete(int id) {
		UserListDao user = new UserListDaoImpl();
		int delete = 0;
		try {
			delete = user.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return delete;
	}

	@Override
	public int update(User user) {
		UserListDao ser = new UserListDaoImpl();
		int result = 0;
		try {
			result = ser.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public User SelectId(int dd) {
		UserListDao ser = new UserListDaoImpl();
		User list = null;
		try {
			list = ser.SelectId(dd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
