package com.frontend.web.model.request;

import java.io.Serializable;

public class ReqTopflag implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 取值范围
	 */
	private int rows;
	
	/**
	 * 排序方法
	 */
	private String sort_method;

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort_method() {
		return sort_method;
	}

	public void setSort_method(String sort_method) {
		this.sort_method = sort_method;
	}
	
	
}
