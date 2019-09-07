package com.tianyi.trade.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeOrderinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradeOrderinfoExample() {
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

        public Criteria andOrderinfoIdIsNull() {
            addCriterion("orderinfo_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdIsNotNull() {
            addCriterion("orderinfo_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdEqualTo(Long value) {
            addCriterion("orderinfo_id =", value, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdNotEqualTo(Long value) {
            addCriterion("orderinfo_id <>", value, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdGreaterThan(Long value) {
            addCriterion("orderinfo_id >", value, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("orderinfo_id >=", value, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdLessThan(Long value) {
            addCriterion("orderinfo_id <", value, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdLessThanOrEqualTo(Long value) {
            addCriterion("orderinfo_id <=", value, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdIn(List<Long> values) {
            addCriterion("orderinfo_id in", values, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdNotIn(List<Long> values) {
            addCriterion("orderinfo_id not in", values, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdBetween(Long value1, Long value2) {
            addCriterion("orderinfo_id between", value1, value2, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdNotBetween(Long value1, Long value2) {
            addCriterion("orderinfo_id not between", value1, value2, "orderinfoId");
            return (Criteria) this;
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

        public Criteria andGoodIdIsNull() {
            addCriterion("good_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNotNull() {
            addCriterion("good_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodIdEqualTo(Long value) {
            addCriterion("good_id =", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotEqualTo(Long value) {
            addCriterion("good_id <>", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThan(Long value) {
            addCriterion("good_id >", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThanOrEqualTo(Long value) {
            addCriterion("good_id >=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThan(Long value) {
            addCriterion("good_id <", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThanOrEqualTo(Long value) {
            addCriterion("good_id <=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdIn(List<Long> values) {
            addCriterion("good_id in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotIn(List<Long> values) {
            addCriterion("good_id not in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdBetween(Long value1, Long value2) {
            addCriterion("good_id between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotBetween(Long value1, Long value2) {
            addCriterion("good_id not between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodAmountIsNull() {
            addCriterion("good_amount is null");
            return (Criteria) this;
        }

        public Criteria andGoodAmountIsNotNull() {
            addCriterion("good_amount is not null");
            return (Criteria) this;
        }

        public Criteria andGoodAmountEqualTo(Integer value) {
            addCriterion("good_amount =", value, "goodAmount");
            return (Criteria) this;
        }

        public Criteria andGoodAmountNotEqualTo(Integer value) {
            addCriterion("good_amount <>", value, "goodAmount");
            return (Criteria) this;
        }

        public Criteria andGoodAmountGreaterThan(Integer value) {
            addCriterion("good_amount >", value, "goodAmount");
            return (Criteria) this;
        }

        public Criteria andGoodAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("good_amount >=", value, "goodAmount");
            return (Criteria) this;
        }

        public Criteria andGoodAmountLessThan(Integer value) {
            addCriterion("good_amount <", value, "goodAmount");
            return (Criteria) this;
        }

        public Criteria andGoodAmountLessThanOrEqualTo(Integer value) {
            addCriterion("good_amount <=", value, "goodAmount");
            return (Criteria) this;
        }

        public Criteria andGoodAmountIn(List<Integer> values) {
            addCriterion("good_amount in", values, "goodAmount");
            return (Criteria) this;
        }

        public Criteria andGoodAmountNotIn(List<Integer> values) {
            addCriterion("good_amount not in", values, "goodAmount");
            return (Criteria) this;
        }

        public Criteria andGoodAmountBetween(Integer value1, Integer value2) {
            addCriterion("good_amount between", value1, value2, "goodAmount");
            return (Criteria) this;
        }

        public Criteria andGoodAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("good_amount not between", value1, value2, "goodAmount");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     */
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