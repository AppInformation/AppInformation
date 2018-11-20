package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.Product;
import cn.easybuy.entity.ProductCategory;

public interface ProductDao {
	/**
	 * ��ѯ��Ʒ������
	 * @return
	 */
	public int SelectProduct();
	/**
	 * ��ҳ
	 * @param index
	 * @param sum
	 * @return
	 */
	public List<Product> PageProduct(int index,int sum);
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
