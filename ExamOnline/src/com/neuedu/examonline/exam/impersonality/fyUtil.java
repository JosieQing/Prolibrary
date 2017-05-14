package com.neuedu.examonline.exam.impersonality;

public class fyUtil {
private int pageSize=6;//页行数

	
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
