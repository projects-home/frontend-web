package com.frontend.web.bo;

public class TdViewChart {
    private Long chartId;

    private String chartCode;

    private String chartName;

    private String chartTypeCode;

    private String circleType;

    private String ruleCode;

    private String timeValAbs;

    private Long timeValRal;

    private String timeUnit;

    private String chartState;

    public Long getChartId() {
        return chartId;
    }

    public void setChartId(Long chartId) {
        this.chartId = chartId;
    }

    public String getChartCode() {
        return chartCode;
    }

    public void setChartCode(String chartCode) {
        this.chartCode = chartCode == null ? null : chartCode.trim();
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName == null ? null : chartName.trim();
    }

    public String getChartTypeCode() {
        return chartTypeCode;
    }

    public void setChartTypeCode(String chartTypeCode) {
        this.chartTypeCode = chartTypeCode == null ? null : chartTypeCode.trim();
    }

    public String getCircleType() {
        return circleType;
    }

    public void setCircleType(String circleType) {
        this.circleType = circleType == null ? null : circleType.trim();
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode == null ? null : ruleCode.trim();
    }

    public String getTimeValAbs() {
        return timeValAbs;
    }

    public void setTimeValAbs(String timeValAbs) {
        this.timeValAbs = timeValAbs == null ? null : timeValAbs.trim();
    }

    public Long getTimeValRal() {
        return timeValRal;
    }

    public void setTimeValRal(Long timeValRal) {
        this.timeValRal = timeValRal;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit == null ? null : timeUnit.trim();
    }

    public String getChartState() {
        return chartState;
    }

    public void setChartState(String chartState) {
        this.chartState = chartState == null ? null : chartState.trim();
    }
}