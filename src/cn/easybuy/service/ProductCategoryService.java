package cn.easybuy.service;

import cn.easybuy.entity.PageProductCategory;

public interface ProductCategoryService {
	/**
	 * ��ҳ
	 * @param index
	 * @return
	 */
	public PageProductCategory SelectProductCategory(int index);
	/**
	 * ɾ�������б�
	 * @param id
	 * @return
	 */
	public int DeleteProductCategory(int id);
}
