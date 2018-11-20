package cn.easybuy.web.backend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.entity.PageProduct;
import cn.easybuy.service.ProductService;
import cn.easybuy.service.Impl.ProductServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ω¯»Î¡ÀProductServlet£°£°£°£°");
		String index = request.getParameter("pageIndex");
		if(index == null || index == "") {
			index = "1";
		}
		ProductService ps = new ProductServiceImpl();
		PageProduct page = ps.SelectProduct(Integer.parseInt(index));
		request.setAttribute("pageIndex", page.getPageIndex());
		request.setAttribute("list", page.getList());
		request.setAttribute("pageCount", page.getPageCount());
		request.getRequestDispatcher("backend/product/productList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
