package com.neuedu.examonline.util;

public class PageUtil {

	private int pageSize=10;//页面容量
	
	public int getPageTotal(int rowTotal){
		if(rowTotal%pageSize==0){
			return (rowTotal/pageSize);
		}else{
			return (rowTotal/pageSize+1);
		}
	}
	
	public int getRowIndex(int currentPage){
		return (currentPage-1)*pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}
