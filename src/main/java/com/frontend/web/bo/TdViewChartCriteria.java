package com.frontend.web.bo;

import java.util.ArrayList;
import java.util.List;

public class TdViewChartCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public TdViewChartCriteria() {
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

        public Criteria andChartIdIsNull() {
            addCriterion("chart_id is null");
            return (Criteria) this;
        }

        public Criteria andChartIdIsNotNull() {
            addCriterion("chart_id is not null");
            return (Criteria) this;
        }

        public Criteria andChartIdEqualTo(Long value) {
            addCriterion("chart_id =", value, "chartId");
            return (Criteria) this;
        }

        public Criteria andChartIdNotEqualTo(Long value) {
            addCriterion("chart_id <>", value, "chartId");
            return (Criteria) this;
        }

        public Criteria andChartIdGreaterThan(Long value) {
            addCriterion("chart_id >", value, "chartId");
            return (Criteria) this;
        }

        public Criteria andChartIdGreaterThanOrEqualTo(Long value) {
            addCriterion("chart_id >=", value, "chartId");
            return (Criteria) this;
        }

        public Criteria andChartIdLessThan(Long value) {
            addCriterion("chart_id <", value, "chartId");
            return (Criteria) this;
        }

        public Criteria andChartIdLessThanOrEqualTo(Long value) {
            addCriterion("chart_id <=", value, "chartId");
            return (Criteria) this;
        }

        public Criteria andChartIdIn(List<Long> values) {
            addCriterion("chart_id in", values, "chartId");
            return (Criteria) this;
        }

        public Criteria andChartIdNotIn(List<Long> values) {
            addCriterion("chart_id not in", values, "chartId");
            return (Criteria) this;
        }

        public Criteria andChartIdBetween(Long value1, Long value2) {
            addCriterion("chart_id between", value1, value2, "chartId");
            return (Criteria) this;
        }

        public Criteria andChartIdNotBetween(Long value1, Long value2) {
            addCriterion("chart_id not between", value1, value2, "chartId");
            return (Criteria) this;
        }

        public Criteria andChartCodeIsNull() {
            addCriterion("chart_code is null");
            return (Criteria) this;
        }

        public Criteria andChartCodeIsNotNull() {
            addCriterion("chart_code is not null");
            return (Criteria) this;
        }

        public Criteria andChartCodeEqualTo(String value) {
            addCriterion("chart_code =", value, "chartCode");
            return (Criteria) this;
        }

        public Criteria andChartCodeNotEqualTo(String value) {
            addCriterion("chart_code <>", value, "chartCode");
            return (Criteria) this;
        }

        public Criteria andChartCodeGreaterThan(String value) {
            addCriterion("chart_code >", value, "chartCode");
            return (Criteria) this;
        }

        public Criteria andChartCodeGreaterThanOrEqualTo(String value) {
            addCriterion("chart_code >=", value, "chartCode");
            return (Criteria) this;
        }

        public Criteria andChartCodeLessThan(String value) {
            addCriterion("chart_code <", value, "chartCode");
            return (Criteria) this;
        }

        public Criteria andChartCodeLessThanOrEqualTo(String value) {
            addCriterion("chart_code <=", value, "chartCode");
            return (Criteria) this;
        }

        public Criteria andChartCodeLike(String value) {
            addCriterion("chart_code like", value, "chartCode");
            return (Criteria) this;
        }

        public Criteria andChartCodeNotLike(String value) {
            addCriterion("chart_code not like", value, "chartCode");
            return (Criteria) this;
        }

        public Criteria andChartCodeIn(List<String> values) {
            addCriterion("chart_code in", values, "chartCode");
            return (Criteria) this;
        }

        public Criteria andChartCodeNotIn(List<String> values) {
            addCriterion("chart_code not in", values, "chartCode");
            return (Criteria) this;
        }

        public Criteria andChartCodeBetween(String value1, String value2) {
            addCriterion("chart_code between", value1, value2, "chartCode");
            return (Criteria) this;
        }

        public Criteria andChartCodeNotBetween(String value1, String value2) {
            addCriterion("chart_code not between", value1, value2, "chartCode");
            return (Criteria) this;
        }

        public Criteria andChartNameIsNull() {
            addCriterion("chart_name is null");
            return (Criteria) this;
        }

        public Criteria andChartNameIsNotNull() {
            addCriterion("chart_name is not null");
            return (Criteria) this;
        }

        public Criteria andChartNameEqualTo(String value) {
            addCriterion("chart_name =", value, "chartName");
            return (Criteria) this;
        }

