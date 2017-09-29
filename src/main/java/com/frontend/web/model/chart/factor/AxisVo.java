package com.frontend.web.model.chart.factor;

import java.util.List;

/**
 * 坐标轴 包括X轴，y轴
 * @author wangluyang
 *
 */
public class AxisVo {

	/**
	 * 坐标轴类型。'value' 数值轴，适用于连续数据;
	 * 'category' 类目轴，适用于离散的类目数据，为该类型时必须通过data设置类目数据;
	 */
	private String dataType;
	
	/**
	 * 是否展示,可选
	 */
	private boolean show;
	
	/**
	 * 分割段数，可选
	 */
	private int splitNumber;
	
	/**
	 * 类目起始和结束两端空白策略,可选
	 */
	private boolean boundaryGap;
	
	/**
	 * data 设置类目数据;
	 */
	private List<String> data;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public int getSplitNumber() {
		return splitNumber;
	}

	public void setSplitNumber(int splitNumber) {
		this.splitNumber = splitNumber;
	}
	
	public boolean isBoundaryGap() {
		return boundaryGap;
	}

	public void setBoundaryGap(boolean boundaryGap) {
		this.boundaryGap = boundaryGap;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}
}
