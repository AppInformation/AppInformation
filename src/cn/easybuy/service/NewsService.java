package cn.easybuy.service;

import cn.easybuy.entity.News;
import cn.easybuy.entity.PageNews;

public interface NewsService {
	/**
	 * 分页
	 * @param index
	 * @return
	 */
	public PageNews SelectNews(int index);
	/**
	 * 按id查询内容
	 * @param Title
	 * @return
	 */
	public News SelectId(int id);
}
