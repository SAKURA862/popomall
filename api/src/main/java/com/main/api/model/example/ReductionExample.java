package com.main.api.model.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReductionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReductionExample() {
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

        public Criteria andReducIdIsNull() {
            addCriterion("reduc_id is null");
            return (Criteria) this;
        }

        public Criteria andReducIdIsNotNull() {
            addCriterion("reduc_id is not null");
            return (Criteria) this;
        }

        public Criteria andReducIdEqualTo(Long value) {
            addCriterion("reduc_id =", value, "reducId");
            return (Criteria) this;
        }

        public Criteria andReducIdNotEqualTo(Long value) {
            addCriterion("reduc_id <>", value, "reducId");
            return (Criteria) this;
        }

        public Criteria andReducIdGreaterThan(Long value) {
            addCriterion("reduc_id >", value, "reducId");
            return (Criteria) this;
        }

        public Criteria andReducIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reduc_id >=", value, "reducId");
            return (Criteria) this;
        }

        public Criteria andReducIdLessThan(Long value) {
            addCriterion("reduc_id <", value, "reducId");
            return (Criteria) this;
        }

        public Criteria andReducIdLessThanOrEqualTo(Long value) {
            addCriterion("reduc_id <=", value, "reducId");
            return (Criteria) this;
        }

        public Criteria andReducIdIn(List<Long> values) {
            addCriterion("reduc_id in", values, "reducId");
            return (Criteria) this;
        }

        public Criteria andReducIdNotIn(List<Long> values) {
            addCriterion("reduc_id not in", values, "reducId");
            return (Criteria) this;
        }

        public Criteria andReducIdBetween(Long value1, Long value2) {
            addCriterion("reduc_id between", value1, value2, "reducId");
            return (Criteria) this;
        }

        public Criteria andReducIdNotBetween(Long value1, Long value2) {
            addCriterion("reduc_id not between", value1, value2, "reducId");
            return (Criteria) this;
        }

        public Criteria andReducCommodityTypeIsNull() {
            addCriterion("reduc_commodity_type is null");
            return (Criteria) this;
        }

        public Criteria andReducCommodityTypeIsNotNull() {
            addCriterion("reduc_commodity_type is not null");
            return (Criteria) this;
        }

        public Criteria andReducCommodityTypeEqualTo(Integer value) {
            addCriterion("reduc_commodity_type =", value, "reducCommodityType");
            return (Criteria) this;
        }

        public Criteria andReducCommodityTypeNotEqualTo(Integer value) {
            addCriterion("reduc_commodity_type <>", value, "reducCommodityType");
            return (Criteria) this;
        }

        public Criteria andReducCommodityTypeGreaterThan(Integer value) {
            addCriterion("reduc_commodity_type >", value, "reducCommodityType");
            return (Criteria) this;
        }

        public Criteria andReducCommodityTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("reduc_commodity_type >=", value, "reducCommodityType");
            return (Criteria) this;
        }

        public Criteria andReducCommodityTypeLessThan(Integer value) {
            addCriterion("reduc_commodity_type <", value, "reducCommodityType");
            return (Criteria) this;
        }

        public Criteria andReducCommodityTypeLessThanOrEqualTo(Integer value) {
            addCriterion("reduc_commodity_type <=", value, "reducCommodityType");
            return (Criteria) this;
        }

        public Criteria andReducCommodityTypeIn(List<Integer> values) {
            addCriterion("reduc_commodity_type in", values, "reducCommodityType");
            return (Criteria) this;
        }

        public Criteria andReducCommodityTypeNotIn(List<Integer> values) {
            addCriterion("reduc_commodity_type not in", values, "reducCommodityType");
            return (Criteria) this;
        }

        public Criteria andReducCommodityTypeBetween(Integer value1, Integer value2) {
            addCriterion("reduc_commodity_type between", value1, value2, "reducCommodityType");
            return (Criteria) this;
        }

        public Criteria andReducCommodityTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("reduc_commodity_type not between", value1, value2, "reducCommodityType");
            return (Criteria) this;
        }

        public Criteria andReducSellerIdIsNull() {
            addCriterion("reduc_seller_id is null");
            return (Criteria) this;
        }

        public Criteria andReducSellerIdIsNotNull() {
            addCriterion("reduc_seller_id is not null");
            return (Criteria) this;
        }

        public Criteria andReducSellerIdEqualTo(Long value) {
            addCriterion("reduc_seller_id =", value, "reducSellerId");
            return (Criteria) this;
        }

        public Criteria andReducSellerIdNotEqualTo(Long value) {
            addCriterion("reduc_seller_id <>", value, "reducSellerId");
            return (Criteria) this;
        }

        public Criteria andReducSellerIdGreaterThan(Long value) {
            addCriterion("reduc_seller_id >", value, "reducSellerId");
            return (Criteria) this;
        }

        public Criteria andReducSellerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reduc_seller_id >=", value, "reducSellerId");
            return (Criteria) this;
        }

        public Criteria andReducSellerIdLessThan(Long value) {
            addCriterion("reduc_seller_id <", value, "reducSellerId");
            return (Criteria) this;
        }

        public Criteria andReducSellerIdLessThanOrEqualTo(Long value) {
            addCriterion("reduc_seller_id <=", value, "reducSellerId");
            return (Criteria) this;
        }

        public Criteria andReducSellerIdIn(List<Long> values) {
            addCriterion("reduc_seller_id in", values, "reducSellerId");
            return (Criteria) this;
        }

        public Criteria andReducSellerIdNotIn(List<Long> values) {
            addCriterion("reduc_seller_id not in", values, "reducSellerId");
            return (Criteria) this;
        }

        public Criteria andReducSellerIdBetween(Long value1, Long value2) {
            addCriterion("reduc_seller_id between", value1, value2, "reducSellerId");
            return (Criteria) this;
        }

        public Criteria andReducSellerIdNotBetween(Long value1, Long value2) {
            addCriterion("reduc_seller_id not between", value1, value2, "reducSellerId");
            return (Criteria) this;
        }

        public Criteria andReducCommodityIdIsNull() {
            addCriterion("reduc_commodity_id is null");
            return (Criteria) this;
        }

        public Criteria andReducCommodityIdIsNotNull() {
            addCriterion("reduc_commodity_id is not null");
            return (Criteria) this;
        }

        public Criteria andReducCommodityIdEqualTo(Long value) {
            addCriterion("reduc_commodity_id =", value, "reducCommodityId");
            return (Criteria) this;
        }

        public Criteria andReducCommodityIdNotEqualTo(Long value) {
            addCriterion("reduc_commodity_id <>", value, "reducCommodityId");
            return (Criteria) this;
        }

        public Criteria andReducCommodityIdGreaterThan(Long value) {
            addCriterion("reduc_commodity_id >", value, "reducCommodityId");
            return (Criteria) this;
        }

        public Criteria andReducCommodityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reduc_commodity_id >=", value, "reducCommodityId");
            return (Criteria) this;
        }

        public Criteria andReducCommodityIdLessThan(Long value) {
            addCriterion("reduc_commodity_id <", value, "reducCommodityId");
            return (Criteria) this;
        }

        public Criteria andReducCommodityIdLessThanOrEqualTo(Long value) {
            addCriterion("reduc_commodity_id <=", value, "reducCommodityId");
            return (Criteria) this;
        }

        public Criteria andReducCommodityIdIn(List<Long> values) {
            addCriterion("reduc_commodity_id in", values, "reducCommodityId");
            return (Criteria) this;
        }

        public Criteria andReducCommodityIdNotIn(List<Long> values) {
            addCriterion("reduc_commodity_id not in", values, "reducCommodityId");
            return (Criteria) this;
        }

        public Criteria andReducCommodityIdBetween(Long value1, Long value2) {
            addCriterion("reduc_commodity_id between", value1, value2, "reducCommodityId");
            return (Criteria) this;
        }

        public Criteria andReducCommodityIdNotBetween(Long value1, Long value2) {
            addCriterion("reduc_commodity_id not between", value1, value2, "reducCommodityId");
            return (Criteria) this;
        }

        public Criteria andReducThresholdIsNull() {
            addCriterion("reduc_threshold is null");
            return (Criteria) this;
        }

        public Criteria andReducThresholdIsNotNull() {
            addCriterion("reduc_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andReducThresholdEqualTo(BigDecimal value) {
            addCriterion("reduc_threshold =", value, "reducThreshold");
            return (Criteria) this;
        }

        public Criteria andReducThresholdNotEqualTo(BigDecimal value) {
            addCriterion("reduc_threshold <>", value, "reducThreshold");
            return (Criteria) this;
        }

        public Criteria andReducThresholdGreaterThan(BigDecimal value) {
            addCriterion("reduc_threshold >", value, "reducThreshold");
            return (Criteria) this;
        }

        public Criteria andReducThresholdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reduc_threshold >=", value, "reducThreshold");
            return (Criteria) this;
        }

        public Criteria andReducThresholdLessThan(BigDecimal value) {
            addCriterion("reduc_threshold <", value, "reducThreshold");
            return (Criteria) this;
        }

        public Criteria andReducThresholdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reduc_threshold <=", value, "reducThreshold");
            return (Criteria) this;
        }

        public Criteria andReducThresholdIn(List<BigDecimal> values) {
            addCriterion("reduc_threshold in", values, "reducThreshold");
            return (Criteria) this;
        }

        public Criteria andReducThresholdNotIn(List<BigDecimal> values) {
            addCriterion("reduc_threshold not in", values, "reducThreshold");
            return (Criteria) this;
        }

        public Criteria andReducThresholdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reduc_threshold between", value1, value2, "reducThreshold");
            return (Criteria) this;
        }

        public Criteria andReducThresholdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reduc_threshold not between", value1, value2, "reducThreshold");
            return (Criteria) this;
        }

        public Criteria andReducReductionIsNull() {
            addCriterion("reduc_reduction is null");
            return (Criteria) this;
        }

        public Criteria andReducReductionIsNotNull() {
            addCriterion("reduc_reduction is not null");
            return (Criteria) this;
        }

        public Criteria andReducReductionEqualTo(BigDecimal value) {
            addCriterion("reduc_reduction =", value, "reducReduction");
            return (Criteria) this;
        }

        public Criteria andReducReductionNotEqualTo(BigDecimal value) {
            addCriterion("reduc_reduction <>", value, "reducReduction");
            return (Criteria) this;
        }

        public Criteria andReducReductionGreaterThan(BigDecimal value) {
            addCriterion("reduc_reduction >", value, "reducReduction");
            return (Criteria) this;
        }

        public Criteria andReducReductionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reduc_reduction >=", value, "reducReduction");
            return (Criteria) this;
        }

        public Criteria andReducReductionLessThan(BigDecimal value) {
            addCriterion("reduc_reduction <", value, "reducReduction");
            return (Criteria) this;
        }

        public Criteria andReducReductionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reduc_reduction <=", value, "reducReduction");
            return (Criteria) this;
        }

        public Criteria andReducReductionIn(List<BigDecimal> values) {
            addCriterion("reduc_reduction in", values, "reducReduction");
            return (Criteria) this;
        }

        public Criteria andReducReductionNotIn(List<BigDecimal> values) {
            addCriterion("reduc_reduction not in", values, "reducReduction");
            return (Criteria) this;
        }

        public Criteria andReducReductionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reduc_reduction between", value1, value2, "reducReduction");
            return (Criteria) this;
        }

        public Criteria andReducReductionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reduc_reduction not between", value1, value2, "reducReduction");
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