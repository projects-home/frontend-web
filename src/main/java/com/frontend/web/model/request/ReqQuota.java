package com.frontend.web.model.request;

import java.io.Serializable;
import java.util.List;

public class ReqQuota implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 数据周期
	 */
	private List<ReqCycle> cycle;
	
	/**
	 * 维度
	 */
	private ReqDim dim;
	
	/**
	 * 指标编码
	 */
	private String quota_code;
	
	/**
	 * TOP标志
	 */
	private ReqTopflag top_flag;
	
	
	public List<ReqCycle> getCycle() {
		return cycle;
	}
	public void setCycle(List<ReqCycle> cycle) {
		this.cycle = cycle;
	}
	
	public ReqDim getDim() {
		return dim;
	}
	public void setDim(ReqDim dim) {
		this.dim = dim;
	}
	public String getQuota_code() {
		return quota_code;
	}
	public void setQuota_code(String quota_code) {
		this.quota_code = quota_code;
	}
	public ReqTopflag getTop_flag() {
		return top_flag;
	}
	public void setTop_flag(ReqTopflag top_flag) {
		this.top_flag = top_flag;
	}
	
	
}
