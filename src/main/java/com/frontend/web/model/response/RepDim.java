package com.frontend.web.model.response;

import java.io.Serializable;
import java.util.List;

public class RepDim implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 维度元素
	 */
	private List<RepDic> dic;
	
	/**
	 * 维度编码
	 */
	private String dim_code;
	
	/**
	 * 维度名称
	 */
	private String dim_name;

	public List<RepDic> getDic() {
		return dic;
	}

	public void setDic(List<RepDic> dic) {
		this.dic = dic;
	}

	public String getDim_code() {
		return dim_code;
	}

	public void setDim_code(String dim_code) {
		this.dim_code = dim_code;
	}

	public String getDim_name() {
		return dim_name;
	}

	public void setDim_name(String dim_name) {
		this.dim_name = dim_name;
	}
	
	
}
