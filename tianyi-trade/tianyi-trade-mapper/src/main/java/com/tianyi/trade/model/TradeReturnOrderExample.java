package com.tianyi.trade.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeReturnOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradeReturnOrderExample() {
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

        public Criteria andReturnIdIsNull() {
            addCriterion("return_id is null");
            return (Criteria) this;
        }

        public Criteria andReturnIdIsNotNull() {
            addCriterion("return_id is not null");
            return (Criteria) this;
        }

        public Criteria andReturnIdEqualTo(Long value) {
            addCriterion("return_id =", value, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdNotEqualTo(Long value) {
            addCriterion("return_id <>", value, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdGreaterThan(Long value) {
            addCriterion("return_id >", value, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdGreaterThanOrEqualTo(Long value) {
            addCriterion("return_id >=", value, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdLessThan(Long value) {
            addCriterion("return_id <", value, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdLessThanOrEqualTo(Long value) {
            addCriterion("return_id <=", value, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdIn(List<Long> values) {
            addCriterion("return_id in", values, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdNotIn(List<Long> values) {
            addCriterion("return_id not in", values, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdBetween(Long value1, Long value2) {
            addCriterion("return_id between", value1, value2, "returnId");
            return (Criteria) this;
        }

        public Criteria andReturnIdNotBetween(Long value1, Long value2) {
            addCriterion("return_id not between", value1, value2, "returnId");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNull() {
            addCriterion("applicant is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNotNull() {
            addCriterion("applicant is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEqualTo(String value) {
            addCriterion("applicant =", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotEqualTo(String value) {
            addCriterion("applicant <>", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThan(String value) {
            addCriterion("applicant >", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThanOrEqualTo(String value) {
            addCriterion("applicant >=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThan(String value) {
            addCriterion("applicant <", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThanOrEqualTo(String value) {
            addCriterion("applicant <=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLike(String value) {
            addCriterion("applicant like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotLike(String value) {
            addCriterion("applicant not like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantIn(List<String> values) {
            addCriterion("applicant in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotIn(List<String> values) {
            addCriterion("applicant not in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantBetween(String value1, String value2) {
            addCriterion("applicant between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotBetween(String value1, String value2) {
            addCriterion("applicant not between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantContactIsNull() {
            addCriterion("applicant_contact is null");
            return (Criteria) this;
        }

        public Criteria andApplicantContactIsNotNull() {
            addCriterion("applicant_contact is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantContactEqualTo(String value) {
            addCriterion("applicant_contact =", value, "applicantContact");
            return (Criteria) this;
        }

        public Criteria andApplicantContactNotEqualTo(String value) {
            addCriterion("applicant_contact <>", value, "applicantContact");
            return (Criteria) this;
        }

        public Criteria andApplicantContactGreaterThan(String value) {
            addCriterion("applicant_contact >", value, "applicantContact");
            return (Criteria) this;
        }

        public Criteria andApplicantContactGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_contact >=", value, "applicantContact");
            return (Criteria) this;
        }

        public Criteria andApplicantContactLessThan(String value) {
            addCriterion("applicant_contact <", value, "applicantContact");
            return (Criteria) this;
        }

        public Criteria andApplicantContactLessThanOrEqualTo(String value) {
            addCriterion("applicant_contact <=", value, "applicantContact");
            return (Criteria) this;
        }

        public Criteria andApplicantContactLike(String value) {
            addCriterion("applicant_contact like", value, "applicantContact");
            return (Criteria) this;
        }

        public Criteria andApplicantContactNotLike(String value) {
            addCriterion("applicant_contact not like", value, "applicantContact");
            return (Criteria) this;
        }

        public Criteria andApplicantContactIn(List<String> values) {
            addCriterion("applicant_contact in", values, "applicantContact");
            return (Criteria) this;
        }

        public Criteria andApplicantContactNotIn(List<String> values) {
            addCriterion("applicant_contact not in", values, "applicantContact");
            return (Criteria) this;
        }

        public Criteria andApplicantContactBetween(String value1, String value2) {
            addCriterion("applicant_contact between", value1, value2, "applicantContact");
            return (Criteria) this;
        }

        public Criteria andApplicantContactNotBetween(String value1, String value2) {
            addCriterion("applicant_contact not between", value1, value2, "applicantContact");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailIsNull() {
            addCriterion("applicant_email is null");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailIsNotNull() {
            addCriterion("applicant_email is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailEqualTo(String value) {
            addCriterion("applicant_email =", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailNotEqualTo(String value) {
            addCriterion("applicant_email <>", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailGreaterThan(String value) {
            addCriterion("applicant_email >", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_email >=", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailLessThan(String value) {
            addCriterion("applicant_email <", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailLessThanOrEqualTo(String value) {
            addCriterion("applicant_email <=", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailLike(String value) {
            addCriterion("applicant_email like", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailNotLike(String value) {
            addCriterion("applicant_email not like", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailIn(List<String> values) {
            addCriterion("applicant_email in", values, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailNotIn(List<String> values) {
            addCriterion("applicant_email not in", values, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailBetween(String value1, String value2) {
            addCriterion("applicant_email between", value1, value2, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailNotBetween(String value1, String value2) {
            addCriterion("applicant_email not between", value1, value2, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("apply_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterion("apply_time =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterion("apply_time <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterion("apply_time >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_time >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterion("apply_time <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_time <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            addCriterion("apply_time in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            addCriterion("apply_time not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterion("apply_time between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_time not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andExpressIdIsNull() {
            addCriterion("express_id is null");
            return (Criteria) this;
        }

        public Criteria andExpressIdIsNotNull() {
            addCriterion("express_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpressIdEqualTo(Long value) {
            addCriterion("express_id =", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotEqualTo(Long value) {
            addCriterion("express_id <>", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdGreaterThan(Long value) {
            addCriterion("express_id >", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdGreaterThanOrEqualTo(Long value) {
            addCriterion("express_id >=", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdLessThan(Long value) {
            addCriterion("express_id <", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdLessThanOrEqualTo(Long value) {
            addCriterion("express_id <=", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdIn(List<Long> values) {
            addCriterion("express_id in", values, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotIn(List<Long> values) {
            addCriterion("express_id not in", values, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdBetween(Long value1, Long value2) {
            addCriterion("express_id between", value1, value2, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotBetween(Long value1, Long value2) {
            addCriterion("express_id not between", value1, value2, "expressId");
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

        public Criteria andReceiverAddressIsNull() {
            addCriterion("receiver_address is null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNotNull() {
            addCriterion("receiver_address is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressEqualTo(String value) {
            addCriterion("receiver_address =", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotEqualTo(String value) {
            addCriterion("receiver_address <>", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThan(String value) {
            addCriterion("receiver_address >", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_address >=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThan(String value) {
            addCriterion("receiver_address <", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            addCriterion("receiver_address <=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLike(String value) {
            addCriterion("receiver_address like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotLike(String value) {
            addCriterion("receiver_address not like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIn(List<String> values) {
            addCriterion("receiver_address in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotIn(List<String> values) {
            addCriterion("receiver_address not in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressBetween(String value1, String value2) {
            addCriterion("receiver_address between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotBetween(String value1, String value2) {
            addCriterion("receiver_address not between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andRejectionIsNull() {
            addCriterion("rejection is null");
            return (Criteria) this;
        }

        public Criteria andRejectionIsNotNull() {
            addCriterion("rejection is not null");
            return (Criteria) this;
        }

        public Criteria andRejectionEqualTo(String value) {
            addCriterion("rejection =", value, "rejection");
            return (Criteria) this;
        }

        public Criteria andRejectionNotEqualTo(String value) {
            addCriterion("rejection <>", value, "rejection");
            return (Criteria) this;
        }

        public Criteria andRejectionGreaterThan(String value) {
            addCriterion("rejection >", value, "rejection");
            return (Criteria) this;
        }

        public Criteria andRejectionGreaterThanOrEqualTo(String value) {
            addCriterion("rejection >=", value, "rejection");
            return (Criteria) this;
        }

        public Criteria andRejectionLessThan(String value) {
            addCriterion("rejection <", value, "rejection");
            return (Criteria) this;
        }

        public Criteria andRejectionLessThanOrEqualTo(String value) {
            addCriterion("rejection <=", value, "rejection");
            return (Criteria) this;
        }

        public Criteria andRejectionLike(String value) {
            addCriterion("rejection like", value, "rejection");
            return (Criteria) this;
        }

        public Criteria andRejectionNotLike(String value) {
            addCriterion("rejection not like", value, "rejection");
            return (Criteria) this;
        }

        public Criteria andRejectionIn(List<String> values) {
            addCriterion("rejection in", values, "rejection");
            return (Criteria) this;
        }

        public Criteria andRejectionNotIn(List<String> values) {
            addCriterion("rejection not in", values, "rejection");
            return (Criteria) this;
        }

        public Criteria andRejectionBetween(String value1, String value2) {
            addCriterion("rejection between", value1, value2, "rejection");
            return (Criteria) this;
        }

        public Criteria andRejectionNotBetween(String value1, String value2) {
            addCriterion("rejection not between", value1, value2, "rejection");
            return (Criteria) this;
        }

        public Criteria andRejectTimeIsNull() {
            addCriterion("reject_time is null");
            return (Criteria) this;
        }

        public Criteria andRejectTimeIsNotNull() {
            addCriterion("reject_time is not null");
            return (Criteria) this;
        }

        public Criteria andRejectTimeEqualTo(Date value) {
            addCriterion("reject_time =", value, "rejectTime");
            return (Criteria) this;
        }

        public Criteria andRejectTimeNotEqualTo(Date value) {
            addCriterion("reject_time <>", value, "rejectTime");
            return (Criteria) this;
        }

        public Criteria andRejectTimeGreaterThan(Date value) {
            addCriterion("reject_time >", value, "rejectTime");
            return (Criteria) this;
        }

        public Criteria andRejectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reject_time >=", value, "rejectTime");
            return (Criteria) this;
        }

        public Criteria andRejectTimeLessThan(Date value) {
            addCriterion("reject_time <", value, "rejectTime");
            return (Criteria) this;
        }

        public Criteria andRejectTimeLessThanOrEqualTo(Date value) {
            addCriterion("reject_time <=", value, "rejectTime");
            return (Criteria) this;
        }

        public Criteria andRejectTimeIn(List<Date> values) {
            addCriterion("reject_time in", values, "rejectTime");
            return (Criteria) this;
        }

        public Criteria andRejectTimeNotIn(List<Date> values) {
            addCriterion("reject_time not in", values, "rejectTime");
            return (Criteria) this;
        }

        public Criteria andRejectTimeBetween(Date value1, Date value2) {
            addCriterion("reject_time between", value1, value2, "rejectTime");
            return (Criteria) this;
        }

        public Criteria andRejectTimeNotBetween(Date value1, Date value2) {
            addCriterion("reject_time not between", value1, value2, "rejectTime");
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