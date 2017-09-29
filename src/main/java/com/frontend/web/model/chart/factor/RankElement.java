package com.frontend.web.model.chart.factor;

/**
 * top排名各因子属性
 * @author wangluyang
 *
 */
public class RankElement {

	/**
	 * yyyy-mm-dd hh:mm:ss
	 */
	private String dateString;
	
	private String code;
	
	private String name;
	
	private String text;

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
