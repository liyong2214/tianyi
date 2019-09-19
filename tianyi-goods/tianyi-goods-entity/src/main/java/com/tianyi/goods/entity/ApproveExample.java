package com.tianyi.goods.entity;

import java.util.ArrayList;
import java.util.List;

public class ApproveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApproveExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andApproveGradeIsNull() {
            addCriterion("approve_grade is null");
            return (Criteria) this;
        }

        public Criteria andApproveGradeIsNotNull() {
            addCriterion("approve_grade is not null");
            return (Criteria) this;
        }

        public Criteria andApproveGradeEqualTo(Integer value) {
            addCriterion("approve_grade =", value, "approveGrade");
            return (Criteria) this;
        }

        public Criteria andApproveGradeNotEqualTo(Integer value) {
            addCriterion("approve_grade <>", value, "approveGrade");
            return (Criteria) this;
        }

        public Criteria andApproveGradeGreaterThan(Integer value) {
            addCriterion("approve_grade >", value, "approveGrade");
            return (Criteria) this;
        }

        public Criteria andApproveGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("approve_grade >=", value, "approveGrade");
            return (Criteria) this;
        }

        public Criteria andApproveGradeLessThan(Integer value) {
            addCriterion("approve_grade <", value, "approveGrade");
            return (Criteria) this;
        }

        public Criteria andApproveGradeLessThanOrEqualTo(Integer value) {
            addCriterion("approve_grade <=", value, "approveGrade");
            return (Criteria) this;
        }

        public Criteria andApproveGradeIn(List<Integer> values) {
            addCriterion("approve_grade in", values, "approveGrade");
            return (Criteria) this;
        }

        public Criteria andApproveGradeNotIn(List<Integer> values) {
            addCriterion("approve_grade not in", values, "approveGrade");
            return (Criteria) this;
        }

        public Criteria andApproveGradeBetween(Integer value1, Integer value2) {
            addCriterion("approve_grade between", value1, value2, "approveGrade");
            return (Criteria) this;
        }

        public Criteria andApproveGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("approve_grade not between", value1, value2, "approveGrade");
            return (Criteria) this;
        }

        public Criteria andApproverIdIsNull() {
            addCriterion("approver_id is null");
            return (Criteria) this;
        }

        public Criteria andApproverIdIsNotNull() {
            addCriterion("approver_id is not null");
            return (Criteria) this;
        }

        public Criteria andApproverIdEqualTo(Long value) {
            addCriterion("approver_id =", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdNotEqualTo(Long value) {
            addCriterion("approver_id <>", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdGreaterThan(Long value) {
            addCriterion("approver_id >", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdGreaterThanOrEqualTo(Long value) {
            addCriterion("approver_id >=", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdLessThan(Long value) {
            addCriterion("approver_id <", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdLessThanOrEqualTo(Long value) {
            addCriterion("approver_id <=", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdIn(List<Long> values) {
            addCriterion("approver_id in", values, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdNotIn(List<Long> values) {
            addCriterion("approver_id not in", values, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdBetween(Long value1, Long value2) {
            addCriterion("approver_id between", value1, value2, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdNotBetween(Long value1, Long value2) {
            addCriterion("approver_id not between", value1, value2, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproveResultIsNull() {
            addCriterion("approve_result is null");
            return (Criteria) this;
        }

        public Criteria andApproveResultIsNotNull() {
            addCriterion("approve_result is not null");
            return (Criteria) this;
        }

        public Criteria andApproveResultEqualTo(Integer value) {
            addCriterion("approve_result =", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultNotEqualTo(Integer value) {
            addCriterion("approve_result <>", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultGreaterThan(Integer value) {
            addCriterion("approve_result >", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("approve_result >=", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultLessThan(Integer value) {
            addCriterion("approve_result <", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultLessThanOrEqualTo(Integer value) {
            addCriterion("approve_result <=", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultIn(List<Integer> values) {
            addCriterion("approve_result in", values, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultNotIn(List<Integer> values) {
            addCriterion("approve_result not in", values, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultBetween(Integer value1, Integer value2) {
            addCriterion("approve_result between", value1, value2, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultNotBetween(Integer value1, Integer value2) {
            addCriterion("approve_result not between", value1, value2, "approveResult");
            return (Criteria) this;
        }

        public Criteria andProposeTypeIsNull() {
            addCriterion("propose_type is null");
            return (Criteria) this;
        }

        public Criteria andProposeTypeIsNotNull() {
            addCriterion("propose_type is not null");
            return (Criteria) this;
        }

        public Criteria andProposeTypeEqualTo(Integer value) {
            addCriterion("propose_type =", value, "proposeType");
            return (Criteria) this;
        }

        public Criteria andProposeTypeNotEqualTo(Integer value) {
            addCriterion("propose_type <>", value, "proposeType");
            return (Criteria) this;
        }

        public Criteria andProposeTypeGreaterThan(Integer value) {
            addCriterion("propose_type >", value, "proposeType");
            return (Criteria) this;
        }

        public Criteria andProposeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("propose_type >=", value, "proposeType");
            return (Criteria) this;
        }

        public Criteria andProposeTypeLessThan(Integer value) {
            addCriterion("propose_type <", value, "proposeType");
            return (Criteria) this;
        }

        public Criteria andProposeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("propose_type <=", value, "proposeType");
            return (Criteria) this;
        }

        public Criteria andProposeTypeIn(List<Integer> values) {
            addCriterion("propose_type in", values, "proposeType");
            return (Criteria) this;
        }

        public Criteria andProposeTypeNotIn(List<Integer> values) {
            addCriterion("propose_type not in", values, "proposeType");
            return (Criteria) this;
        }

        public Criteria andProposeTypeBetween(Integer value1, Integer value2) {
            addCriterion("propose_type between", value1, value2, "proposeType");
            return (Criteria) this;
        }

        public Criteria andProposeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("propose_type not between", value1, value2, "proposeType");
            return (Criteria) this;
        }

        public Criteria andProposeIdIsNull() {
            addCriterion("propose_id is null");
            return (Criteria) this;
        }

        public Criteria andProposeIdIsNotNull() {
            addCriterion("propose_id is not null");
            return (Criteria) this;
        }

        public Criteria andProposeIdEqualTo(Integer value) {
            addCriterion("propose_id =", value, "proposeId");
            return (Criteria) this;
        }

        public Criteria andProposeIdNotEqualTo(Integer value) {
            addCriterion("propose_id <>", value, "proposeId");
            return (Criteria) this;
        }

        public Criteria andProposeIdGreaterThan(Integer value) {
            addCriterion("propose_id >", value, "proposeId");
            return (Criteria) this;
        }

        public Criteria andProposeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("propose_id >=", value, "proposeId");
            return (Criteria) this;
        }

        public Criteria andProposeIdLessThan(Integer value) {
            addCriterion("propose_id <", value, "proposeId");
            return (Criteria) this;
        }

        public Criteria andProposeIdLessThanOrEqualTo(Integer value) {
            addCriterion("propose_id <=", value, "proposeId");
            return (Criteria) this;
        }

        public Criteria andProposeIdIn(List<Integer> values) {
            addCriterion("propose_id in", values, "proposeId");
            return (Criteria) this;
        }

        public Criteria andProposeIdNotIn(List<Integer> values) {
            addCriterion("propose_id not in", values, "proposeId");
            return (Criteria) this;
        }

        public Criteria andProposeIdBetween(Integer value1, Integer value2) {
            addCriterion("propose_id between", value1, value2, "proposeId");
            return (Criteria) this;
        }

        public Criteria andProposeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("propose_id not between", value1, value2, "proposeId");
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