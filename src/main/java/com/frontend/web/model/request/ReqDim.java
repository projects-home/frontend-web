package com.frontend.web.model.request;

import java.io.Serializable;
import java.util.List;

public class ReqDim implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 维度元素
	 */
	private List<ReqDic> dic;
	
	/**
	 * 维度编码
	 */
	private String dim_code;

	public List<ReqDic> getDic() {
		return dic;
	}

	public void setDic(List<ReqDic> dic) {
		this.dic = dic;
	}

	public String getDim_code() {
		return dim_code;
	}

	public void setDim_code(String dim_code) {
		this.dim_code = dim_code;
	}
	
	
}
