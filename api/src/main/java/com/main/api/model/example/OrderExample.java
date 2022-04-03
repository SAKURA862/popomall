package com.main.api.model.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdIsNull() {
            addCriterion("order_seller_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdIsNotNull() {
            addCriterion("order_seller_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdEqualTo(Long value) {
            addCriterion("order_seller_id =", value, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdNotEqualTo(Long value) {
            addCriterion("order_seller_id <>", value, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdGreaterThan(Long value) {
            addCriterion("order_seller_id >", value, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_seller_id >=", value, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdLessThan(Long value) {
            addCriterion("order_seller_id <", value, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdLessThanOrEqualTo(Long value) {
            addCriterion("order_seller_id <=", value, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdIn(List<Long> values) {
            addCriterion("order_seller_id in", values, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdNotIn(List<Long> values) {
            addCriterion("order_seller_id not in", values, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdBetween(Long value1, Long value2) {
            addCriterion("order_seller_id between", value1, value2, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdNotBetween(Long value1, Long value2) {
            addCriterion("order_seller_id not between", value1, value2, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdIsNull() {
            addCriterion("order_buyer_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdIsNotNull() {
            addCriterion("order_buyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdEqualTo(Long value) {
            addCriterion("order_buyer_id =", value, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdNotEqualTo(Long value) {
            addCriterion("order_buyer_id <>", value, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdGreaterThan(Long value) {
            addCriterion("order_buyer_id >", value, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_buyer_id >=", value, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdLessThan(Long value) {
            addCriterion("order_buyer_id <", value, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdLessThanOrEqualTo(Long value) {
            addCriterion("order_buyer_id <=", value, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdIn(List<Long> values) {
            addCriterion("order_buyer_id in", values, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdNotIn(List<Long> values) {
            addCriterion("order_buyer_id not in", values, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdBetween(Long value1, Long value2) {
            addCriterion("order_buyer_id between", value1, value2, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdNotBetween(Long value1, Long value2) {
            addCriterion("order_buyer_id not between", value1, value2, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderOffCountIsNull() {
            addCriterion("order_off_count is null");
            return (Criteria) this;
        }

        public Criteria andOrderOffCountIsNotNull() {
            addCriterion("order_off_count is not null");
            return (Criteria) this;
        }

        public Criteria andOrderOffCountEqualTo(BigDecimal value) {
            addCriterion("order_off_count =", value, "orderOffCount");
            return (Criteria) this;
        }

        public Criteria andOrderOffCountNotEqualTo(BigDecimal value) {
            addCriterion("order_off_count <>", value, "orderOffCount");
            return (Criteria) this;
        }

        public Criteria andOrderOffCountGreaterThan(BigDecimal value) {
            addCriterion("order_off_count >", value, "orderOffCount");
            return (Criteria) this;
        }

        public Criteria andOrderOffCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_off_count >=", value, "orderOffCount");
            return (Criteria) this;
        }

        public Criteria andOrderOffCountLessThan(BigDecimal value) {
            addCriterion("order_off_count <", value, "orderOffCount");
            return (Criteria) this;
        }

        public Criteria andOrderOffCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_off_count <=", value, "orderOffCount");
            return (Criteria) this;
        }

        public Criteria andOrderOffCountIn(List<BigDecimal> values) {
            addCriterion("order_off_count in", values, "orderOffCount");
            return (Criteria) this;
        }

        public Criteria andOrderOffCountNotIn(List<BigDecimal> values) {
            addCriterion("order_off_count not in", values, "orderOffCount");
            return (Criteria) this;
        }

        public Criteria andOrderOffCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_off_count between", value1, value2, "orderOffCount");
            return (Criteria) this;
        }

        public Criteria andOrderOffCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_off_count not between", value1, value2, "orderOffCount");
            return (Criteria) this;
        }

        public Criteria andOrderTotleIsNull() {
            addCriterion("order_totle is null");
            return (Criteria) this;
        }

        public Criteria andOrderTotleIsNotNull() {
            addCriterion("order_totle is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTotleEqualTo(BigDecimal value) {
            addCriterion("order_totle =", value, "orderTotle");
            return (Criteria) this;
        }

        public Criteria andOrderTotleNotEqualTo(BigDecimal value) {
            addCriterion("order_totle <>", value, "orderTotle");
            return (Criteria) this;
        }

        public Criteria andOrderTotleGreaterThan(BigDecimal value) {
            addCriterion("order_totle >", value, "orderTotle");
            return (Criteria) this;
        }

        public Criteria andOrderTotleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_totle >=", value, "orderTotle");
            return (Criteria) this;
        }

        public Criteria andOrderTotleLessThan(BigDecimal value) {
            addCriterion("order_totle <", value, "orderTotle");
            return (Criteria) this;
        }

        public Criteria andOrderTotleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_totle <=", value, "orderTotle");
            return (Criteria) this;
        }

        public Criteria andOrderTotleIn(List<BigDecimal> values) {
            addCriterion("order_totle in", values, "orderTotle");
            return (Criteria) this;
        }

        public Criteria andOrderTotleNotIn(List<BigDecimal> values) {
            addCriterion("order_totle not in", values, "orderTotle");
            return (Criteria) this;
        }

        public Criteria andOrderTotleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_totle between", value1, value2, "orderTotle");
            return (Criteria) this;
        }

        public Criteria andOrderTotleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_totle not between", value1, value2, "orderTotle");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityIdIsNull() {
            addCriterion("order_commodity_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityIdIsNotNull() {
            addCriterion("order_commodity_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityIdEqualTo(Long value) {
            addCriterion("order_commodity_id =", value, "orderCommodityId");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityIdNotEqualTo(Long value) {
            addCriterion("order_commodity_id <>", value, "orderCommodityId");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityIdGreaterThan(Long value) {
            addCriterion("order_commodity_id >", value, "orderCommodityId");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_commodity_id >=", value, "orderCommodityId");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityIdLessThan(Long value) {
            addCriterion("order_commodity_id <", value, "orderCommodityId");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityIdLessThanOrEqualTo(Long value) {
            addCriterion("order_commodity_id <=", value, "orderCommodityId");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityIdIn(List<Long> values) {
            addCriterion("order_commodity_id in", values, "orderCommodityId");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityIdNotIn(List<Long> values) {
            addCriterion("order_commodity_id not in", values, "orderCommodityId");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityIdBetween(Long value1, Long value2) {
            addCriterion("order_commodity_id between", value1, value2, "orderCommodityId");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityIdNotBetween(Long value1, Long value2) {
            addCriterion("order_commodity_id not between", value1, value2, "orderCommodityId");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityCountIsNull() {
            addCriterion("order_commodity_count is null");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityCountIsNotNull() {
            addCriterion("order_commodity_count is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityCountEqualTo(Integer value) {
            addCriterion("order_commodity_count =", value, "orderCommodityCount");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityCountNotEqualTo(Integer value) {
            addCriterion("order_commodity_count <>", value, "orderCommodityCount");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityCountGreaterThan(Integer value) {
            addCriterion("order_commodity_count >", value, "orderCommodityCount");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_commodity_count >=", value, "orderCommodityCount");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityCountLessThan(Integer value) {
            addCriterion("order_commodity_count <", value, "orderCommodityCount");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityCountLessThanOrEqualTo(Integer value) {
            addCriterion("order_commodity_count <=", value, "orderCommodityCount");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityCountIn(List<Integer> values) {
            addCriterion("order_commodity_count in", values, "orderCommodityCount");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityCountNotIn(List<Integer> values) {
            addCriterion("order_commodity_count not in", values, "orderCommodityCount");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityCountBetween(Integer value1, Integer value2) {
            addCriterion("order_commodity_count between", value1, value2, "orderCommodityCount");
            return (Criteria) this;
        }

        public Criteria andOrderCommodityCountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_commodity_count not between", value1, value2, "orderCommodityCount");
            return (Criteria) this;
        }

        public Criteria andOrderAddressIsNull() {
            addCriterion("order_address is null");
            return (Criteria) this;
        }

        public Criteria andOrderAddressIsNotNull() {
            addCriterion("order_address is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAddressEqualTo(String value) {
            addCriterion("order_address =", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotEqualTo(String value) {
            addCriterion("order_address <>", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressGreaterThan(String value) {
            addCriterion("order_address >", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressGreaterThanOrEqualTo(String value) {
            addCriterion("order_address >=", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressLessThan(String value) {
            addCriterion("order_address <", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressLessThanOrEqualTo(String value) {
            addCriterion("order_address <=", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressLike(String value) {
            addCriterion("order_address like", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotLike(String value) {
            addCriterion("order_address not like", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressIn(List<String> values) {
            addCriterion("order_address in", values, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotIn(List<String> values) {
            addCriterion("order_address not in", values, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressBetween(String value1, String value2) {
            addCriterion("order_address between", value1, value2, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotBetween(String value1, String value2) {
            addCriterion("order_address not between", value1, value2, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(Byte value) {
            addCriterion("order_state =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(Byte value) {
            addCriterion("order_state <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(Byte value) {
            addCriterion("order_state >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_state >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(Byte value) {
            addCriterion("order_state <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(Byte value) {
            addCriterion("order_state <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<Byte> values) {
            addCriterion("order_state in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<Byte> values) {
            addCriterion("order_state not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(Byte value1, Byte value2) {
            addCriterion("order_state between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(Byte value1, Byte value2) {
            addCriterion("order_state not between", value1, value2, "orderState");
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