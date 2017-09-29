package com.frontend.web.model.response;

import java.io.Serializable;
import java.util.List;

public class RepDicDataCycle implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<CycleDataSet> cycle_data_set;
	private String cycle_type;
	public List<CycleDataSet> getCycle_data_set() {
		return cycle_data_set;
	}
	public void setCycle_data_set(List<CycleDataSet> cycle_data_set) {
		this.cycle_data_set = cycle_data_set;
	}
	public String getCycle_type() {
		return cycle_type;
	}
	public void setCycle_type(String cycle_type) {
		this.cycle_type = cycle_type;
	}
	
}
