package com.frontend.web.bo;

import java.util.ArrayList;
import java.util.List;

public class TdViewPageCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public TdViewPageCriteria() {
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

        public Criteria andPageIdIsNull() {
            addCriterion("page_id is null");
            return (Criteria) this;
        }

        public Criteria andPageIdIsNotNull() {
            addCriterion("page_id is not null");
            return (Criteria) this;
        }

        public Criteria andPageIdEqualTo(Long value) {
            addCriterion("page_id =", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdNotEqualTo(Long value) {
            addCriterion("page_id <>", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdGreaterThan(Long value) {
            addCriterion("page_id >", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("page_id >=", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdLessThan(Long value) {
            addCriterion("page_id <", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdLessThanOrEqualTo(Long value) {
            addCriterion("page_id <=", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdIn(List<Long> values) {
            addCriterion("page_id in", values, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdNotIn(List<Long> values) {
            addCriterion("page_id not in", values, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdBetween(Long value1, Long value2) {
            addCriterion("page_id between", value1, value2, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdNotBetween(Long value1, Long value2) {
            addCriterion("page_id not between", value1, value2, "pageId");
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

        public Criteria andPageNameIsNull() {
            addCriterion("page_name is null");
            return (Criteria) this;
        }

        public Criteria andPageNameIsNotNull() {
            addCriterion("page_name is not null");
            return (Criteria) this;
        }

        public Criteria andPageNameEqualTo(String value) {
            addCriterion("page_name =", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameNotEqualTo(String value) {
            addCriterion("page_name <>", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameGreaterThan(String value) {
            addCriterion("page_name >", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameGreaterThanOrEqualTo(String value) {
            addCriterion("page_name >=", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameLessThan(String value) {
            addCriterion("page_name <", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameLessThanOrEqualTo(String value) {
            addCriterion("page_name <=", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameLike(String value) {
            addCriterion("page_name like", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameNotLike(String value) {
            addCriterion("page_name not like", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameIn(List<String> values) {
            addCriterion("page_name in", values, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameNotIn(List<String> values) {
            addCriterion("page_name not in", values, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameBetween(String value1, String value2) {
            addCriterion("page_name between", value1, value2, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameNotBetween(String value1, String value2) {
            addCriterion("page_name not between", value1, value2, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageUrlIsNull() {
            addCriterion("page_url is null");
            return (Criteria) this;
        }

        public Criteria andPageUrlIsNotNull() {
            addCriterion("page_url is not null");
            return (Criteria) this;
        }

        public Criteria andPageUrlEqualTo(String value) {
            addCriterion("page_url =", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotEqualTo(String value) {
            addCriterion("page_url <>", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlGreaterThan(String value) {
            addCriterion("page_url >", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("page_url >=", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlLessThan(String value) {
            addCriterion("page_url <", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlLessThanOrEqualTo(String value) {
            addCriterion("page_url <=", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlLike(String value) {
            addCriterion("page_url like", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotLike(String value) {
            addCriterion("page_url not like", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlIn(List<String> values) {
            addCriterion("page_url in", values, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotIn(List<String> values) {
            addCriterion("page_url not in", values, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlBetween(String value1, String value2) {
            addCriterion("page_url between", value1, value2, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotBetween(String value1, String value2) {
            addCriterion("page_url not between", value1, value2, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageTypeIsNull() {
            addCriterion("page_type is null");
            return (Criteria) this;
        }

        public Criteria andPageTypeIsNotNull() {
            addCriterion("page_type is not null");
            return (Criteria) this;
        }

        public Criteria andPageTypeEqualTo(String value) {
            addCriterion("page_type =", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeNotEqualTo(String value) {
            addCriterion("page_type <>", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeGreaterThan(String value) {
            addCriterion("page_type >", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("page_type >=", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeLessThan(String value) {
            addCriterion("page_type <", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeLessThanOrEqualTo(String value) {
            addCriterion("page_type <=", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeLike(String value) {
            addCriterion("page_type like", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeNotLike(String value) {
            addCriterion("page_type not like", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeIn(List<String> values) {
            addCriterion("page_type in", values, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeNotIn(List<String> values) {
            addCriterion("page_type not in", values, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeBetween(String value1, String value2) {
            addCriterion("page_type between", value1, value2, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeNotBetween(String value1, String value2) {
            addCriterion("page_type not between", value1, value2, "pageType");
            return (Criteria) this;
        }

        public Criteria andParentGreenCodeIsNull() {
            addCriterion("parent_green_code is null");
            return (Criteria) this;
        }

        public Criteria andParentGreenCodeIsNotNull() {
            addCriterion("parent_green_code is not null");
            return (Criteria) this;
        }

        public Criteria andParentGreenCodeEqualTo(String value) {
            addCriterion("parent_green_code =", value, "parentGreenCode");
            return (Criteria) this;
        }

        public Criteria andParentGreenCodeNotEqualTo(String value) {
            addCriterion("parent_green_code <>", value, "parentGreenCode");
            return (Criteria) this;
        }

        public Criteria andParentGreenCodeGreaterThan(String value) {
            addCriterion("parent_green_code >", value, "parentGreenCode");
            return (Criteria) this;
        }

        public Criteria andParentGreenCodeGreaterThanOrEqualTo(String value) {
            addCriterion("parent_green_code >=", value, "parentGreenCode");
            return (Criteria) this;
        }

        public Criteria andParentGreenCodeLessThan(String value) {
            addCriterion("parent_green_code <", value, "parentGreenCode");
            return (Criteria) this;
        }

        public Criteria andParentGreenCodeLessThanOrEqualTo(String value) {
            addCriterion("parent_green_code <=", value, "parentGreenCode");
            return (Criteria) this;
        }

        public Criteria andParentGreenCodeLike(String value) {
            addCriterion("parent_green_code like", value, "parentGreenCode");
            return (Criteria) this;
        }

        public Criteria andParentGreenCodeNotLike(String value) {
            addCriterion("parent_green_code not like", value, "parentGreenCode");
            return (Criteria) this;
        }

        public Criteria andParentGreenCodeIn(List<String> values) {
            addCriterion("parent_green_code in", values, "parentGreenCode");
            return (Criteria) this;
        }

        public Criteria andParentGreenCodeNotIn(List<String> values) {
            addCriterion("parent_green_code not in", values, "parentGreenCode");
            return (Criteria) this;
        }

        public Criteria andParentGreenCodeBetween(String value1, String value2) {
            addCriterion("parent_green_code between", value1, value2, "parentGreenCode");
            return (Criteria) this;
        }

        public Criteria andParentGreenCodeNotBetween(String value1, String value2) {
            addCriterion("parent_green_code not between", value1, value2, "parentGreenCode");
            return (Criteria) this;
        }

        public Criteria andPageStateIsNull() {
            addCriterion("page_state is null");
            return (Criteria) this;
        }

        public Criteria andPageStateIsNotNull() {
            addCriterion("page_state is not null");
            return (Criteria) this;
        }

        public Criteria andPageStateEqualTo(String value) {
            addCriterion("page_state =", value, "pageState");
            return (Criteria) this;
        }

        public Criteria andPageStateNotEqualTo(String value) {
            addCriterion("page_state <>", value, "pageState");
            return (Criteria) this;
        }

        public Criteria andPageStateGreaterThan(String value) {
            addCriterion("page_state >", value, "pageState");
            return (Criteria) this;
        }

        public Criteria andPageStateGreaterThanOrEqualTo(String value) {
            addCriterion("page_state >=", value, "pageState");
            return (Criteria) this;
        }

        public Criteria andPageStateLessThan(String value) {
            addCriterion("page_state <", value, "pageState");
            return (Criteria) this;
        }

        public Criteria andPageStateLessThanOrEqualTo(String value) {
            addCriterion("page_state <=", value, "pageState");
            return (Criteria) this;
        }

        public Criteria andPageStateLike(String value) {
            addCriterion("page_state like", value, "pageState");
            return (Criteria) this;
        }

        public Criteria andPageStateNotLike(String value) {
            addCriterion("page_state not like", value, "pageState");
            return (Criteria) this;
        }

        public Criteria andPageStateIn(List<String> values) {
            addCriterion("page_state in", values, "pageState");
            return (Criteria) this;
        }

        public Criteria andPageStateNotIn(List<String> values) {
            addCriterion("page_state not in", values, "pageState");
            return (Criteria) this;
        }

        public Criteria andPageStateBetween(String value1, String value2) {
            addCriterion("page_state between", value1, value2, "pageState");
            return (Criteria) this;
        }

        public Criteria andPageStateNotBetween(String value1, String value2) {
            addCriterion("page_state not between", value1, value2, "pageState");
            return (Criteria) this;
        }

        public Criteria andStaytimeValueIsNull() {
            addCriterion("staytime_value is null");
            return (Criteria) this;
        }

        public Criteria andStaytimeValueIsNotNull() {
            addCriterion("staytime_value is not null");
            return (Criteria) this;
        }

        public Criteria andStaytimeValueEqualTo(Long value) {
            addCriterion("staytime_value =", value, "staytimeValue");
            return (Criteria) this;
        }

        public Criteria andStaytimeValueNotEqualTo(Long value) {
            addCriterion("staytime_value <>", value, "staytimeValue");
            return (Criteria) this;
        }

        public Criteria andStaytimeValueGreaterThan(Long value) {
            addCriterion("staytime_value >", value, "staytimeValue");
            return (Criteria) this;
        }

        public Criteria andStaytimeValueGreaterThanOrEqualTo(Long value) {
            addCriterion("staytime_value >=", value, "staytimeValue");
            return (Criteria) this;
        }

        public Criteria andStaytimeValueLessThan(Long value) {
            addCriterion("staytime_value <", value, "staytimeValue");
            return (Criteria) this;
        }

        public Criteria andStaytimeValueLessThanOrEqualTo(Long value) {
            addCriterion("staytime_value <=", value, "staytimeValue");
            return (Criteria) this;
        }

        public Criteria andStaytimeValueIn(List<Long> values) {
            addCriterion("staytime_value in", values, "staytimeValue");
            return (Criteria) this;
        }

        public Criteria andStaytimeValueNotIn(List<Long> values) {
            addCriterion("staytime_value not in", values, "staytimeValue");
            return (Criteria) this;
        }

        public Criteria andStaytimeValueBetween(Long value1, Long value2) {
            addCriterion("staytime_value between", value1, value2, "staytimeValue");
            return (Criteria) this;
        }

        public Criteria andStaytimeValueNotBetween(Long value1, Long value2) {
            addCriterion("staytime_value not between", value1, value2, "staytimeValue");
            return (Criteria) this;
        }

        public Criteria andStaytimeUnitIsNull() {
            addCriterion("staytime_unit is null");
            return (Criteria) this;
        }

        public Criteria andStaytimeUnitIsNotNull() {
            addCriterion("staytime_unit is not null");
            return (Criteria) this;
        }

        public Criteria andStaytimeUnitEqualTo(String value) {
            addCriterion("staytime_unit =", value, "staytimeUnit");
            return (Criteria) this;
        }

        public Criteria andStaytimeUnitNotEqualTo(String value) {
            addCriterion("staytime_unit <>", value, "staytimeUnit");
            return (Criteria) this;
        }

        public Criteria andStaytimeUnitGreaterThan(String value) {
            addCriterion("staytime_unit >", value, "staytimeUnit");
            return (Criteria) this;
        }

        public Criteria andStaytimeUnitGreaterThanOrEqualTo(String value) {
            addCriterion("staytime_unit >=", value, "staytimeUnit");
            return (Criteria) this;
        }

        public Criteria andStaytimeUnitLessThan(String value) {
            addCriterion("staytime_unit <", value, "staytimeUnit");
            return (Criteria) this;
        }

        public Criteria andStaytimeUnitLessThanOrEqualTo(String value) {
            addCriterion("staytime_unit <=", value, "staytimeUnit");
            return (Criteria) this;
        }

        public Criteria andStaytimeUnitLike(String value) {
            addCriterion("staytime_unit like", value, "staytimeUnit");
            return (Criteria) this;
        }

        public Criteria andStaytimeUnitNotLike(String value) {
            addCriterion("staytime_unit not like", value, "staytimeUnit");
            return (Criteria) this;
        }

        public Criteria andStaytimeUnitIn(List<String> values) {
            addCriterion("staytime_unit in", values, "staytimeUnit");
            return (Criteria) this;
        }

        public Criteria andStaytimeUnitNotIn(List<String> values) {
            addCriterion("staytime_unit not in", values, "staytimeUnit");
            return (Criteria) this;
        }

        public Criteria andStaytimeUnitBetween(String value1, String value2) {
            addCriterion("staytime_unit between", value1, value2, "staytimeUnit");
            return (Criteria) this;
        }

        public Criteria andStaytimeUnitNotBetween(String value1, String value2) {
            addCriterion("staytime_unit not between", value1, value2, "staytimeUnit");
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