package com.frontend.web.bo;

public class TdViewArch {
    private Long archId;

    private String pageCode;

    private String archCode;

    private String archName;

    private String state;

    private Long staytimeValue;

    private String staytimeUnit;

    public Long getArchId() {
        return archId;
    }

    public void setArchId(Long archId) {
        this.archId = archId;
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

    public String getArchName() {
        return archName;
    }

    public void setArchName(String archName) {
        this.archName = archName == null ? null : archName.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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