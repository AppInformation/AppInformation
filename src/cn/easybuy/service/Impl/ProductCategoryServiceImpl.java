package cn.easybuy.service.Impl;

import java.util.List;

import cn.easybuy.dao.ProductCategoryDao;
import cn.easybuy.dao.Impl.ProductCategoryDaoImpl;
import cn.easybuy.entity.PageProductCategory;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.service.ProductCategoryService;

public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Override
	public PageProductCategory SelectProductCategory(int index) {
		int result = 8;
		ProductCategoryDao dao = new ProductCategoryDaoImpl();
		List<ProductCategory> list = dao.PageProductCategory(index, result);
		int count = dao.SelectProductCategory();
		int pageCount = count % result == 0?count/result :count/result + 1;
		PageProductCategory page = new PageProductCategory();
		page.setPageCount(pageCount);
		page.setList(list);
		page.setPageIndex(index);
		return page;
	}

	@Override
	public int DeleteProductCategory(int id) {
		int result = 0;
		try {
			result = new ProductCategoryDaoImpl().DeleteProductCategory(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
