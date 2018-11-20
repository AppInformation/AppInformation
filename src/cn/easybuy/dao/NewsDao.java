package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.News;

public interface NewsDao {
	/**
	 * ��ѯ��Ѷ������
	 * @return
	 */
	public int SelectNews();
	/**
	 * ��ҳ
	 * @param index
	 * @param sum
	 * @return
	 */
	public List<News> PageNews(int index,int sum);
	/**
	 * ��id��ѯ����
	 * @param Title
	 * @return
	 */
	public News SelectId(int id);
}
