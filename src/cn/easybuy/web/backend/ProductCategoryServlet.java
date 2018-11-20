package cn.easybuy.web.backend;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.entity.PageProductCategory;
import cn.easybuy.service.ProductCategoryService;
import cn.easybuy.service.Impl.ProductCategoryServiceImpl;
import cn.easybuy.web.AbstractServlet;

/**
 * Servlet implementation class ProductCategoryServlet
 */
@WebServlet("/ProductCategoryServlet")
public class ProductCategoryServlet extends AbstractServlet {
	ProductCategoryService service = null;
	public void init() {
		service = new ProductCategoryServiceImpl();
	}

	public void SelectProductCategory(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String index = request.getParameter("pageIndex");
		if(index == null || index == "") {
			index = "1";
		}
		PageProductCategory page = service.SelectProductCategory(Integer.parseInt(index));
		request.setAttribute("pageIndex", page.getPageIndex());
		request.setAttribute("list", page.getList());
		request.setAttribute("pageCount", page.getPageCount());
		request.getRequestDispatcher("backend/productCategory/productCategoryList.jsp").forward(request, response);
	}
	
	public void DeleteProductCategory(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("进入了DeleteProductCategory!!!");
		int id = Integer.parseInt(request.getParameter("id"));
		int result = new ProductCategoryServiceImpl().DeleteProductCategory(id);
		if(result > 0){
			response.getWriter().print(result);
			System.out.println("删除成功！");
		} else{
			System.out.println("删除失败!");
		}
	}
	
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return ProductCategoryServlet.class;
	}
	
}
