package com.frontend.web.model;

/**
 * 变量查询出參
 * @author wangluyang
 *
 */
public class ArchVarResp {

	/**
	 * 当前页面编码
	 */
	private String pageCode;
	/**
	 * 当前图框编码
	 */
	private String archCode;
	
	/**
	 * 图框详细信息
	 */
	private ViewArchVo archVo;

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

	public ViewArchVo getArchVo() {
		return archVo;
	}

	public void setArchVo(ViewArchVo archVo) {
		this.archVo = archVo;
	}
}
