package com.main.api.model.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiscountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DiscountExample() {
        oredCriteria = new ArrayList<>();
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

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andDiscIdIsNull() {
            addCriterion("disc_id is null");
            return (Criteria) this;
        }

        public Criteria andDiscIdIsNotNull() {
            addCriterion("disc_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiscIdEqualTo(Long value) {
            addCriterion("disc_id =", value, "discId");
            return (Criteria) this;
        }

        public Criteria andDiscIdNotEqualTo(Long value) {
            addCriterion("disc_id <>", value, "discId");
            return (Criteria) this;
        }

        public Criteria andDiscIdGreaterThan(Long value) {
            addCriterion("disc_id >", value, "discId");
            return (Criteria) this;
        }

        public Criteria andDiscIdGreaterThanOrEqualTo(Long value) {
            addCriterion("disc_id >=", value, "discId");
            return (Criteria) this;
        }

        public Criteria andDiscIdLessThan(Long value) {
            addCriterion("disc_id <", value, "discId");
            return (Criteria) this;
        }

        public Criteria andDiscIdLessThanOrEqualTo(Long value) {
            addCriterion("disc_id <=", value, "discId");
            return (Criteria) this;
        }

        public Criteria andDiscIdIn(List<Long> values) {
            addCriterion("disc_id in", values, "discId");
            return (Criteria) this;
        }

        public Criteria andDiscIdNotIn(List<Long> values) {
            addCriterion("disc_id not in", values, "discId");
            return (Criteria) this;
        }

        public Criteria andDiscIdBetween(Long value1, Long value2) {
            addCriterion("disc_id between", value1, value2, "discId");
            return (Criteria) this;
        }

        public Criteria andDiscIdNotBetween(Long value1, Long value2) {
            addCriterion("disc_id not between", value1, value2, "discId");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityTypeIsNull() {
            addCriterion("disc_commodity_type is null");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityTypeIsNotNull() {
            addCriterion("disc_commodity_type is not null");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityTypeEqualTo(Integer value) {
            addCriterion("disc_commodity_type =", value, "discCommodityType");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityTypeNotEqualTo(Integer value) {
            addCriterion("disc_commodity_type <>", value, "discCommodityType");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityTypeGreaterThan(Integer value) {
            addCriterion("disc_commodity_type >", value, "discCommodityType");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("disc_commodity_type >=", value, "discCommodityType");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityTypeLessThan(Integer value) {
            addCriterion("disc_commodity_type <", value, "discCommodityType");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityTypeLessThanOrEqualTo(Integer value) {
            addCriterion("disc_commodity_type <=", value, "discCommodityType");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityTypeIn(List<Integer> values) {
            addCriterion("disc_commodity_type in", values, "discCommodityType");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityTypeNotIn(List<Integer> values) {
            addCriterion("disc_commodity_type not in", values, "discCommodityType");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityTypeBetween(Integer value1, Integer value2) {
            addCriterion("disc_commodity_type between", value1, value2, "discCommodityType");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("disc_commodity_type not between", value1, value2, "discCommodityType");
            return (Criteria) this;
        }

        public Criteria andDiscSellerIdIsNull() {
            addCriterion("disc_seller_id is null");
            return (Criteria) this;
        }

        public Criteria andDiscSellerIdIsNotNull() {
            addCriterion("disc_seller_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiscSellerIdEqualTo(Long value) {
            addCriterion("disc_seller_id =", value, "discSellerId");
            return (Criteria) this;
        }

        public Criteria andDiscSellerIdNotEqualTo(Long value) {
            addCriterion("disc_seller_id <>", value, "discSellerId");
            return (Criteria) this;
        }

        public Criteria andDiscSellerIdGreaterThan(Long value) {
            addCriterion("disc_seller_id >", value, "discSellerId");
            return (Criteria) this;
        }

        public Criteria andDiscSellerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("disc_seller_id >=", value, "discSellerId");
            return (Criteria) this;
        }

        public Criteria andDiscSellerIdLessThan(Long value) {
            addCriterion("disc_seller_id <", value, "discSellerId");
            return (Criteria) this;
        }

        public Criteria andDiscSellerIdLessThanOrEqualTo(Long value) {
            addCriterion("disc_seller_id <=", value, "discSellerId");
            return (Criteria) this;
        }

        public Criteria andDiscSellerIdIn(List<Long> values) {
            addCriterion("disc_seller_id in", values, "discSellerId");
            return (Criteria) this;
        }

        public Criteria andDiscSellerIdNotIn(List<Long> values) {
            addCriterion("disc_seller_id not in", values, "discSellerId");
            return (Criteria) this;
        }

        public Criteria andDiscSellerIdBetween(Long value1, Long value2) {
            addCriterion("disc_seller_id between", value1, value2, "discSellerId");
            return (Criteria) this;
        }

        public Criteria andDiscSellerIdNotBetween(Long value1, Long value2) {
            addCriterion("disc_seller_id not between", value1, value2, "discSellerId");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityIdIsNull() {
            addCriterion("disc_commodity_id is null");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityIdIsNotNull() {
            addCriterion("disc_commodity_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityIdEqualTo(Long value) {
            addCriterion("disc_commodity_id =", value, "discCommodityId");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityIdNotEqualTo(Long value) {
            addCriterion("disc_commodity_id <>", value, "discCommodityId");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityIdGreaterThan(Long value) {
            addCriterion("disc_commodity_id >", value, "discCommodityId");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("disc_commodity_id >=", value, "discCommodityId");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityIdLessThan(Long value) {
            addCriterion("disc_commodity_id <", value, "discCommodityId");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityIdLessThanOrEqualTo(Long value) {
            addCriterion("disc_commodity_id <=", value, "discCommodityId");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityIdIn(List<Long> values) {
            addCriterion("disc_commodity_id in", values, "discCommodityId");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityIdNotIn(List<Long> values) {
            addCriterion("disc_commodity_id not in", values, "discCommodityId");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityIdBetween(Long value1, Long value2) {
            addCriterion("disc_commodity_id between", value1, value2, "discCommodityId");
            return (Criteria) this;
        }

        public Criteria andDiscCommodityIdNotBetween(Long value1, Long value2) {
            addCriterion("disc_commodity_id not between", value1, value2, "discCommodityId");
            return (Criteria) this;
        }

        public Criteria andDiscCountValueIsNull() {
            addCriterion("disc_count_value is null");
            return (Criteria) this;
        }

        public Criteria andDiscCountValueIsNotNull() {
            addCriterion("disc_count_value is not null");
            return (Criteria) this;
        }

        public Criteria andDiscCountValueEqualTo(BigDecimal value) {
            addCriterion("disc_count_value =", value, "discCountValue");
            return (Criteria) this;
        }

        public Criteria andDiscCountValueNotEqualTo(BigDecimal value) {
            addCriterion("disc_count_value <>", value, "discCountValue");
            return (Criteria) this;
        }

        public Criteria andDiscCountValueGreaterThan(BigDecimal value) {
            addCriterion("disc_count_value >", value, "discCountValue");
            return (Criteria) this;
        }

        public Criteria andDiscCountValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("disc_count_value >=", value, "discCountValue");
            return (Criteria) this;
        }

        public Criteria andDiscCountValueLessThan(BigDecimal value) {
            addCriterion("disc_count_value <", value, "discCountValue");
            return (Criteria) this;
        }

        public Criteria andDiscCountValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("disc_count_value <=", value, "discCountValue");
            return (Criteria) this;
        }

        public Criteria andDiscCountValueIn(List<BigDecimal> values) {
            addCriterion("disc_count_value in", values, "discCountValue");
            return (Criteria) this;
        }

        public Criteria andDiscCountValueNotIn(List<BigDecimal> values) {
            addCriterion("disc_count_value not in", values, "discCountValue");
            return (Criteria) this;
        }

        public Criteria andDiscCountValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("disc_count_value between", value1, value2, "discCountValue");
            return (Criteria) this;
        }

        public Criteria andDiscCountValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("disc_count_value not between", value1, value2, "discCountValue");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
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