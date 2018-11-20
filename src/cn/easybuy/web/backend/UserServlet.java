package cn.easybuy.web.backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.entity.Page;
import cn.easybuy.entity.User;
import cn.easybuy.service.Easybuy_user_Service;
import cn.easybuy.service.UserListService;
import cn.easybuy.service.Impl.Easybuy_user_Service_Impl;
import cn.easybuy.service.Impl.UserListServiceImpl;
import cn.easybuy.web.AbstractServlet;

/**
 * Servlet implementation class userDeleteServlet
 */
@WebServlet("/userDeleteServlet")
public class UserServlet extends AbstractServlet {
	UserListService service = null;
	public void init() {
		service = new UserListServiceImpl();
	}
	
	public void Delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("userDeleteServlet");
		int id = Integer.parseInt(request.getParameter("id"));
		int tt = new UserListServiceImpl().delete(id);
		System.out.println(id);
		if(tt > 0){
			response.getWriter().print(tt);
			System.out.println("删除成功！");
		} else{
			System.out.println("删除失败!");
		}
	}
	
	public void Update(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("进入了Update方法！");
		String loginName = request.getParameter("loginName");
		String userName = request.getParameter("userName");
		String identityCode = request.getParameter("identityCode");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		int type = Integer.parseInt(request.getParameter("type"));
		int id = Integer.parseInt(request.getParameter("id"));
		User user2 = new User();
		user2.setLoginName(loginName);
		user2.setUserName(userName);
		user2.setIdentityCode(identityCode);
		user2.setEmail(email);
		user2.setMobile(mobile);
		user2.setType(type);
		user2.setId(id);
		int result = new UserListServiceImpl().update(user2);
		if(result > 0) {
			response.getWriter().print(result);
		}
	}
	
	public void SelectId(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("进入了SelectId方法！");
		UserListService service = new UserListServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		User user = new User();
		user.setId(id);
		User user2 = service.SelectId(id);
		System.out.println(user2);
		request.setAttribute("user", user2);
		request.getRequestDispatcher("backend/user/toUpdateUser.jsp").forward(request, response);
	}
	
	public void queryUserList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("进入了queryUserList方法！！！！");
		String index = request.getParameter("pageIndex");
		if(index == null || index == "") {
			index = "1";
		}
		UserListService service = new UserListServiceImpl();
		Page page = service.Select(Integer.parseInt(index));
		request.setAttribute("pageIndex", page.getPageIndex());
		request.setAttribute("list", page.getList());
		request.setAttribute("pageCount", page.getPageCount());
		request.getRequestDispatcher("backend/user/userList.jsp").forward(request, response);
	}
	
	@Override
	public Class getServletClass() {
		
		return UserServlet.class;
	}

}
