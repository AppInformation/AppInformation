package cn.easybuy.service;

import cn.easybuy.entity.PageProductCategory;

public interface ProductCategoryService {
	/**
	 * 分页
	 * @param index
	 * @return
	 */
	public PageProductCategory SelectProductCategory(int index);
	/**
	 * 删除分类列表
	 * @param id
	 * @return
	 */
	public int DeleteProductCategory(int id);
}
