package com.main.api.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddressExample() {
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

        public Criteria andAddrIdIsNull() {
            addCriterion("addr_id is null");
            return (Criteria) this;
        }

        public Criteria andAddrIdIsNotNull() {
            addCriterion("addr_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddrIdEqualTo(Long value) {
            addCriterion("addr_id =", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdNotEqualTo(Long value) {
            addCriterion("addr_id <>", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdGreaterThan(Long value) {
            addCriterion("addr_id >", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdGreaterThanOrEqualTo(Long value) {
            addCriterion("addr_id >=", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdLessThan(Long value) {
            addCriterion("addr_id <", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdLessThanOrEqualTo(Long value) {
            addCriterion("addr_id <=", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdIn(List<Long> values) {
            addCriterion("addr_id in", values, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdNotIn(List<Long> values) {
            addCriterion("addr_id not in", values, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdBetween(Long value1, Long value2) {
            addCriterion("addr_id between", value1, value2, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdNotBetween(Long value1, Long value2) {
            addCriterion("addr_id not between", value1, value2, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrUserIdIsNull() {
            addCriterion("addr_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAddrUserIdIsNotNull() {
            addCriterion("addr_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddrUserIdEqualTo(Long value) {
            addCriterion("addr_user_id =", value, "addrUserId");
            return (Criteria) this;
        }

        public Criteria andAddrUserIdNotEqualTo(Long value) {
            addCriterion("addr_user_id <>", value, "addrUserId");
            return (Criteria) this;
        }

        public Criteria andAddrUserIdGreaterThan(Long value) {
            addCriterion("addr_user_id >", value, "addrUserId");
            return (Criteria) this;
        }

        public Criteria andAddrUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("addr_user_id >=", value, "addrUserId");
            return (Criteria) this;
        }

        public Criteria andAddrUserIdLessThan(Long value) {
            addCriterion("addr_user_id <", value, "addrUserId");
            return (Criteria) this;
        }

        public Criteria andAddrUserIdLessThanOrEqualTo(Long value) {
            addCriterion("addr_user_id <=", value, "addrUserId");
            return (Criteria) this;
        }

        public Criteria andAddrUserIdIn(List<Long> values) {
            addCriterion("addr_user_id in", values, "addrUserId");
            return (Criteria) this;
        }

        public Criteria andAddrUserIdNotIn(List<Long> values) {
            addCriterion("addr_user_id not in", values, "addrUserId");
            return (Criteria) this;
        }

        public Criteria andAddrUserIdBetween(Long value1, Long value2) {
            addCriterion("addr_user_id between", value1, value2, "addrUserId");
            return (Criteria) this;
        }

        public Criteria andAddrUserIdNotBetween(Long value1, Long value2) {
            addCriterion("addr_user_id not between", value1, value2, "addrUserId");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIsNull() {
            addCriterion("addr_info is null");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIsNotNull() {
            addCriterion("addr_info is not null");
            return (Criteria) this;
        }

        public Criteria andAddrInfoEqualTo(String value) {
            addCriterion("addr_info =", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoNotEqualTo(String value) {
            addCriterion("addr_info <>", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoGreaterThan(String value) {
            addCriterion("addr_info >", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoGreaterThanOrEqualTo(String value) {
            addCriterion("addr_info >=", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoLessThan(String value) {
            addCriterion("addr_info <", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoLessThanOrEqualTo(String value) {
            addCriterion("addr_info <=", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoLike(String value) {
            addCriterion("addr_info like", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoNotLike(String value) {
            addCriterion("addr_info not like", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIn(List<String> values) {
            addCriterion("addr_info in", values, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoNotIn(List<String> values) {
            addCriterion("addr_info not in", values, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoBetween(String value1, String value2) {
            addCriterion("addr_info between", value1, value2, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoNotBetween(String value1, String value2) {
            addCriterion("addr_info not between", value1, value2, "addrInfo");
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