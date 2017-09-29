package com.frontend.web.model.request;

import java.io.Serializable;
import java.util.List;

public class ReqCycle implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 周期数目
	 */
	private int cycle_cnt;
	
	/**
	 * 周期类型
	 */
	private String cycle_type;
	
	/**
	 * 周期值
	 */
	private List<ReqCycleValue> cycle_value;


	public int getCycle_cnt() {
		return cycle_cnt;
	}

	public void setCycle_cnt(int cycle_cnt) {
		this.cycle_cnt = cycle_cnt;
	}

	public String getCycle_type() {
		return cycle_type;
	}

	public void setCycle_type(String cycle_type) {
		this.cycle_type = cycle_type;
	}

	public List<ReqCycleValue> getCycle_value() {
		return cycle_value;
	}

	public void setCycle_value(List<ReqCycleValue> cycle_value) {
		this.cycle_value = cycle_value;
	}
	
	
}	