        public Criteria andChartNameNotEqualTo(String value) {
            addCriterion("chart_name <>", value, "chartName");
            return (Criteria) this;
        }

        public Criteria andChartNameGreaterThan(String value) {
            addCriterion("chart_name >", value, "chartName");
            return (Criteria) this;
        }

        public Criteria andChartNameGreaterThanOrEqualTo(String value) {
            addCriterion("chart_name >=", value, "chartName");
            return (Criteria) this;
        }

        public Criteria andChartNameLessThan(String value) {
            addCriterion("chart_name <", value, "chartName");
            return (Criteria) this;
        }

        public Criteria andChartNameLessThanOrEqualTo(String value) {
            addCriterion("chart_name <=", value, "chartName");
            return (Criteria) this;
        }

        public Criteria andChartNameLike(String value) {
            addCriterion("chart_name like", value, "chartName");
            return (Criteria) this;
        }

        public Criteria andChartNameNotLike(String value) {
            addCriterion("chart_name not like", value, "chartName");
            return (Criteria) this;
        }

        public Criteria andChartNameIn(List<String> values) {
            addCriterion("chart_name in", values, "chartName");
            return (Criteria) this;
        }

        public Criteria andChartNameNotIn(List<String> values) {
            addCriterion("chart_name not in", values, "chartName");
            return (Criteria) this;
        }

        public Criteria andChartNameBetween(String value1, String value2) {
            addCriterion("chart_name between", value1, value2, "chartName");
            return (Criteria) this;
        }

        public Criteria andChartNameNotBetween(String value1, String value2) {
            addCriterion("chart_name not between", value1, value2, "chartName");
            return (Criteria) this;
        }

        public Criteria andChartTypeCodeIsNull() {
            addCriterion("chart_type_code is null");
            return (Criteria) this;
        }

        public Criteria andChartTypeCodeIsNotNull() {
            addCriterion("chart_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andChartTypeCodeEqualTo(String value) {
            addCriterion("chart_type_code =", value, "chartTypeCode");
            return (Criteria) this;
        }

        public Criteria andChartTypeCodeNotEqualTo(String value) {
            addCriterion("chart_type_code <>", value, "chartTypeCode");
            return (Criteria) this;
        }

        public Criteria andChartTypeCodeGreaterThan(String value) {
            addCriterion("chart_type_code >", value, "chartTypeCode");
            return (Criteria) this;
        }

        public Criteria andChartTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("chart_type_code >=", value, "chartTypeCode");
            return (Criteria) this;
        }

        public Criteria andChartTypeCodeLessThan(String value) {
            addCriterion("chart_type_code <", value, "chartTypeCode");
            return (Criteria) this;
        }

