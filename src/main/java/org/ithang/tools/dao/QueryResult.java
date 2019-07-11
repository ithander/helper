package org.ithang.tools.dao;

import java.util.List;

public class QueryResult<T> {

	
	private long pageIndex;//当前页号
	private long pageSize;//每页记录数
	private long pageNum;//总页数
	private long total;//总记录数
	private List<T> data;//当前查询的数据
	
	public QueryResult(){}
	
	public QueryResult(long pIndex,long pSize){
		setPageIndex(pIndex);
		setPageSize(pSize);
	}
	
	public long getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(long pageIndex) {
		this.pageIndex = pageIndex;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public long getPageNum() {
		return pageNum;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
		
		if(total>0){
			pageNum=total%pageSize>0?total/pageSize+1:total/pageSize;
		}
		
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
