package com.frontend.web.model;

/**
 * 图框元素信息
 * @author wangluyang
 *
 */
public class ArchElement {

	/**
	 * 元素编码
	 */
	private String elementCode;
	/**
	 * 元素类型编码
	 */
	private String elementTypeCode;
	/**
	 * 展示顺序
	 */
	private String showOrder;
	/**
	 * 驻留相对时间
	 */
	private String timeValRal;
	/**
	 * 相对时间单位
	 */
	private String timeUnit;
	/**
	 * 元素获取url
	 */
	private String elementUrl;
	
	public String getElementCode() {
		return elementCode;
	}
	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}
	public String getElementTypeCode() {
		return elementTypeCode;
	}
	public void setElementTypeCode(String elementTypeCode) {
		this.elementTypeCode = elementTypeCode;
	}
	public String getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(String showOrder) {
		this.showOrder = showOrder;
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
	public String getElementUrl() {
		return elementUrl;
	}
	public void setElementUrl(String elementUrl) {
		this.elementUrl = elementUrl;
	}
}
