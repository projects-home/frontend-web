package com.frontend.web.model.chart.factor;

import java.util.List;

/**
 * 图表数据
 * @author wangluyang
 *
 */
public class SeriesVo {
	
	/**
	 * 图表所属类型 
	 * line:折线图，面积图
	 * bar：柱状图
	 * scatter：散点图
	 */
	private String seriesType;
	/**
	 * 数据名称
	 */
	private String legendName;
	/**
	 * 数据编码
	 */
	private String legendCode;
	/**
	 * 面积图区域颜色
	 */
	private String areaStylecolor;
	/**
	 * 面积图元素颜色
	 */
	private String itemStylecolor;
	/**
	 * 元素值
	 */
	private List<String> data;
	
	public String getSeriesType() {
		return seriesType;
	}
	public void setSeriesType(String seriesType) {
		this.seriesType = seriesType;
	}
	public String getLegendName() {
		return legendName;
	}
	public void setLegendName(String legendName) {
		this.legendName = legendName;
	}
	public String getLegendCode() {
		return legendCode;
	}
	public void setLegendCode(String legendCode) {
		this.legendCode = legendCode;
	}
	public String getAreaStylecolor() {
		return areaStylecolor;
	}
	public void setAreaStylecolor(String areaStylecolor) {
		this.areaStylecolor = areaStylecolor;
	}
	public String getItemStylecolor() {
		return itemStylecolor;
	}
	public void setItemStylecolor(String itemStylecolor) {
		this.itemStylecolor = itemStylecolor;
	}
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}
}
