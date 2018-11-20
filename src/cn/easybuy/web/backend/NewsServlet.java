package cn.easybuy.web.backend;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.entity.News;
import cn.easybuy.entity.PageNews;
import cn.easybuy.service.NewsService;
import cn.easybuy.service.Impl.NewsServiceImpl;
import cn.easybuy.web.AbstractServlet;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet("/NewsServlet")
public class NewsServlet extends AbstractServlet {

	NewsService service = null;
	public void init() {
		service = new NewsServiceImpl();
	}
	
	public void SelectNews(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("进入了NewsServlet！！！");
		String index = request.getParameter("pageIndex");
		if(index == null || index == "") {
			index = "1";
		}
		PageNews page = service.SelectNews(Integer.parseInt(index));
		request.setAttribute("pageIndex", page.getPageIndex());
		request.setAttribute("list", page.getList());
		request.setAttribute("pageCount", page.getPageCount());
		request.getRequestDispatcher("backend/news/newsList.jsp").forward(request, response);
	}
	public void SelectId(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("进入了SelectId！！！");
		NewsService service = new NewsServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		
		News news2 = service.SelectId(id);
		System.out.println(news2);
		request.setAttribute("news", news2);
		request.getRequestDispatcher("backend/news/newsList.jsp").forward(request, response);
	}
	 
	
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return NewsServlet.class;
	}


}
