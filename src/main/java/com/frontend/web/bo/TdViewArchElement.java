package com.frontend.web.bo;

public class TdViewArchElement {
    private Long elementId;

    private String pageCode;

    private String archCode;

    private String elementCode;

    private Long routeId;

    private String elementUrl;

    private String elementTypeCode;

    private String elementCodeVirtual;

    private String elementState;

    private Integer showOrder;

    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode == null ? null : pageCode.trim();
    }

    public String getArchCode() {
        return archCode;
    }

    public void setArchCode(String archCode) {
        this.archCode = archCode == null ? null : archCode.trim();
    }

    public String getElementCode() {
        return elementCode;
    }

    public void setElementCode(String elementCode) {
        this.elementCode = elementCode == null ? null : elementCode.trim();
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getElementUrl() {
        return elementUrl;
    }

    public void setElementUrl(String elementUrl) {
        this.elementUrl = elementUrl == null ? null : elementUrl.trim();
    }

    public String getElementTypeCode() {
        return elementTypeCode;
    }

    public void setElementTypeCode(String elementTypeCode) {
        this.elementTypeCode = elementTypeCode == null ? null : elementTypeCode.trim();
    }

    public String getElementCodeVirtual() {
        return elementCodeVirtual;
    }

    public void setElementCodeVirtual(String elementCodeVirtual) {
        this.elementCodeVirtual = elementCodeVirtual == null ? null : elementCodeVirtual.trim();
    }

    public String getElementState() {
        return elementState;
    }

    public void setElementState(String elementState) {
        this.elementState = elementState == null ? null : elementState.trim();
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }
}