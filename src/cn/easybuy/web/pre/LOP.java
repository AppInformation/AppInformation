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
 * Servlet implementation class LOP
 */
@WebServlet("/LOP")
public class LOP extends AbstractServlet {
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
	public void tiao(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.getRequestDispatcher("pre/index.jsp").forward(request, response);
	}
	@Override
	public Class getServletClass() {
		
		return LOP.class;
	}

}
