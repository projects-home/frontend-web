package com.frontend.web.model.chart;

import java.util.List;

import com.frontend.web.model.chart.factor.AxisVo;
import com.frontend.web.model.chart.factor.SeriesVo;



/**
 * 常用图表
 * 支持面积图,折线图，柱状图，散点图
 * @author wangluyang
 *
 */
public class CommonChart {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 指标编码
	 */
	private String quotaCode;
	
	/**
	 * 图表类型
	 * line:折线图，面积图
	 * bar：柱状图
	 * scatter：散点图
	 */
	private String chartType;
	
	private String title;
	
	/**
	 * x坐标轴
	 */
	private AxisVo xAxis;
	
	/**
	 * y坐标轴,兼容双y轴，最多两条数据
	 */
	private List<AxisVo> yAxis;
	
	/**
	 * 数据
	 */
	private List<SeriesVo> seriesData;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChartType() {
		return chartType;
	}

	public void setChartType(String chartType) {
		this.chartType = chartType;
	}

	public AxisVo getxAxis() {
		return xAxis;
	}

	public void setxAxis(AxisVo xAxis) {
		this.xAxis = xAxis;
	}
	
	public List<AxisVo> getyAxis() {
		return yAxis;
	}

	public void setyAxis(List<AxisVo> yAxis) {
		this.yAxis = yAxis;
	}

	public String getQuotaCode() {
		return quotaCode;
	}

	public void setQuotaCode(String quotaCode) {
		this.quotaCode = quotaCode;
	}

	public List<SeriesVo> getSeriesData() {
		return seriesData;
	}

	public void setSeriesData(List<SeriesVo> seriesData) {
		this.seriesData = seriesData;
	}
}
