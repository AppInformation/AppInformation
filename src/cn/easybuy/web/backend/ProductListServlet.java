package cn.easybuy.web.backend;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.entity.Product;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.service.ProductService;
import cn.easybuy.service.Impl.ProductServiceImpl;
import cn.easybuy.web.AbstractServlet;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/ProductListServlet")
public class ProductListServlet extends AbstractServlet {
	
	ProductService service = null;
	public void init() {
		service = new ProductServiceImpl();
	}

	public void DeleteProduct(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("进入了DeleteProduct方法！！！");
		int id = Integer.parseInt(request.getParameter("id"));
		int tt = new ProductServiceImpl().DeleteProduct(id);
		System.out.println(id);
		if(tt > 0){
			response.getWriter().print(tt);
			System.out.println("删除成功！");
		} else{
			System.out.println("删除失败!");
		}
	}
	
	public void SelectIdProduct(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ProductService service = new ProductServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = new Product();
		product.setId(id);
		Product product2 = service.SelectId(id);
		request.setAttribute("product", product2);
		List<ProductCategory> list1 = service.SelectType(1);
		request.setAttribute("productCategoryList1", list1);
		List<ProductCategory> list2 = service.SelectType(2);
		request.setAttribute("productCategoryList2", list2);
		List<ProductCategory> list3 = service.SelectType(3);
		request.setAttribute("productCategoryList3", list3);
		request.getRequestDispatcher("backend/product/toAddProduct.jsp").forward(request, response);
	}
	
	public void UpdateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int categoryLevel1Id = Integer.parseInt(request.getParameter("categoryLevel1Id"));
		int categoryLevel2Id = Integer.parseInt(request.getParameter("categoryLevel2Id"));
		int categoryLevel3Id = Integer.parseInt(request.getParameter("categoryLevel3Id"));
		String name = request.getParameter("name");
		String fileName = request.getParameter("fileName");
		float price = Float.parseFloat(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		String description = request.getParameter("description");
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = new Product();
		product.setCategoryLevel1Id(categoryLevel1Id);
		product.setCategoryLevel2Id(categoryLevel2Id);
		product.setCategoryLevel3Id(categoryLevel3Id);
		product.setName(name);
		product.setFileName(fileName);
		product.setPrice(price);
		product.setStock(stock);
		product.setDescription(description);
		product.setId(id);
		int result = new ProductServiceImpl().UpdateProduct(product);
		if(result > 0) {
			response.getWriter().print(result);
		}
	}
	
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return ProductListServlet.class;
	}
	
}
