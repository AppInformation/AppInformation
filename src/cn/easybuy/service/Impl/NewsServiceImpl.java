package cn.easybuy.service.Impl;

import java.util.List;

import cn.easybuy.dao.NewsDao;
import cn.easybuy.dao.Impl.NewsDaoImpl;
import cn.easybuy.entity.News;
import cn.easybuy.entity.PageNews;
import cn.easybuy.service.NewsService;

public class NewsServiceImpl implements NewsService {

	@Override
	public PageNews SelectNews(int index) {
		int result = 10;
		NewsDao newsDao = new NewsDaoImpl();
		List<News> list = newsDao.PageNews(index, result);
		int count = newsDao.SelectNews();
		int pageCount = count % result == 0?count/result :count/result + 1;
		PageNews page = new PageNews();
		page.setPageCount(pageCount);
		page.setList(list);
		page.setPageIndex(index);
		return page;
	}

	@Override
	public News SelectId(int id) {
		NewsDao newsDao = new NewsDaoImpl();
		News news = null;
		try {
			news = newsDao.SelectId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return news;
	}

}
