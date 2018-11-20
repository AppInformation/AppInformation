package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.ProductCategory;

public interface ProductCategoryDao {
	/**
	 * 查询分类总行数
	 * @return
	 */
	public int SelectProductCategory();
	/**
	 * 分页
	 * @param index
	 * @param sum
	 * @return
	 */
	public List<ProductCategory> PageProductCategory(int index,int sum);
	/**
	 * 删除分类列表
	 * @param id
	 * @return
	 */
	public int DeleteProductCategory(int id);
}
