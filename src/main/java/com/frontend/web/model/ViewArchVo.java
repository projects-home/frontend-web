package com.frontend.web.model;

import java.util.List;

/**
 * 图框信息表
 * @author wangluyang
 *
 */
public class ViewArchVo {

	
	/**
	 * 图框编码
	 */
	private String archCode;
	/**
	 * 图框名称
	 */
	private String archName;
	
	/**
	 * 图框驻留相对时间
	 */
	private String timeValRal;
	/**
	 * 图框相对时间单位
	 */
	private String timeUnit;
	
	/**
	 * 图框元素信息
	 */
	private List<ArchElement> archElements;
	
	public String getArchCode() {
		return archCode;
	}
	public void setArchCode(String archCode) {
		this.archCode = archCode;
	}
	public String getArchName() {
		return archName;
	}
	public void setArchName(String archName) {
		this.archName = archName;
	}
	public String getTimeValRal() {
		return timeValRal;
	}
	public void setTimeValRal(String timeValRal) {
		this.timeValRal = timeValRal;
	}
	public String getTimeUnit() {
		return timeUnit;
	}
	public void setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
	}
	public List<ArchElement> getArchElements() {
		return archElements;
	}
	public void setArchElements(List<ArchElement> archElements) {
		this.archElements = archElements;
	}
}
