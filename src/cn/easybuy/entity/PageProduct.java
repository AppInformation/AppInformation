package cn.easybuy.entity;

import java.util.List;

public class PageProduct {
	private int pageIndex;                  //��ҳ
	private int pageCount;					//��ҳ
	private List<Product> list; 		//���ݼ���
	
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
