package com.main.api.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingCarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShoppingCarExample() {
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

        public Criteria andCarIdIsNull() {
            addCriterion("car_Id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_Id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Long value) {
            addCriterion("car_Id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Long value) {
            addCriterion("car_Id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Long value) {
            addCriterion("car_Id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Long value) {
            addCriterion("car_Id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Long value) {
            addCriterion("car_Id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Long value) {
            addCriterion("car_Id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Long> values) {
            addCriterion("car_Id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Long> values) {
            addCriterion("car_Id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Long value1, Long value2) {
            addCriterion("car_Id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Long value1, Long value2) {
            addCriterion("car_Id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarUserIdIsNull() {
            addCriterion("car_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCarUserIdIsNotNull() {
            addCriterion("car_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarUserIdEqualTo(Long value) {
            addCriterion("car_user_id =", value, "carUserId");
            return (Criteria) this;
        }

        public Criteria andCarUserIdNotEqualTo(Long value) {
            addCriterion("car_user_id <>", value, "carUserId");
            return (Criteria) this;
        }

        public Criteria andCarUserIdGreaterThan(Long value) {
            addCriterion("car_user_id >", value, "carUserId");
            return (Criteria) this;
        }

        public Criteria andCarUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("car_user_id >=", value, "carUserId");
            return (Criteria) this;
        }

        public Criteria andCarUserIdLessThan(Long value) {
            addCriterion("car_user_id <", value, "carUserId");
            return (Criteria) this;
        }

        public Criteria andCarUserIdLessThanOrEqualTo(Long value) {
            addCriterion("car_user_id <=", value, "carUserId");
            return (Criteria) this;
        }

        public Criteria andCarUserIdIn(List<Long> values) {
            addCriterion("car_user_id in", values, "carUserId");
            return (Criteria) this;
        }

        public Criteria andCarUserIdNotIn(List<Long> values) {
            addCriterion("car_user_id not in", values, "carUserId");
            return (Criteria) this;
        }

        public Criteria andCarUserIdBetween(Long value1, Long value2) {
            addCriterion("car_user_id between", value1, value2, "carUserId");
            return (Criteria) this;
        }

        public Criteria andCarUserIdNotBetween(Long value1, Long value2) {
            addCriterion("car_user_id not between", value1, value2, "carUserId");
            return (Criteria) this;
        }

        public Criteria andCarCommIdIsNull() {
            addCriterion("car_comm_id is null");
            return (Criteria) this;
        }

        public Criteria andCarCommIdIsNotNull() {
            addCriterion("car_comm_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarCommIdEqualTo(Long value) {
            addCriterion("car_comm_id =", value, "carCommId");
            return (Criteria) this;
        }

        public Criteria andCarCommIdNotEqualTo(Long value) {
            addCriterion("car_comm_id <>", value, "carCommId");
            return (Criteria) this;
        }

        public Criteria andCarCommIdGreaterThan(Long value) {
            addCriterion("car_comm_id >", value, "carCommId");
            return (Criteria) this;
        }

        public Criteria andCarCommIdGreaterThanOrEqualTo(Long value) {
            addCriterion("car_comm_id >=", value, "carCommId");
            return (Criteria) this;
        }

        public Criteria andCarCommIdLessThan(Long value) {
            addCriterion("car_comm_id <", value, "carCommId");
            return (Criteria) this;
        }

        public Criteria andCarCommIdLessThanOrEqualTo(Long value) {
            addCriterion("car_comm_id <=", value, "carCommId");
            return (Criteria) this;
        }

        public Criteria andCarCommIdIn(List<Long> values) {
            addCriterion("car_comm_id in", values, "carCommId");
            return (Criteria) this;
        }

        public Criteria andCarCommIdNotIn(List<Long> values) {
            addCriterion("car_comm_id not in", values, "carCommId");
            return (Criteria) this;
        }

        public Criteria andCarCommIdBetween(Long value1, Long value2) {
            addCriterion("car_comm_id between", value1, value2, "carCommId");
            return (Criteria) this;
        }

        public Criteria andCarCommIdNotBetween(Long value1, Long value2) {
            addCriterion("car_comm_id not between", value1, value2, "carCommId");
            return (Criteria) this;
        }

        public Criteria andCarCommNumberIsNull() {
            addCriterion("car_comm_number is null");
            return (Criteria) this;
        }

        public Criteria andCarCommNumberIsNotNull() {
            addCriterion("car_comm_number is not null");
            return (Criteria) this;
        }

        public Criteria andCarCommNumberEqualTo(Integer value) {
            addCriterion("car_comm_number =", value, "carCommNumber");
            return (Criteria) this;
        }

        public Criteria andCarCommNumberNotEqualTo(Integer value) {
            addCriterion("car_comm_number <>", value, "carCommNumber");
            return (Criteria) this;
        }

        public Criteria andCarCommNumberGreaterThan(Integer value) {
            addCriterion("car_comm_number >", value, "carCommNumber");
            return (Criteria) this;
        }

        public Criteria andCarCommNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_comm_number >=", value, "carCommNumber");
            return (Criteria) this;
        }

        public Criteria andCarCommNumberLessThan(Integer value) {
            addCriterion("car_comm_number <", value, "carCommNumber");
            return (Criteria) this;
        }

        public Criteria andCarCommNumberLessThanOrEqualTo(Integer value) {
            addCriterion("car_comm_number <=", value, "carCommNumber");
            return (Criteria) this;
        }

        public Criteria andCarCommNumberIn(List<Integer> values) {
            addCriterion("car_comm_number in", values, "carCommNumber");
            return (Criteria) this;
        }

        public Criteria andCarCommNumberNotIn(List<Integer> values) {
            addCriterion("car_comm_number not in", values, "carCommNumber");
            return (Criteria) this;
        }

        public Criteria andCarCommNumberBetween(Integer value1, Integer value2) {
            addCriterion("car_comm_number between", value1, value2, "carCommNumber");
            return (Criteria) this;
        }

        public Criteria andCarCommNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("car_comm_number not between", value1, value2, "carCommNumber");
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