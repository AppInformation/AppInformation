package cn.easybuy.service;

import java.util.List;

import cn.easybuy.entity.PageProduct;
import cn.easybuy.entity.Product;
import cn.easybuy.entity.ProductCategory;

public interface ProductService {
	/**
	 * 分页
	 * @param index
	 * @return
	 */
	public PageProduct SelectProduct(int index);
	/**
	 * 删除商品
	 * @param id
	 * @return
	 */
	public int DeleteProduct(int id);
	/**
	 * 修改商品
	 * @param product
	 * @return
	 */
	public int UpdateProduct(Product product);
	/**
	 * 按id查询
	 * @param dd
	 * @return
	 */
	public Product SelectId(int dd);
	/**
	 * 按分级查询
	 * @param type
	 * @return
	 */
	public List<ProductCategory> SelectType(int type);
}
