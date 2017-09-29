package com.frontend.web.bo;

public class TdViewPage {
    private Long pageId;

    private String pageCode;

    private String pageName;

    private String pageUrl;

    private String pageType;

    private String parentGreenCode;

    private String pageState;

    private Long staytimeValue;

    private String staytimeUnit;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode == null ? null : pageCode.trim();
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName == null ? null : pageName.trim();
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl == null ? null : pageUrl.trim();
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType == null ? null : pageType.trim();
    }

    public String getParentGreenCode() {
        return parentGreenCode;
    }

    public void setParentGreenCode(String parentGreenCode) {
        this.parentGreenCode = parentGreenCode == null ? null : parentGreenCode.trim();
    }

    public String getPageState() {
        return pageState;
    }

    public void setPageState(String pageState) {
        this.pageState = pageState == null ? null : pageState.trim();
    }

    public Long getStaytimeValue() {
        return staytimeValue;
    }

    public void setStaytimeValue(Long staytimeValue) {
        this.staytimeValue = staytimeValue;
    }

    public String getStaytimeUnit() {
        return staytimeUnit;
    }

    public void setStaytimeUnit(String staytimeUnit) {
        this.staytimeUnit = staytimeUnit == null ? null : staytimeUnit.trim();
    }
}