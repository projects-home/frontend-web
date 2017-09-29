package com.frontend.web.model.response;

import java.io.Serializable;

public class RowData implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String data_code;
	
	private String data_value;

	public String getData_code() {
		return data_code;
	}

	public void setData_code(String data_code) {
		this.data_code = data_code;
	}

	public String getData_value() {
		return data_value;
	}

	public void setData_value(String data_value) {
		this.data_value = data_value;
	}
	
	
}
