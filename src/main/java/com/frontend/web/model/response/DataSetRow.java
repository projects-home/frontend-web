package com.frontend.web.model.response;

import java.io.Serializable;
import java.util.List;

public class DataSetRow implements Serializable {

	private static final long serialVersionUID = 1L;
	private int row_num;
	private String warn_type;
	private List<RowData> row_data;
	public int getRow_num() {
		return row_num;
	}
	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}
	public String getWarn_type() {
		return warn_type;
	}
	public void setWarn_type(String warn_type) {
		this.warn_type = warn_type;
	}
	public List<RowData> getRow_data() {
		return row_data;
	}
	public void setRow_data(List<RowData> row_data) {
		this.row_data = row_data;
	}
	
}
