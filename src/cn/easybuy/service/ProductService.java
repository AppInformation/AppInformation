package cn.easybuy.service;

import java.util.List;

import cn.easybuy.entity.PageProduct;
import cn.easybuy.entity.Product;
import cn.easybuy.entity.ProductCategory;

public interface ProductService {
	/**
	 * ��ҳ
	 * @param index
	 * @return
	 */
	public PageProduct SelectProduct(int index);
	/**
	 * ɾ����Ʒ
	 * @param id
	 * @return
	 */
	public int DeleteProduct(int id);
	/**
	 * �޸���Ʒ
	 * @param product
	 * @return
	 */
	public int UpdateProduct(Product product);
	/**
	 * ��id��ѯ
	 * @param dd
	 * @return
	 */
	public Product SelectId(int dd);
	/**
	 * ���ּ���ѯ
	 * @param type
	 * @return
	 */
	public List<ProductCategory> SelectType(int type);
}
