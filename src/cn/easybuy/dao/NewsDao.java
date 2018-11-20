package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.News;

public interface NewsDao {
	/**
	 * 查询资讯总行数
	 * @return
	 */
	public int SelectNews();
	/**
	 * 分页
	 * @param index
	 * @param sum
	 * @return
	 */
	public List<News> PageNews(int index,int sum);
	/**
	 * 按id查询内容
	 * @param Title
	 * @return
	 */
	public News SelectId(int id);
}
