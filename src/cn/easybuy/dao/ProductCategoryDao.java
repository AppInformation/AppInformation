package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.ProductCategory;

public interface ProductCategoryDao {
	/**
	 * ��ѯ����������
	 * @return
	 */
	public int SelectProductCategory();
	/**
	 * ��ҳ
	 * @param index
	 * @param sum
	 * @return
	 */
	public List<ProductCategory> PageProductCategory(int index,int sum);
	/**
	 * ɾ�������б�
	 * @param id
	 * @return
	 */
	public int DeleteProductCategory(int id);
}
