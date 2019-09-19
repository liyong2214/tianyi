package com.tianyi.system.entity;

import java.util.ArrayList;
import java.util.List;

public class IpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IpExample() {
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

        public Criteria andIpIdIsNull() {
            addCriterion("ip_id is null");
            return (Criteria) this;
        }

        public Criteria andIpIdIsNotNull() {
            addCriterion("ip_id is not null");
            return (Criteria) this;
        }

        public Criteria andIpIdEqualTo(Integer value) {
            addCriterion("ip_id =", value, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdNotEqualTo(Integer value) {
            addCriterion("ip_id <>", value, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdGreaterThan(Integer value) {
            addCriterion("ip_id >", value, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ip_id >=", value, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdLessThan(Integer value) {
            addCriterion("ip_id <", value, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdLessThanOrEqualTo(Integer value) {
            addCriterion("ip_id <=", value, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdIn(List<Integer> values) {
            addCriterion("ip_id in", values, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdNotIn(List<Integer> values) {
            addCriterion("ip_id not in", values, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdBetween(Integer value1, Integer value2) {
            addCriterion("ip_id between", value1, value2, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ip_id not between", value1, value2, "ipId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andIpScopeIsNull() {
            addCriterion("ip_scope is null");
            return (Criteria) this;
        }

        public Criteria andIpScopeIsNotNull() {
            addCriterion("ip_scope is not null");
            return (Criteria) this;
        }

        public Criteria andIpScopeEqualTo(String value) {
            addCriterion("ip_scope =", value, "ipScope");
            return (Criteria) this;
        }

        public Criteria andIpScopeNotEqualTo(String value) {
            addCriterion("ip_scope <>", value, "ipScope");
            return (Criteria) this;
        }

        public Criteria andIpScopeGreaterThan(String value) {
            addCriterion("ip_scope >", value, "ipScope");
            return (Criteria) this;
        }

        public Criteria andIpScopeGreaterThanOrEqualTo(String value) {
            addCriterion("ip_scope >=", value, "ipScope");
            return (Criteria) this;
        }

        public Criteria andIpScopeLessThan(String value) {
            addCriterion("ip_scope <", value, "ipScope");
            return (Criteria) this;
        }

        public Criteria andIpScopeLessThanOrEqualTo(String value) {
            addCriterion("ip_scope <=", value, "ipScope");
            return (Criteria) this;
        }

        public Criteria andIpScopeLike(String value) {
            addCriterion("ip_scope like", value, "ipScope");
            return (Criteria) this;
        }

        public Criteria andIpScopeNotLike(String value) {
            addCriterion("ip_scope not like", value, "ipScope");
            return (Criteria) this;
        }

        public Criteria andIpScopeIn(List<String> values) {
            addCriterion("ip_scope in", values, "ipScope");
            return (Criteria) this;
        }

        public Criteria andIpScopeNotIn(List<String> values) {
            addCriterion("ip_scope not in", values, "ipScope");
            return (Criteria) this;
        }

        public Criteria andIpScopeBetween(String value1, String value2) {
            addCriterion("ip_scope between", value1, value2, "ipScope");
            return (Criteria) this;
        }

        public Criteria andIpScopeNotBetween(String value1, String value2) {
            addCriterion("ip_scope not between", value1, value2, "ipScope");
            return (Criteria) this;
        }

        public Criteria andIpStateIsNull() {
            addCriterion("ip_state is null");
            return (Criteria) this;
        }

        public Criteria andIpStateIsNotNull() {
            addCriterion("ip_state is not null");
            return (Criteria) this;
        }

        public Criteria andIpStateEqualTo(Integer value) {
            addCriterion("ip_state =", value, "ipState");
            return (Criteria) this;
        }

        public Criteria andIpStateNotEqualTo(Integer value) {
            addCriterion("ip_state <>", value, "ipState");
            return (Criteria) this;
        }

        public Criteria andIpStateGreaterThan(Integer value) {
            addCriterion("ip_state >", value, "ipState");
            return (Criteria) this;
        }

        public Criteria andIpStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("ip_state >=", value, "ipState");
            return (Criteria) this;
        }

        public Criteria andIpStateLessThan(Integer value) {
            addCriterion("ip_state <", value, "ipState");
            return (Criteria) this;
        }

        public Criteria andIpStateLessThanOrEqualTo(Integer value) {
            addCriterion("ip_state <=", value, "ipState");
            return (Criteria) this;
        }

        public Criteria andIpStateIn(List<Integer> values) {
            addCriterion("ip_state in", values, "ipState");
            return (Criteria) this;
        }

        public Criteria andIpStateNotIn(List<Integer> values) {
            addCriterion("ip_state not in", values, "ipState");
            return (Criteria) this;
        }

        public Criteria andIpStateBetween(Integer value1, Integer value2) {
            addCriterion("ip_state between", value1, value2, "ipState");
            return (Criteria) this;
        }

        public Criteria andIpStateNotBetween(Integer value1, Integer value2) {
            addCriterion("ip_state not between", value1, value2, "ipState");
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