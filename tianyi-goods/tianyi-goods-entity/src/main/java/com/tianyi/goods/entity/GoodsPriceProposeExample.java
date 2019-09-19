package com.tianyi.goods.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsPriceProposeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsPriceProposeExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProposerIdIsNull() {
            addCriterion("proposer_id is null");
            return (Criteria) this;
        }

        public Criteria andProposerIdIsNotNull() {
            addCriterion("proposer_id is not null");
            return (Criteria) this;
        }

        public Criteria andProposerIdEqualTo(Long value) {
            addCriterion("proposer_id =", value, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdNotEqualTo(Long value) {
            addCriterion("proposer_id <>", value, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdGreaterThan(Long value) {
            addCriterion("proposer_id >", value, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("proposer_id >=", value, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdLessThan(Long value) {
            addCriterion("proposer_id <", value, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdLessThanOrEqualTo(Long value) {
            addCriterion("proposer_id <=", value, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdIn(List<Long> values) {
            addCriterion("proposer_id in", values, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdNotIn(List<Long> values) {
            addCriterion("proposer_id not in", values, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdBetween(Long value1, Long value2) {
            addCriterion("proposer_id between", value1, value2, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdNotBetween(Long value1, Long value2) {
            addCriterion("proposer_id not between", value1, value2, "proposerId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdIsNull() {
            addCriterion("commodity_id is null");
            return (Criteria) this;
        }

        public Criteria andCommodityIdIsNotNull() {
            addCriterion("commodity_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityIdEqualTo(Long value) {
            addCriterion("commodity_id =", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotEqualTo(Long value) {
            addCriterion("commodity_id <>", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdGreaterThan(Long value) {
            addCriterion("commodity_id >", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("commodity_id >=", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdLessThan(Long value) {
            addCriterion("commodity_id <", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdLessThanOrEqualTo(Long value) {
            addCriterion("commodity_id <=", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdIn(List<Long> values) {
            addCriterion("commodity_id in", values, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotIn(List<Long> values) {
            addCriterion("commodity_id not in", values, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdBetween(Long value1, Long value2) {
            addCriterion("commodity_id between", value1, value2, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotBetween(Long value1, Long value2) {
            addCriterion("commodity_id not between", value1, value2, "commodityId");
            return (Criteria) this;
        }

        public Criteria andTargetAdjustPriceIsNull() {
            addCriterion("target_adjust_price is null");
            return (Criteria) this;
        }

        public Criteria andTargetAdjustPriceIsNotNull() {
            addCriterion("target_adjust_price is not null");
            return (Criteria) this;
        }

        public Criteria andTargetAdjustPriceEqualTo(Integer value) {
            addCriterion("target_adjust_price =", value, "targetAdjustPrice");
            return (Criteria) this;
        }

        public Criteria andTargetAdjustPriceNotEqualTo(Integer value) {
            addCriterion("target_adjust_price <>", value, "targetAdjustPrice");
            return (Criteria) this;
        }

        public Criteria andTargetAdjustPriceGreaterThan(Integer value) {
            addCriterion("target_adjust_price >", value, "targetAdjustPrice");
            return (Criteria) this;
        }

        public Criteria andTargetAdjustPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("target_adjust_price >=", value, "targetAdjustPrice");
            return (Criteria) this;
        }

        public Criteria andTargetAdjustPriceLessThan(Integer value) {
            addCriterion("target_adjust_price <", value, "targetAdjustPrice");
            return (Criteria) this;
        }

        public Criteria andTargetAdjustPriceLessThanOrEqualTo(Integer value) {
            addCriterion("target_adjust_price <=", value, "targetAdjustPrice");
            return (Criteria) this;
        }

        public Criteria andTargetAdjustPriceIn(List<Integer> values) {
            addCriterion("target_adjust_price in", values, "targetAdjustPrice");
            return (Criteria) this;
        }

        public Criteria andTargetAdjustPriceNotIn(List<Integer> values) {
            addCriterion("target_adjust_price not in", values, "targetAdjustPrice");
            return (Criteria) this;
        }

        public Criteria andTargetAdjustPriceBetween(Integer value1, Integer value2) {
            addCriterion("target_adjust_price between", value1, value2, "targetAdjustPrice");
            return (Criteria) this;
        }

        public Criteria andTargetAdjustPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("target_adjust_price not between", value1, value2, "targetAdjustPrice");
            return (Criteria) this;
        }

        public Criteria andPriceModificationIsNull() {
            addCriterion("price_modification is null");
            return (Criteria) this;
        }

        public Criteria andPriceModificationIsNotNull() {
            addCriterion("price_modification is not null");
            return (Criteria) this;
        }

        public Criteria andPriceModificationEqualTo(Float value) {
            addCriterion("price_modification =", value, "priceModification");
            return (Criteria) this;
        }

        public Criteria andPriceModificationNotEqualTo(Float value) {
            addCriterion("price_modification <>", value, "priceModification");
            return (Criteria) this;
        }

        public Criteria andPriceModificationGreaterThan(Float value) {
            addCriterion("price_modification >", value, "priceModification");
            return (Criteria) this;
        }

        public Criteria andPriceModificationGreaterThanOrEqualTo(Float value) {
            addCriterion("price_modification >=", value, "priceModification");
            return (Criteria) this;
        }

        public Criteria andPriceModificationLessThan(Float value) {
            addCriterion("price_modification <", value, "priceModification");
            return (Criteria) this;
        }

        public Criteria andPriceModificationLessThanOrEqualTo(Float value) {
            addCriterion("price_modification <=", value, "priceModification");
            return (Criteria) this;
        }

        public Criteria andPriceModificationIn(List<Float> values) {
            addCriterion("price_modification in", values, "priceModification");
            return (Criteria) this;
        }

        public Criteria andPriceModificationNotIn(List<Float> values) {
            addCriterion("price_modification not in", values, "priceModification");
            return (Criteria) this;
        }

        public Criteria andPriceModificationBetween(Float value1, Float value2) {
            addCriterion("price_modification between", value1, value2, "priceModification");
            return (Criteria) this;
        }

        public Criteria andPriceModificationNotBetween(Float value1, Float value2) {
            addCriterion("price_modification not between", value1, value2, "priceModification");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andApproveStageIsNull() {
            addCriterion("approve_stage is null");
            return (Criteria) this;
        }

        public Criteria andApproveStageIsNotNull() {
            addCriterion("approve_stage is not null");
            return (Criteria) this;
        }

        public Criteria andApproveStageEqualTo(Integer value) {
            addCriterion("approve_stage =", value, "approveStage");
            return (Criteria) this;
        }

        public Criteria andApproveStageNotEqualTo(Integer value) {
            addCriterion("approve_stage <>", value, "approveStage");
            return (Criteria) this;
        }

        public Criteria andApproveStageGreaterThan(Integer value) {
            addCriterion("approve_stage >", value, "approveStage");
            return (Criteria) this;
        }

        public Criteria andApproveStageGreaterThanOrEqualTo(Integer value) {
            addCriterion("approve_stage >=", value, "approveStage");
            return (Criteria) this;
        }

        public Criteria andApproveStageLessThan(Integer value) {
            addCriterion("approve_stage <", value, "approveStage");
            return (Criteria) this;
        }

        public Criteria andApproveStageLessThanOrEqualTo(Integer value) {
            addCriterion("approve_stage <=", value, "approveStage");
            return (Criteria) this;
        }

        public Criteria andApproveStageIn(List<Integer> values) {
            addCriterion("approve_stage in", values, "approveStage");
            return (Criteria) this;
        }

        public Criteria andApproveStageNotIn(List<Integer> values) {
            addCriterion("approve_stage not in", values, "approveStage");
            return (Criteria) this;
        }

        public Criteria andApproveStageBetween(Integer value1, Integer value2) {
            addCriterion("approve_stage between", value1, value2, "approveStage");
            return (Criteria) this;
        }

        public Criteria andApproveStageNotBetween(Integer value1, Integer value2) {
            addCriterion("approve_stage not between", value1, value2, "approveStage");
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

        public Criteria andApproveResultEqualTo(Boolean value) {
            addCriterion("approve_result =", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultNotEqualTo(Boolean value) {
            addCriterion("approve_result <>", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultGreaterThan(Boolean value) {
            addCriterion("approve_result >", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("approve_result >=", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultLessThan(Boolean value) {
            addCriterion("approve_result <", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultLessThanOrEqualTo(Boolean value) {
            addCriterion("approve_result <=", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultIn(List<Boolean> values) {
            addCriterion("approve_result in", values, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultNotIn(List<Boolean> values) {
            addCriterion("approve_result not in", values, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultBetween(Boolean value1, Boolean value2) {
            addCriterion("approve_result between", value1, value2, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("approve_result not between", value1, value2, "approveResult");
            return (Criteria) this;
        }

        public Criteria andProposeTimeIsNull() {
            addCriterion("propose_time is null");
            return (Criteria) this;
        }

        public Criteria andProposeTimeIsNotNull() {
            addCriterion("propose_time is not null");
            return (Criteria) this;
        }

        public Criteria andProposeTimeEqualTo(Date value) {
            addCriterion("propose_time =", value, "proposeTime");
            return (Criteria) this;
        }

        public Criteria andProposeTimeNotEqualTo(Date value) {
            addCriterion("propose_time <>", value, "proposeTime");
            return (Criteria) this;
        }

        public Criteria andProposeTimeGreaterThan(Date value) {
            addCriterion("propose_time >", value, "proposeTime");
            return (Criteria) this;
        }

        public Criteria andProposeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("propose_time >=", value, "proposeTime");
            return (Criteria) this;
        }

        public Criteria andProposeTimeLessThan(Date value) {
            addCriterion("propose_time <", value, "proposeTime");
            return (Criteria) this;
        }

        public Criteria andProposeTimeLessThanOrEqualTo(Date value) {
            addCriterion("propose_time <=", value, "proposeTime");
            return (Criteria) this;
        }

        public Criteria andProposeTimeIn(List<Date> values) {
            addCriterion("propose_time in", values, "proposeTime");
            return (Criteria) this;
        }

        public Criteria andProposeTimeNotIn(List<Date> values) {
            addCriterion("propose_time not in", values, "proposeTime");
            return (Criteria) this;
        }

        public Criteria andProposeTimeBetween(Date value1, Date value2) {
            addCriterion("propose_time between", value1, value2, "proposeTime");
            return (Criteria) this;
        }

        public Criteria andProposeTimeNotBetween(Date value1, Date value2) {
            addCriterion("propose_time not between", value1, value2, "proposeTime");
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