        public Criteria andChartTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("chart_type_code <=", value, "chartTypeCode");
            return (Criteria) this;
        }

        public Criteria andChartTypeCodeLike(String value) {
            addCriterion("chart_type_code like", value, "chartTypeCode");
            return (Criteria) this;
        }

        public Criteria andChartTypeCodeNotLike(String value) {
            addCriterion("chart_type_code not like", value, "chartTypeCode");
            return (Criteria) this;
        }

        public Criteria andChartTypeCodeIn(List<String> values) {
            addCriterion("chart_type_code in", values, "chartTypeCode");
            return (Criteria) this;
        }

        public Criteria andChartTypeCodeNotIn(List<String> values) {
            addCriterion("chart_type_code not in", values, "chartTypeCode");
            return (Criteria) this;
        }

        public Criteria andChartTypeCodeBetween(String value1, String value2) {
            addCriterion("chart_type_code between", value1, value2, "chartTypeCode");
            return (Criteria) this;
        }

        public Criteria andChartTypeCodeNotBetween(String value1, String value2) {
            addCriterion("chart_type_code not between", value1, value2, "chartTypeCode");
            return (Criteria) this;
        }

        public Criteria andCircleTypeIsNull() {
            addCriterion("circle_type is null");
            return (Criteria) this;
        }

        public Criteria andCircleTypeIsNotNull() {
            addCriterion("circle_type is not null");
            return (Criteria) this;
        }

        public Criteria andCircleTypeEqualTo(String value) {
            addCriterion("circle_type =", value, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeNotEqualTo(String value) {
            addCriterion("circle_type <>", value, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeGreaterThan(String value) {
            addCriterion("circle_type >", value, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("circle_type >=", value, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeLessThan(String value) {
            addCriterion("circle_type <", value, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeLessThanOrEqualTo(String value) {
            addCriterion("circle_type <=", value, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeLike(String value) {
            addCriterion("circle_type like", value, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeNotLike(String value) {
            addCriterion("circle_type not like", value, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeIn(List<String> values) {
            addCriterion("circle_type in", values, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeNotIn(List<String> values) {
            addCriterion("circle_type not in", values, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeBetween(String value1, String value2) {
            addCriterion("circle_type between", value1, value2, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeNotBetween(String value1, String value2) {
            addCriterion("circle_type not between", value1, value2, "circleType");
            return (Criteria) this;
        }

        public Criteria andRuleCodeIsNull() {
            addCriterion("rule_code is null");
            return (Criteria) this;
        }

        public Criteria andRuleCodeIsNotNull() {
            addCriterion("rule_code is not null");
            return (Criteria) this;
        }

        public Criteria andRuleCodeEqualTo(String value) {
            addCriterion("rule_code =", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeNotEqualTo(String value) {
            addCriterion("rule_code <>", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeGreaterThan(String value) {
            addCriterion("rule_code >", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("rule_code >=", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeLessThan(String value) {
            addCriterion("rule_code <", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeLessThanOrEqualTo(String value) {
            addCriterion("rule_code <=", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeLike(String value) {
            addCriterion("rule_code like", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeNotLike(String value) {
            addCriterion("rule_code not like", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeIn(List<String> values) {
            addCriterion("rule_code in", values, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeNotIn(List<String> values) {
            addCriterion("rule_code not in", values, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeBetween(String value1, String value2) {
            addCriterion("rule_code between", value1, value2, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeNotBetween(String value1, String value2) {
            addCriterion("rule_code not between", value1, value2, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andTimeValAbsIsNull() {
            addCriterion("time_val_abs is null");
            return (Criteria) this;
        }

        public Criteria andTimeValAbsIsNotNull() {
            addCriterion("time_val_abs is not null");
            return (Criteria) this;
        }

        public Criteria andTimeValAbsEqualTo(String value) {
            addCriterion("time_val_abs =", value, "timeValAbs");
            return (Criteria) this;
        }

        public Criteria andTimeValAbsNotEqualTo(String value) {
            addCriterion("time_val_abs <>", value, "timeValAbs");
            return (Criteria) this;
        }

        public Criteria andTimeValAbsGreaterThan(String value) {
            addCriterion("time_val_abs >", value, "timeValAbs");
            return (Criteria) this;
        }

        public Criteria andTimeValAbsGreaterThanOrEqualTo(String value) {
            addCriterion("time_val_abs >=", value, "timeValAbs");
            return (Criteria) this;
        }

        public Criteria andTimeValAbsLessThan(String value) {
            addCriterion("time_val_abs <", value, "timeValAbs");
            return (Criteria) this;
        }

        public Criteria andTimeValAbsLessThanOrEqualTo(String value) {
            addCriterion("time_val_abs <=", value, "timeValAbs");
            return (Criteria) this;
        }

        public Criteria andTimeValAbsLike(String value) {
            addCriterion("time_val_abs like", value, "timeValAbs");
            return (Criteria) this;
        }

        public Criteria andTimeValAbsNotLike(String value) {
            addCriterion("time_val_abs not like", value, "timeValAbs");
            return (Criteria) this;
        }

        public Criteria andTimeValAbsIn(List<String> values) {
            addCriterion("time_val_abs in", values, "timeValAbs");
            return (Criteria) this;
        }

        public Criteria andTimeValAbsNotIn(List<String> values) {
            addCriterion("time_val_abs not in", values, "timeValAbs");
            return (Criteria) this;
        }

        public Criteria andTimeValAbsBetween(String value1, String value2) {
            addCriterion("time_val_abs between", value1, value2, "timeValAbs");
            return (Criteria) this;
        }

        public Criteria andTimeValAbsNotBetween(String value1, String value2) {
            addCriterion("time_val_abs not between", value1, value2, "timeValAbs");
            return (Criteria) this;
        }

        public Criteria andTimeValRalIsNull() {
            addCriterion("time_val_ral is null");
            return (Criteria) this;
        }

        public Criteria andTimeValRalIsNotNull() {
            addCriterion("time_val_ral is not null");
            return (Criteria) this;
        }

        public Criteria andTimeValRalEqualTo(Long value) {
            addCriterion("time_val_ral =", value, "timeValRal");
            return (Criteria) this;
        }

        public Criteria andTimeValRalNotEqualTo(Long value) {
            addCriterion("time_val_ral <>", value, "timeValRal");
            return (Criteria) this;
        }

        public Criteria andTimeValRalGreaterThan(Long value) {
            addCriterion("time_val_ral >", value, "timeValRal");
            return (Criteria) this;
        }

        public Criteria andTimeValRalGreaterThanOrEqualTo(Long value) {
            addCriterion("time_val_ral >=", value, "timeValRal");
            return (Criteria) this;
        }

        public Criteria andTimeValRalLessThan(Long value) {
            addCriterion("time_val_ral <", value, "timeValRal");
            return (Criteria) this;
        }

        public Criteria andTimeValRalLessThanOrEqualTo(Long value) {
            addCriterion("time_val_ral <=", value, "timeValRal");
            return (Criteria) this;
        }

        public Criteria andTimeValRalIn(List<Long> values) {
            addCriterion("time_val_ral in", values, "timeValRal");
            return (Criteria) this;
        }

        public Criteria andTimeValRalNotIn(List<Long> values) {
            addCriterion("time_val_ral not in", values, "timeValRal");
            return (Criteria) this;
        }

        public Criteria andTimeValRalBetween(Long value1, Long value2) {
            addCriterion("time_val_ral between", value1, value2, "timeValRal");
            return (Criteria) this;
        }

        public Criteria andTimeValRalNotBetween(Long value1, Long value2) {
            addCriterion("time_val_ral not between", value1, value2, "timeValRal");
            return (Criteria) this;
        }

        public Criteria andTimeUnitIsNull() {
            addCriterion("time_unit is null");
            return (Criteria) this;
        }

        public Criteria andTimeUnitIsNotNull() {
            addCriterion("time_unit is not null");
            return (Criteria) this;
        }

        public Criteria andTimeUnitEqualTo(String value) {
            addCriterion("time_unit =", value, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitNotEqualTo(String value) {
            addCriterion("time_unit <>", value, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitGreaterThan(String value) {
            addCriterion("time_unit >", value, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitGreaterThanOrEqualTo(String value) {
            addCriterion("time_unit >=", value, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitLessThan(String value) {
            addCriterion("time_unit <", value, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitLessThanOrEqualTo(String value) {
            addCriterion("time_unit <=", value, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitLike(String value) {
            addCriterion("time_unit like", value, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitNotLike(String value) {
            addCriterion("time_unit not like", value, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitIn(List<String> values) {
            addCriterion("time_unit in", values, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitNotIn(List<String> values) {
            addCriterion("time_unit not in", values, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitBetween(String value1, String value2) {
            addCriterion("time_unit between", value1, value2, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitNotBetween(String value1, String value2) {
            addCriterion("time_unit not between", value1, value2, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andChartStateIsNull() {
            addCriterion("chart_state is null");
            return (Criteria) this;
        }

        public Criteria andChartStateIsNotNull() {
            addCriterion("chart_state is not null");
            return (Criteria) this;
        }

        public Criteria andChartStateEqualTo(String value) {
            addCriterion("chart_state =", value, "chartState");
            return (Criteria) this;
        }

        public Criteria andChartStateNotEqualTo(String value) {
            addCriterion("chart_state <>", value, "chartState");
            return (Criteria) this;
        }

        public Criteria andChartStateGreaterThan(String value) {
            addCriterion("chart_state >", value, "chartState");
            return (Criteria) this;
        }

        public Criteria andChartStateGreaterThanOrEqualTo(String value) {
            addCriterion("chart_state >=", value, "chartState");
            return (Criteria) this;
        }

        public Criteria andChartStateLessThan(String value) {
            addCriterion("chart_state <", value, "chartState");
            return (Criteria) this;
        }

        public Criteria andChartStateLessThanOrEqualTo(String value) {
            addCriterion("chart_state <=", value, "chartState");
            return (Criteria) this;
        }

        public Criteria andChartStateLike(String value) {
            addCriterion("chart_state like", value, "chartState");
            return (Criteria) this;
        }

        public Criteria andChartStateNotLike(String value) {
            addCriterion("chart_state not like", value, "chartState");
            return (Criteria) this;
        }

        public Criteria andChartStateIn(List<String> values) {
            addCriterion("chart_state in", values, "chartState");
            return (Criteria) this;
        }

        public Criteria andChartStateNotIn(List<String> values) {
            addCriterion("chart_state not in", values, "chartState");
            return (Criteria) this;
        }

        public Criteria andChartStateBetween(String value1, String value2) {
            addCriterion("chart_state between", value1, value2, "chartState");
            return (Criteria) this;
        }

        public Criteria andChartStateNotBetween(String value1, String value2) {
            addCriterion("chart_state not between", value1, value2, "chartState");
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