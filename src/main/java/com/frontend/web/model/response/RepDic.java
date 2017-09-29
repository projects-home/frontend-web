package com.frontend.web.model.response;

import java.io.Serializable;
import java.util.List;

public class RepDic implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 元素编码
	 */
	private String dic_code;
	
	/**
	 * 元素名称
	 */
	private String dic_name;
	
	/**
	 * 维度元素数据
	 */
	private List<RepDicDataCycle> dic_data_cycle;

	public String getDic_code() {
		return dic_code;
	}

	public void setDic_code(String dic_code) {
		this.dic_code = dic_code;
	}

	public String getDic_name() {
		return dic_name;
	}

	public void setDic_name(String dic_name) {
		this.dic_name = dic_name;
	}

	public List<RepDicDataCycle> getDic_data_cycle() {
		return dic_data_cycle;
	}

	public void setDic_data_cycle(List<RepDicDataCycle> dic_data_cycle) {
		this.dic_data_cycle = dic_data_cycle;
	}
}
