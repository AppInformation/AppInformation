package cn.easybuy.entity;

import java.util.List;

public class PageProduct {
	private int pageIndex;                  //首页
	private int pageCount;					//总页
	private List<Product> list; 		//数据集合
	
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
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
}
