package com.frontend.web.model.response;

import java.io.Serializable;
import java.util.List;

public class CycleDataSet implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cycle_value;
	private List<DataSetRow> data_set_row;
	public String getCycle_value() {
		return cycle_value;
	}
	public void setCycle_value(String cycle_value) {
		this.cycle_value = cycle_value;
	}
	public List<DataSetRow> getData_set_row() {
		return data_set_row;
	}
	public void setData_set_row(List<DataSetRow> data_set_row) {
		this.data_set_row = data_set_row;
	}
	
}
