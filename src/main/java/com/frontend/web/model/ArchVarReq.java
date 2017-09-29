package com.frontend.web.model;

import java.util.List;

/**
 * 变量查询入參
 * @author wangluyang
 *
 */
public class ArchVarReq {

	/**
	 * 当前页面编码
	 */
	private String pageCode;
	/**
	 * 当前图框编码
	 */
	private String archCode;
	
	/**
	 * 元素编码
	 */
	private String elementCode;
	
	/**
	 * 逻辑关系变量
	 */
	private List<String> variables;

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public String getArchCode() {
		return archCode;
	}

	public void setArchCode(String archCode) {
		this.archCode = archCode;
	}

	public String getElementCode() {
		return elementCode;
	}

	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}

	public List<String> getVariables() {
		return variables;
	}

	public void setVariables(List<String> variables) {
		this.variables = variables;
	}
}
