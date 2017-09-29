package com.frontend.web.bo;

public class TdRouteRule {
    private Long routeId;

    private String getValueExpr;

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getGetValueExpr() {
        return getValueExpr;
    }

    public void setGetValueExpr(String getValueExpr) {
        this.getValueExpr = getValueExpr == null ? null : getValueExpr.trim();
    }
}