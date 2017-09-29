package com.frontend.web.model.response;

import java.io.Serializable;

public class RepQuota implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 维度
	 */
	private RepDim dim;
	
	/**
	 * 指标编码
	 */
	private String quota_code;
	
	/**
	 * 指标名称
	 */
	private String quota_name;
	
	

	public RepDim getDim() {
		return dim;
	}

	public void setDim(RepDim dim) {
		this.dim = dim;
	}

	public String getQuota_code() {
		return quota_code;
	}

	public void setQuota_code(String quota_code) {
		this.quota_code = quota_code;
	}

	public String getQuota_name() {
		return quota_name;
	}

	public void setQuota_name(String quota_name) {
		this.quota_name = quota_name;
	}
	
	
}
