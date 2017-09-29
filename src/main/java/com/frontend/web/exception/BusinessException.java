package com.frontend.web.exception;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BusinessException extends RuntimeException implements Serializable {
	
	private static final long serialVersionUID = 1L;

	final static Logger log = LogManager.getLogger(RuntimeException.class);
	
	private String repcode;
	private String repmsg;
	public String getRepcode() {
		return repcode;
	}
	public void setRepcode(String repcode) {
		this.repcode = repcode;
	}
	public String getRepmsg() {
		return repmsg;
	}
	public void setRepmsg(String repmsg) {
		this.repmsg = repmsg;
	}
	public BusinessException(String repcode,String repmsg){
		super(repmsg);
		this.repcode = repcode;
		this.repmsg = repmsg;
	}
	
	
}
