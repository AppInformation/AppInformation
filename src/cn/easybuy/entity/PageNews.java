package cn.easybuy.entity;

import java.util.List;

public class PageNews {
	private int pageIndex;                  //首页
	private int pageCount;					//总页
	private List<News> list; 		//数据集合
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<News> getList() {
		return list;
	}
	public void setList(List<News> list) {
		this.list = list;
	}
}
