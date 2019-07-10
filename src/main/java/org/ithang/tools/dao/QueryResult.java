package org.ithang.tools.dao;

import java.util.List;

public class QueryResult<T> {

	
	private Pager page;
	private List<T> data;
	
	public Pager getPage() {
		return page;
	}
	public void setPage(Pager page) {
		this.page = page;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
