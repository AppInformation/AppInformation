package cn.easybuy.service.Impl;

import java.util.List;

import cn.easybuy.dao.ProductDao;
import cn.easybuy.dao.Impl.ProductDaoImpl;
import cn.easybuy.entity.PageProduct;
import cn.easybuy.entity.Product;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	public PageProduct SelectProduct(int index) {
		int result = 8;
		ProductDao pro = new ProductDaoImpl();
		List<Product> list = pro.PageProduct(index, result);
		int count = pro.SelectProduct();
		int pageCount = count % result == 0?count/result :count/result + 1;
		PageProduct page = new PageProduct();
		page.setPageCount(pageCount);
		page.setList(list);
		page.setPageIndex(index);
		return page;
	}

	@Override
	public int DeleteProduct(int id) {
		int result = 0;
		try {
			result = new ProductDaoImpl().DeleteProduct(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int UpdateProduct(Product product) {
		ProductDao pro = new ProductDaoImpl();
		int result = 0;
		try {
			result = pro.UpdateProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Product SelectId(int dd) {
		ProductDao pro = new ProductDaoImpl();
		Product result = null;
		try {
			result = pro.SelectId(dd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ProductCategory> SelectType(int type) {
		List<ProductCategory> list = new ProductDaoImpl().SelectType(type);
		return list;
	}

}
