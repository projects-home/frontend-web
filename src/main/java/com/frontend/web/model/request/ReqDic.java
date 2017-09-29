package com.frontend.web.model.request;

import java.io.Serializable;

public class ReqDic implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 元素编码
	 */
	private String dic_code;

	public String getDic_code() {
		return dic_code;
	}

	public void setDic_code(String dic_code) {
		this.dic_code = dic_code;
	}
	
	
}
