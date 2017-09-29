package com.frontend.web.model.request;

import java.io.Serializable;

public class ReqCycleValue implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 值(周期)
	 */
	private String val;

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
	
	
}
