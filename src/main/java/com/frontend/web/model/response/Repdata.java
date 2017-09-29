package com.frontend.web.model.response;

import java.io.Serializable;
import java.util.List;

public class Repdata implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 指标
	 */
	private List<RepQuota> quota;

	public List<RepQuota> getQuota() {
		return quota;
	}

	public void setQuota(List<RepQuota> quota) {
		this.quota = quota;
	}
	
	
}
