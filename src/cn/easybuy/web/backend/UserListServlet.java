package cn.easybuy.web.backend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.entity.Page;
import cn.easybuy.service.UserListService;
import cn.easybuy.service.Impl.UserListServiceImpl;

/**
 * Servlet implementation class userListServlet
 */
@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ω¯»Î¡ÀuserListServlet");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 doGet(request, response);
	}
	
}
