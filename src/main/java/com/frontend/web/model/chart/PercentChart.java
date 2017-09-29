package com.frontend.web.model.chart;

import java.util.List;

import com.frontend.web.model.chart.factor.GuageFactorVo;


/**
 * 百分比图
 * @author wangluyang
 *
 */
public class PercentChart {

	private static final long serialVersionUID = 1L;
	
	/**
	 * lineProcess 进度条
	 * ring	环形图
	 * gauge 仪表盘
	 */
	private String type;
	
	/**
	 * 指标编码
	 */
	private String quotaCode;
	private String title;
	
	/**
	 * 百分比 小于100
	 */
	private String percentage;
	/**
	 * 具体数值
	 */
	private String data;
	
	//------------进度条,环形图属性-------
	/**
	 * 当前进度条颜色
	 */
	private String processColor;
	/**
	 * 背景颜色
	 */
	private String backgroundColor;
	
	//------------仪表盘属性-------
	/**
	 * 指针颜色
	 */
	private String axisTickColor;
	/**
	 * 分割区域
	 */
	private String splitNumber;
	private List<GuageFactorVo> guageFactors;
		
	public String getQuotaCode() {
		return quotaCode;
	}
	public void setQuotaCode(String quotaCode) {
		this.quotaCode = quotaCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getProcessColor() {
		return processColor;
	}
	public void setProcessColor(String processColor) {
		this.processColor = processColor;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getAxisTickColor() {
		return axisTickColor;
	}
	public void setAxisTickColor(String axisTickColor) {
		this.axisTickColor = axisTickColor;
	}
	public String getSplitNumber() {
		return splitNumber;
	}
	public void setSplitNumber(String splitNumber) {
		this.splitNumber = splitNumber;
	}
	public List<GuageFactorVo> getGuageFactors() {
		return guageFactors;
	}
	public void setGuageFactors(List<GuageFactorVo> guageFactors) {
		this.guageFactors = guageFactors;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
