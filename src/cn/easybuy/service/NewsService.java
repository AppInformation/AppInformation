package cn.easybuy.service;

import cn.easybuy.entity.News;
import cn.easybuy.entity.PageNews;

public interface NewsService {
	/**
	 * ��ҳ
	 * @param index
	 * @return
	 */
	public PageNews SelectNews(int index);
	/**
	 * ��id��ѯ����
	 * @param Title
	 * @return
	 */
	public News SelectId(int id);
}
