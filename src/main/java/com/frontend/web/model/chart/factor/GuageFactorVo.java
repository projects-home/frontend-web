package com.frontend.web.model.chart.factor;

/**
 * 仪表盘区域属性
 * @author wangluyang
 *
 */
public class GuageFactorVo {
	
	/**
	 * 所占百分比，小于100的整数
	 */
	private int percentage;
	/**
	 * 区域颜色
	 */
	private String color;
	
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
