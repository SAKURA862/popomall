package com.main.api.model.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommodityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommodityExample() {
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

        public Criteria andCommIdIsNull() {
            addCriterion("comm_id is null");
            return (Criteria) this;
        }

        public Criteria andCommIdIsNotNull() {
            addCriterion("comm_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommIdEqualTo(Long value) {
            addCriterion("comm_id =", value, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdNotEqualTo(Long value) {
            addCriterion("comm_id <>", value, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdGreaterThan(Long value) {
            addCriterion("comm_id >", value, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comm_id >=", value, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdLessThan(Long value) {
            addCriterion("comm_id <", value, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdLessThanOrEqualTo(Long value) {
            addCriterion("comm_id <=", value, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdIn(List<Long> values) {
            addCriterion("comm_id in", values, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdNotIn(List<Long> values) {
            addCriterion("comm_id not in", values, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdBetween(Long value1, Long value2) {
            addCriterion("comm_id between", value1, value2, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdNotBetween(Long value1, Long value2) {
            addCriterion("comm_id not between", value1, value2, "commId");
            return (Criteria) this;
        }

        public Criteria andCommNameIsNull() {
            addCriterion("comm_name is null");
            return (Criteria) this;
        }

        public Criteria andCommNameIsNotNull() {
            addCriterion("comm_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommNameEqualTo(String value) {
            addCriterion("comm_name =", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameNotEqualTo(String value) {
            addCriterion("comm_name <>", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameGreaterThan(String value) {
            addCriterion("comm_name >", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameGreaterThanOrEqualTo(String value) {
            addCriterion("comm_name >=", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameLessThan(String value) {
            addCriterion("comm_name <", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameLessThanOrEqualTo(String value) {
            addCriterion("comm_name <=", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameLike(String value) {
            addCriterion("comm_name like", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameNotLike(String value) {
            addCriterion("comm_name not like", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameIn(List<String> values) {
            addCriterion("comm_name in", values, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameNotIn(List<String> values) {
            addCriterion("comm_name not in", values, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameBetween(String value1, String value2) {
            addCriterion("comm_name between", value1, value2, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameNotBetween(String value1, String value2) {
            addCriterion("comm_name not between", value1, value2, "commName");
            return (Criteria) this;
        }

        public Criteria andCommStockIsNull() {
            addCriterion("comm_stock is null");
            return (Criteria) this;
        }

        public Criteria andCommStockIsNotNull() {
            addCriterion("comm_stock is not null");
            return (Criteria) this;
        }

        public Criteria andCommStockEqualTo(Integer value) {
            addCriterion("comm_stock =", value, "commStock");
            return (Criteria) this;
        }

        public Criteria andCommStockNotEqualTo(Integer value) {
            addCriterion("comm_stock <>", value, "commStock");
            return (Criteria) this;
        }

        public Criteria andCommStockGreaterThan(Integer value) {
            addCriterion("comm_stock >", value, "commStock");
            return (Criteria) this;
        }

        public Criteria andCommStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("comm_stock >=", value, "commStock");
            return (Criteria) this;
        }

        public Criteria andCommStockLessThan(Integer value) {
            addCriterion("comm_stock <", value, "commStock");
            return (Criteria) this;
        }

        public Criteria andCommStockLessThanOrEqualTo(Integer value) {
            addCriterion("comm_stock <=", value, "commStock");
            return (Criteria) this;
        }

        public Criteria andCommStockIn(List<Integer> values) {
            addCriterion("comm_stock in", values, "commStock");
            return (Criteria) this;
        }

        public Criteria andCommStockNotIn(List<Integer> values) {
            addCriterion("comm_stock not in", values, "commStock");
            return (Criteria) this;
        }

        public Criteria andCommStockBetween(Integer value1, Integer value2) {
            addCriterion("comm_stock between", value1, value2, "commStock");
            return (Criteria) this;
        }

        public Criteria andCommStockNotBetween(Integer value1, Integer value2) {
            addCriterion("comm_stock not between", value1, value2, "commStock");
            return (Criteria) this;
        }

        public Criteria andCommPriceIsNull() {
            addCriterion("comm_price is null");
            return (Criteria) this;
        }

        public Criteria andCommPriceIsNotNull() {
            addCriterion("comm_price is not null");
            return (Criteria) this;
        }

        public Criteria andCommPriceEqualTo(BigDecimal value) {
            addCriterion("comm_price =", value, "commPrice");
            return (Criteria) this;
        }

        public Criteria andCommPriceNotEqualTo(BigDecimal value) {
            addCriterion("comm_price <>", value, "commPrice");
            return (Criteria) this;
        }

        public Criteria andCommPriceGreaterThan(BigDecimal value) {
            addCriterion("comm_price >", value, "commPrice");
            return (Criteria) this;
        }

        public Criteria andCommPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("comm_price >=", value, "commPrice");
            return (Criteria) this;
        }

        public Criteria andCommPriceLessThan(BigDecimal value) {
            addCriterion("comm_price <", value, "commPrice");
            return (Criteria) this;
        }

        public Criteria andCommPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("comm_price <=", value, "commPrice");
            return (Criteria) this;
        }

        public Criteria andCommPriceIn(List<BigDecimal> values) {
            addCriterion("comm_price in", values, "commPrice");
            return (Criteria) this;
        }

        public Criteria andCommPriceNotIn(List<BigDecimal> values) {
            addCriterion("comm_price not in", values, "commPrice");
            return (Criteria) this;
        }

        public Criteria andCommPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comm_price between", value1, value2, "commPrice");
            return (Criteria) this;
        }

        public Criteria andCommPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comm_price not between", value1, value2, "commPrice");
            return (Criteria) this;
        }

        public Criteria andCommDetailIsNull() {
            addCriterion("comm_detail is null");
            return (Criteria) this;
        }

        public Criteria andCommDetailIsNotNull() {
            addCriterion("comm_detail is not null");
            return (Criteria) this;
        }

        public Criteria andCommDetailEqualTo(String value) {
            addCriterion("comm_detail =", value, "commDetail");
            return (Criteria) this;
        }

        public Criteria andCommDetailNotEqualTo(String value) {
            addCriterion("comm_detail <>", value, "commDetail");
            return (Criteria) this;
        }

        public Criteria andCommDetailGreaterThan(String value) {
            addCriterion("comm_detail >", value, "commDetail");
            return (Criteria) this;
        }

        public Criteria andCommDetailGreaterThanOrEqualTo(String value) {
            addCriterion("comm_detail >=", value, "commDetail");
            return (Criteria) this;
        }

        public Criteria andCommDetailLessThan(String value) {
            addCriterion("comm_detail <", value, "commDetail");
            return (Criteria) this;
        }

        public Criteria andCommDetailLessThanOrEqualTo(String value) {
            addCriterion("comm_detail <=", value, "commDetail");
            return (Criteria) this;
        }

        public Criteria andCommDetailLike(String value) {
            addCriterion("comm_detail like", value, "commDetail");
            return (Criteria) this;
        }

        public Criteria andCommDetailNotLike(String value) {
            addCriterion("comm_detail not like", value, "commDetail");
            return (Criteria) this;
        }

        public Criteria andCommDetailIn(List<String> values) {
            addCriterion("comm_detail in", values, "commDetail");
            return (Criteria) this;
        }

        public Criteria andCommDetailNotIn(List<String> values) {
            addCriterion("comm_detail not in", values, "commDetail");
            return (Criteria) this;
        }

        public Criteria andCommDetailBetween(String value1, String value2) {
            addCriterion("comm_detail between", value1, value2, "commDetail");
            return (Criteria) this;
        }

        public Criteria andCommDetailNotBetween(String value1, String value2) {
            addCriterion("comm_detail not between", value1, value2, "commDetail");
            return (Criteria) this;
        }

        public Criteria andCommTypeIsNull() {
            addCriterion("comm_type is null");
            return (Criteria) this;
        }

        public Criteria andCommTypeIsNotNull() {
            addCriterion("comm_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommTypeEqualTo(String value) {
            addCriterion("comm_type =", value, "commType");
            return (Criteria) this;
        }

        public Criteria andCommTypeNotEqualTo(String value) {
            addCriterion("comm_type <>", value, "commType");
            return (Criteria) this;
        }

        public Criteria andCommTypeGreaterThan(String value) {
            addCriterion("comm_type >", value, "commType");
            return (Criteria) this;
        }

        public Criteria andCommTypeGreaterThanOrEqualTo(String value) {
            addCriterion("comm_type >=", value, "commType");
            return (Criteria) this;
        }

        public Criteria andCommTypeLessThan(String value) {
            addCriterion("comm_type <", value, "commType");
            return (Criteria) this;
        }

        public Criteria andCommTypeLessThanOrEqualTo(String value) {
            addCriterion("comm_type <=", value, "commType");
            return (Criteria) this;
        }

        public Criteria andCommTypeLike(String value) {
            addCriterion("comm_type like", value, "commType");
            return (Criteria) this;
        }

        public Criteria andCommTypeNotLike(String value) {
            addCriterion("comm_type not like", value, "commType");
            return (Criteria) this;
        }

        public Criteria andCommTypeIn(List<String> values) {
            addCriterion("comm_type in", values, "commType");
            return (Criteria) this;
        }

        public Criteria andCommTypeNotIn(List<String> values) {
            addCriterion("comm_type not in", values, "commType");
            return (Criteria) this;
        }

        public Criteria andCommTypeBetween(String value1, String value2) {
            addCriterion("comm_type between", value1, value2, "commType");
            return (Criteria) this;
        }

        public Criteria andCommTypeNotBetween(String value1, String value2) {
            addCriterion("comm_type not between", value1, value2, "commType");
            return (Criteria) this;
        }

        public Criteria andCommUseridIsNull() {
            addCriterion("comm_userid is null");
            return (Criteria) this;
        }

        public Criteria andCommUseridIsNotNull() {
            addCriterion("comm_userid is not null");
            return (Criteria) this;
        }

        public Criteria andCommUseridEqualTo(Long value) {
            addCriterion("comm_userid =", value, "commUserid");
            return (Criteria) this;
        }

        public Criteria andCommUseridNotEqualTo(Long value) {
            addCriterion("comm_userid <>", value, "commUserid");
            return (Criteria) this;
        }

        public Criteria andCommUseridGreaterThan(Long value) {
            addCriterion("comm_userid >", value, "commUserid");
            return (Criteria) this;
        }

        public Criteria andCommUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("comm_userid >=", value, "commUserid");
            return (Criteria) this;
        }

        public Criteria andCommUseridLessThan(Long value) {
            addCriterion("comm_userid <", value, "commUserid");
            return (Criteria) this;
        }

        public Criteria andCommUseridLessThanOrEqualTo(Long value) {
            addCriterion("comm_userid <=", value, "commUserid");
            return (Criteria) this;
        }

        public Criteria andCommUseridIn(List<Long> values) {
            addCriterion("comm_userid in", values, "commUserid");
            return (Criteria) this;
        }

        public Criteria andCommUseridNotIn(List<Long> values) {
            addCriterion("comm_userid not in", values, "commUserid");
            return (Criteria) this;
        }

        public Criteria andCommUseridBetween(Long value1, Long value2) {
            addCriterion("comm_userid between", value1, value2, "commUserid");
            return (Criteria) this;
        }

        public Criteria andCommUseridNotBetween(Long value1, Long value2) {
            addCriterion("comm_userid not between", value1, value2, "commUserid");
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