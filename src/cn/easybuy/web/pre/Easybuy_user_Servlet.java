package cn.easybuy.web.pre;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.entity.User;
import cn.easybuy.service.Easybuy_user_Service;
import cn.easybuy.service.Impl.Easybuy_user_Service_Impl;
import cn.easybuy.web.AbstractServlet;

/**
 * Servlet implementation class easybuy_user_Servlet
 */
@WebServlet("/easybuy_user_Servlet")
public class Easybuy_user_Servlet extends AbstractServlet {
	Easybuy_user_Service service = null;
	public void init() {
		service = new Easybuy_user_Service_Impl();
	}
	/**
	 * µÇÂ½
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void Login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("½øÈëÁËLogin");
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		User es = new User();
		es.setLoginName(loginName);
		es.setPassword(password);
		es = service.Login(loginName, password);
		request.getSession().setAttribute("loginUser", es);
		int sun = 0;
		if(es!=null) {
			sun = 1;
			response.getWriter().print(sun);
		}else {
			response.getWriter().print(sun);
		}
	}
	public void tiao(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.getRequestDispatcher("pre/index.jsp").forward(request, response);
	}
	/**
	 * ×¢²á
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void Register(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String identityCode = request.getParameter("identityCode");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		User user = new User();
		user.setLoginName(loginName);
		user.setPassword(password);
		user.setUserName(userName);
		user.setSex(sex);
		user.setIdentityCode(identityCode);
		user.setEmail(email);
		user.setMobile(mobile);
		int tu = service.Register(user);
		response.getWriter().print(tu);
	}
	
	public void Verification(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("loginName");
		int sad = service.Verification(name);
		response.getWriter().print(sad);
	}
	
	@Override
	public Class getServletClass() {
		
		return Easybuy_user_Servlet.class;
	}

}
