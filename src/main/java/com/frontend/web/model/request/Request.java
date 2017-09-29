package com.frontend.web.model.request;

import java.io.Serializable;

public class Request implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Reqdata reqdata;
	
	private String reqtype;

	public Reqdata getReqdata() {
		return reqdata;
	}

	public void setReqdata(Reqdata reqdata) {
		this.reqdata = reqdata;
	}

	public String getReqtype() {
		return reqtype;
	}

	public void setReqtype(String reqtype) {
		this.reqtype = reqtype;
	}
	
	
	
}
