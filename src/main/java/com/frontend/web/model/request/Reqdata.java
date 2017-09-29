package com.frontend.web.model.request;

import java.io.Serializable;
import java.util.List;

public class Reqdata implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 指标
	 */
	private List<ReqQuota> quota;

	public List<ReqQuota> getQuota() {
		return quota;
	}

	public void setQuota(List<ReqQuota> quota) {
		this.quota = quota;
	}
	
}
