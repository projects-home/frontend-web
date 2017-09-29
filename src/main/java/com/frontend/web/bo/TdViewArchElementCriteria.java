package com.frontend.web.bo;

import java.util.ArrayList;
import java.util.List;

public class TdViewArchElementCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public TdViewArchElementCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andElementIdIsNull() {
            addCriterion("element_id is null");
            return (Criteria) this;
        }

        public Criteria andElementIdIsNotNull() {
            addCriterion("element_id is not null");
            return (Criteria) this;
        }

        public Criteria andElementIdEqualTo(Long value) {
            addCriterion("element_id =", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdNotEqualTo(Long value) {
            addCriterion("element_id <>", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdGreaterThan(Long value) {
            addCriterion("element_id >", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdGreaterThanOrEqualTo(Long value) {
            addCriterion("element_id >=", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdLessThan(Long value) {
            addCriterion("element_id <", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdLessThanOrEqualTo(Long value) {
            addCriterion("element_id <=", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdIn(List<Long> values) {
            addCriterion("element_id in", values, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdNotIn(List<Long> values) {
            addCriterion("element_id not in", values, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdBetween(Long value1, Long value2) {
            addCriterion("element_id between", value1, value2, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdNotBetween(Long value1, Long value2) {
            addCriterion("element_id not between", value1, value2, "elementId");
            return (Criteria) this;
        }

        public Criteria andPageCodeIsNull() {
            addCriterion("page_code is null");
            return (Criteria) this;
        }

        public Criteria andPageCodeIsNotNull() {
            addCriterion("page_code is not null");
            return (Criteria) this;
        }

        public Criteria andPageCodeEqualTo(String value) {
            addCriterion("page_code =", value, "pageCode");
            return (Criteria) this;
        }

        public Criteria andPageCodeNotEqualTo(String value) {
            addCriterion("page_code <>", value, "pageCode");
            return (Criteria) this;
        }

        public Criteria andPageCodeGreaterThan(String value) {
            addCriterion("page_code >", value, "pageCode");
            return (Criteria) this;
        }

        public Criteria andPageCodeGreaterThanOrEqualTo(String value) {
            addCriterion("page_code >=", value, "pageCode");
            return (Criteria) this;
        }

        public Criteria andPageCodeLessThan(String value) {
            addCriterion("page_code <", value, "pageCode");
            return (Criteria) this;
        }

        public Criteria andPageCodeLessThanOrEqualTo(String value) {
            addCriterion("page_code <=", value, "pageCode");
            return (Criteria) this;
        }

        public Criteria andPageCodeLike(String value) {
            addCriterion("page_code like", value, "pageCode");
            return (Criteria) this;
        }

        public Criteria andPageCodeNotLike(String value) {
            addCriterion("page_code not like", value, "pageCode");
            return (Criteria) this;
        }

        public Criteria andPageCodeIn(List<String> values) {
            addCriterion("page_code in", values, "pageCode");
            return (Criteria) this;
        }

        public Criteria andPageCodeNotIn(List<String> values) {
            addCriterion("page_code not in", values, "pageCode");
            return (Criteria) this;
        }

        public Criteria andPageCodeBetween(String value1, String value2) {
            addCriterion("page_code between", value1, value2, "pageCode");
            return (Criteria) this;
        }

        public Criteria andPageCodeNotBetween(String value1, String value2) {
            addCriterion("page_code not between", value1, value2, "pageCode");
            return (Criteria) this;
        }

        public Criteria andArchCodeIsNull() {
            addCriterion("arch_code is null");
            return (Criteria) this;
        }

        public Criteria andArchCodeIsNotNull() {
            addCriterion("arch_code is not null");
            return (Criteria) this;
        }

        public Criteria andArchCodeEqualTo(String value) {
            addCriterion("arch_code =", value, "archCode");
            return (Criteria) this;
        }

        public Criteria andArchCodeNotEqualTo(String value) {
            addCriterion("arch_code <>", value, "archCode");
            return (Criteria) this;
        }

        public Criteria andArchCodeGreaterThan(String value) {
            addCriterion("arch_code >", value, "archCode");
            return (Criteria) this;
        }

        public Criteria andArchCodeGreaterThanOrEqualTo(String value) {
            addCriterion("arch_code >=", value, "archCode");
            return (Criteria) this;
        }

        public Criteria andArchCodeLessThan(String value) {
            addCriterion("arch_code <", value, "archCode");
            return (Criteria) this;
        }

        public Criteria andArchCodeLessThanOrEqualTo(String value) {
            addCriterion("arch_code <=", value, "archCode");
            return (Criteria) this;
        }

        public Criteria andArchCodeLike(String value) {
            addCriterion("arch_code like", value, "archCode");
            return (Criteria) this;
        }

        public Criteria andArchCodeNotLike(String value) {
            addCriterion("arch_code not like", value, "archCode");
            return (Criteria) this;
        }

        public Criteria andArchCodeIn(List<String> values) {
            addCriterion("arch_code in", values, "archCode");
            return (Criteria) this;
        }

        public Criteria andArchCodeNotIn(List<String> values) {
            addCriterion("arch_code not in", values, "archCode");
            return (Criteria) this;
        }

        public Criteria andArchCodeBetween(String value1, String value2) {
            addCriterion("arch_code between", value1, value2, "archCode");
            return (Criteria) this;
        }

        public Criteria andArchCodeNotBetween(String value1, String value2) {
            addCriterion("arch_code not between", value1, value2, "archCode");
            return (Criteria) this;
        }

        public Criteria andElementCodeIsNull() {
            addCriterion("element_code is null");
            return (Criteria) this;
        }

        public Criteria andElementCodeIsNotNull() {
            addCriterion("element_code is not null");
            return (Criteria) this;
        }

        public Criteria andElementCodeEqualTo(String value) {
            addCriterion("element_code =", value, "elementCode");
            return (Criteria) this;
        }

        public Criteria andElementCodeNotEqualTo(String value) {
            addCriterion("element_code <>", value, "elementCode");
            return (Criteria) this;
        }

        public Criteria andElementCodeGreaterThan(String value) {
            addCriterion("element_code >", value, "elementCode");
            return (Criteria) this;
        }

        public Criteria andElementCodeGreaterThanOrEqualTo(String value) {
            addCriterion("element_code >=", value, "elementCode");
            return (Criteria) this;
        }

        public Criteria andElementCodeLessThan(String value) {
            addCriterion("element_code <", value, "elementCode");
            return (Criteria) this;
        }

        public Criteria andElementCodeLessThanOrEqualTo(String value) {
            addCriterion("element_code <=", value, "elementCode");
            return (Criteria) this;
        }

        public Criteria andElementCodeLike(String value) {
            addCriterion("element_code like", value, "elementCode");
            return (Criteria) this;
        }

        public Criteria andElementCodeNotLike(String value) {
            addCriterion("element_code not like", value, "elementCode");
            return (Criteria) this;
        }

        public Criteria andElementCodeIn(List<String> values) {
            addCriterion("element_code in", values, "elementCode");
            return (Criteria) this;
        }

        public Criteria andElementCodeNotIn(List<String> values) {
            addCriterion("element_code not in", values, "elementCode");
            return (Criteria) this;
        }

        public Criteria andElementCodeBetween(String value1, String value2) {
            addCriterion("element_code between", value1, value2, "elementCode");
            return (Criteria) this;
        }

        public Criteria andElementCodeNotBetween(String value1, String value2) {
            addCriterion("element_code not between", value1, value2, "elementCode");
            return (Criteria) this;
        }

        public Criteria andRouteIdIsNull() {
            addCriterion("route_id is null");
            return (Criteria) this;
        }

        public Criteria andRouteIdIsNotNull() {
            addCriterion("route_id is not null");
            return (Criteria) this;
        }

        public Criteria andRouteIdEqualTo(Long value) {
            addCriterion("route_id =", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdNotEqualTo(Long value) {
            addCriterion("route_id <>", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdGreaterThan(Long value) {
            addCriterion("route_id >", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdGreaterThanOrEqualTo(Long value) {
            addCriterion("route_id >=", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdLessThan(Long value) {
            addCriterion("route_id <", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdLessThanOrEqualTo(Long value) {
            addCriterion("route_id <=", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdIn(List<Long> values) {
            addCriterion("route_id in", values, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdNotIn(List<Long> values) {
            addCriterion("route_id not in", values, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdBetween(Long value1, Long value2) {
            addCriterion("route_id between", value1, value2, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdNotBetween(Long value1, Long value2) {
            addCriterion("route_id not between", value1, value2, "routeId");
            return (Criteria) this;
        }

        public Criteria andElementUrlIsNull() {
            addCriterion("element_url is null");
            return (Criteria) this;
        }

        public Criteria andElementUrlIsNotNull() {
            addCriterion("element_url is not null");
            return (Criteria) this;
        }

        public Criteria andElementUrlEqualTo(String value) {
            addCriterion("element_url =", value, "elementUrl");
            return (Criteria) this;
        }

        public Criteria andElementUrlNotEqualTo(String value) {
            addCriterion("element_url <>", value, "elementUrl");
            return (Criteria) this;
        }

        public Criteria andElementUrlGreaterThan(String value) {
            addCriterion("element_url >", value, "elementUrl");
            return (Criteria) this;
        }

        public Criteria andElementUrlGreaterThanOrEqualTo(String value) {
            addCriterion("element_url >=", value, "elementUrl");
            return (Criteria) this;
        }

        public Criteria andElementUrlLessThan(String value) {
            addCriterion("element_url <", value, "elementUrl");
            return (Criteria) this;
        }

        public Criteria andElementUrlLessThanOrEqualTo(String value) {
            addCriterion("element_url <=", value, "elementUrl");
            return (Criteria) this;
        }

        public Criteria andElementUrlLike(String value) {
            addCriterion("element_url like", value, "elementUrl");
            return (Criteria) this;
        }

        public Criteria andElementUrlNotLike(String value) {
            addCriterion("element_url not like", value, "elementUrl");
            return (Criteria) this;
        }

        public Criteria andElementUrlIn(List<String> values) {
            addCriterion("element_url in", values, "elementUrl");
            return (Criteria) this;
        }

        public Criteria andElementUrlNotIn(List<String> values) {
            addCriterion("element_url not in", values, "elementUrl");
            return (Criteria) this;
        }

        public Criteria andElementUrlBetween(String value1, String value2) {
            addCriterion("element_url between", value1, value2, "elementUrl");
            return (Criteria) this;
        }

        public Criteria andElementUrlNotBetween(String value1, String value2) {
            addCriterion("element_url not between", value1, value2, "elementUrl");
            return (Criteria) this;
        }

        public Criteria andElementTypeCodeIsNull() {
            addCriterion("element_type_code is null");
            return (Criteria) this;
        }

        public Criteria andElementTypeCodeIsNotNull() {
            addCriterion("element_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andElementTypeCodeEqualTo(String value) {
            addCriterion("element_type_code =", value, "elementTypeCode");
            return (Criteria) this;
        }

        public Criteria andElementTypeCodeNotEqualTo(String value) {
            addCriterion("element_type_code <>", value, "elementTypeCode");
            return (Criteria) this;
        }

        public Criteria andElementTypeCodeGreaterThan(String value) {
            addCriterion("element_type_code >", value, "elementTypeCode");
            return (Criteria) this;
        }

        public Criteria andElementTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("element_type_code >=", value, "elementTypeCode");
            return (Criteria) this;
        }

        public Criteria andElementTypeCodeLessThan(String value) {
            addCriterion("element_type_code <", value, "elementTypeCode");
            return (Criteria) this;
        }

        public Criteria andElementTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("element_type_code <=", value, "elementTypeCode");
            return (Criteria) this;
        }

        public Criteria andElementTypeCodeLike(String value) {
            addCriterion("element_type_code like", value, "elementTypeCode");
            return (Criteria) this;
        }

        public Criteria andElementTypeCodeNotLike(String value) {
            addCriterion("element_type_code not like", value, "elementTypeCode");
            return (Criteria) this;
        }

        public Criteria andElementTypeCodeIn(List<String> values) {
            addCriterion("element_type_code in", values, "elementTypeCode");
            return (Criteria) this;
        }

        public Criteria andElementTypeCodeNotIn(List<String> values) {
            addCriterion("element_type_code not in", values, "elementTypeCode");
            return (Criteria) this;
        }

        public Criteria andElementTypeCodeBetween(String value1, String value2) {
            addCriterion("element_type_code between", value1, value2, "elementTypeCode");
            return (Criteria) this;
        }

        public Criteria andElementTypeCodeNotBetween(String value1, String value2) {
            addCriterion("element_type_code not between", value1, value2, "elementTypeCode");
            return (Criteria) this;
        }

        public Criteria andElementCodeVirtualIsNull() {
            addCriterion("element_code_virtual is null");
            return (Criteria) this;
        }

        public Criteria andElementCodeVirtualIsNotNull() {
            addCriterion("element_code_virtual is not null");
            return (Criteria) this;
        }

        public Criteria andElementCodeVirtualEqualTo(String value) {
            addCriterion("element_code_virtual =", value, "elementCodeVirtual");
            return (Criteria) this;
        }

        public Criteria andElementCodeVirtualNotEqualTo(String value) {
            addCriterion("element_code_virtual <>", value, "elementCodeVirtual");
            return (Criteria) this;
        }

        public Criteria andElementCodeVirtualGreaterThan(String value) {
            addCriterion("element_code_virtual >", value, "elementCodeVirtual");
            return (Criteria) this;
        }

        public Criteria andElementCodeVirtualGreaterThanOrEqualTo(String value) {
            addCriterion("element_code_virtual >=", value, "elementCodeVirtual");
            return (Criteria) this;
        }

        public Criteria andElementCodeVirtualLessThan(String value) {
            addCriterion("element_code_virtual <", value, "elementCodeVirtual");
            return (Criteria) this;
        }

        public Criteria andElementCodeVirtualLessThanOrEqualTo(String value) {
            addCriterion("element_code_virtual <=", value, "elementCodeVirtual");
            return (Criteria) this;
        }

        public Criteria andElementCodeVirtualLike(String value) {
            addCriterion("element_code_virtual like", value, "elementCodeVirtual");
            return (Criteria) this;
        }

        public Criteria andElementCodeVirtualNotLike(String value) {
            addCriterion("element_code_virtual not like", value, "elementCodeVirtual");
            return (Criteria) this;
        }

        public Criteria andElementCodeVirtualIn(List<String> values) {
            addCriterion("element_code_virtual in", values, "elementCodeVirtual");
            return (Criteria) this;
        }

        public Criteria andElementCodeVirtualNotIn(List<String> values) {
            addCriterion("element_code_virtual not in", values, "elementCodeVirtual");
            return (Criteria) this;
        }

        public Criteria andElementCodeVirtualBetween(String value1, String value2) {
            addCriterion("element_code_virtual between", value1, value2, "elementCodeVirtual");
            return (Criteria) this;
        }

        public Criteria andElementCodeVirtualNotBetween(String value1, String value2) {
            addCriterion("element_code_virtual not between", value1, value2, "elementCodeVirtual");
            return (Criteria) this;
        }

        public Criteria andElementStateIsNull() {
            addCriterion("element_state is null");
            return (Criteria) this;
        }

        public Criteria andElementStateIsNotNull() {
            addCriterion("element_state is not null");
            return (Criteria) this;
        }

        public Criteria andElementStateEqualTo(String value) {
            addCriterion("element_state =", value, "elementState");
            return (Criteria) this;
        }

        public Criteria andElementStateNotEqualTo(String value) {
            addCriterion("element_state <>", value, "elementState");
            return (Criteria) this;
        }

        public Criteria andElementStateGreaterThan(String value) {
            addCriterion("element_state >", value, "elementState");
            return (Criteria) this;
        }

        public Criteria andElementStateGreaterThanOrEqualTo(String value) {
            addCriterion("element_state >=", value, "elementState");
            return (Criteria) this;
        }

        public Criteria andElementStateLessThan(String value) {
            addCriterion("element_state <", value, "elementState");
            return (Criteria) this;
        }

        public Criteria andElementStateLessThanOrEqualTo(String value) {
            addCriterion("element_state <=", value, "elementState");
            return (Criteria) this;
        }

        public Criteria andElementStateLike(String value) {
            addCriterion("element_state like", value, "elementState");
            return (Criteria) this;
        }

        public Criteria andElementStateNotLike(String value) {
            addCriterion("element_state not like", value, "elementState");
            return (Criteria) this;
        }

        public Criteria andElementStateIn(List<String> values) {
            addCriterion("element_state in", values, "elementState");
            return (Criteria) this;
        }

        public Criteria andElementStateNotIn(List<String> values) {
            addCriterion("element_state not in", values, "elementState");
            return (Criteria) this;
        }

        public Criteria andElementStateBetween(String value1, String value2) {
            addCriterion("element_state between", value1, value2, "elementState");
            return (Criteria) this;
        }

        public Criteria andElementStateNotBetween(String value1, String value2) {
            addCriterion("element_state not between", value1, value2, "elementState");
            return (Criteria) this;
        }

        public Criteria andShowOrderIsNull() {
            addCriterion("show_order is null");
            return (Criteria) this;
        }

        public Criteria andShowOrderIsNotNull() {
            addCriterion("show_order is not null");
            return (Criteria) this;
        }

        public Criteria andShowOrderEqualTo(Integer value) {
            addCriterion("show_order =", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotEqualTo(Integer value) {
            addCriterion("show_order <>", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderGreaterThan(Integer value) {
            addCriterion("show_order >", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_order >=", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderLessThan(Integer value) {
            addCriterion("show_order <", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderLessThanOrEqualTo(Integer value) {
            addCriterion("show_order <=", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderIn(List<Integer> values) {
            addCriterion("show_order in", values, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotIn(List<Integer> values) {
            addCriterion("show_order not in", values, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderBetween(Integer value1, Integer value2) {
            addCriterion("show_order between", value1, value2, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("show_order not between", value1, value2, "showOrder");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}