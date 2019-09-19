package com.tianyi.goods.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommodityPromotionProposeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommodityPromotionProposeExample() {
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

        public Criteria andGoodsPurchasePriceIsNull() {
            addCriterion("goods_purchase_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPurchasePriceIsNotNull() {
            addCriterion("goods_purchase_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPurchasePriceEqualTo(BigDecimal value) {
            addCriterion("goods_purchase_price =", value, "goodsPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPurchasePriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_purchase_price <>", value, "goodsPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPurchasePriceGreaterThan(BigDecimal value) {
            addCriterion("goods_purchase_price >", value, "goodsPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPurchasePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_purchase_price >=", value, "goodsPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPurchasePriceLessThan(BigDecimal value) {
            addCriterion("goods_purchase_price <", value, "goodsPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPurchasePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_purchase_price <=", value, "goodsPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPurchasePriceIn(List<BigDecimal> values) {
            addCriterion("goods_purchase_price in", values, "goodsPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPurchasePriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_purchase_price not in", values, "goodsPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPurchasePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_purchase_price between", value1, value2, "goodsPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPurchasePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_purchase_price not between", value1, value2, "goodsPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseDistributeIsNull() {
            addCriterion("goods_warehouse_distribute is null");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseDistributeIsNotNull() {
            addCriterion("goods_warehouse_distribute is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseDistributeEqualTo(String value) {
            addCriterion("goods_warehouse_distribute =", value, "goodsWarehouseDistribute");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseDistributeNotEqualTo(String value) {
            addCriterion("goods_warehouse_distribute <>", value, "goodsWarehouseDistribute");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseDistributeGreaterThan(String value) {
            addCriterion("goods_warehouse_distribute >", value, "goodsWarehouseDistribute");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseDistributeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_warehouse_distribute >=", value, "goodsWarehouseDistribute");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseDistributeLessThan(String value) {
            addCriterion("goods_warehouse_distribute <", value, "goodsWarehouseDistribute");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseDistributeLessThanOrEqualTo(String value) {
            addCriterion("goods_warehouse_distribute <=", value, "goodsWarehouseDistribute");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseDistributeLike(String value) {
            addCriterion("goods_warehouse_distribute like", value, "goodsWarehouseDistribute");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseDistributeNotLike(String value) {
            addCriterion("goods_warehouse_distribute not like", value, "goodsWarehouseDistribute");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseDistributeIn(List<String> values) {
            addCriterion("goods_warehouse_distribute in", values, "goodsWarehouseDistribute");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseDistributeNotIn(List<String> values) {
            addCriterion("goods_warehouse_distribute not in", values, "goodsWarehouseDistribute");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseDistributeBetween(String value1, String value2) {
            addCriterion("goods_warehouse_distribute between", value1, value2, "goodsWarehouseDistribute");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseDistributeNotBetween(String value1, String value2) {
            addCriterion("goods_warehouse_distribute not between", value1, value2, "goodsWarehouseDistribute");
            return (Criteria) this;
        }

        public Criteria andRushShoppingStartTimeIsNull() {
            addCriterion("rush_shopping_start_time is null");
            return (Criteria) this;
        }

        public Criteria andRushShoppingStartTimeIsNotNull() {
            addCriterion("rush_shopping_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andRushShoppingStartTimeEqualTo(Date value) {
            addCriterion("rush_shopping_start_time =", value, "rushShoppingStartTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingStartTimeNotEqualTo(Date value) {
            addCriterion("rush_shopping_start_time <>", value, "rushShoppingStartTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingStartTimeGreaterThan(Date value) {
            addCriterion("rush_shopping_start_time >", value, "rushShoppingStartTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rush_shopping_start_time >=", value, "rushShoppingStartTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingStartTimeLessThan(Date value) {
            addCriterion("rush_shopping_start_time <", value, "rushShoppingStartTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("rush_shopping_start_time <=", value, "rushShoppingStartTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingStartTimeIn(List<Date> values) {
            addCriterion("rush_shopping_start_time in", values, "rushShoppingStartTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingStartTimeNotIn(List<Date> values) {
            addCriterion("rush_shopping_start_time not in", values, "rushShoppingStartTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingStartTimeBetween(Date value1, Date value2) {
            addCriterion("rush_shopping_start_time between", value1, value2, "rushShoppingStartTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("rush_shopping_start_time not between", value1, value2, "rushShoppingStartTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingEndTimeIsNull() {
            addCriterion("rush_shopping_end_time is null");
            return (Criteria) this;
        }

        public Criteria andRushShoppingEndTimeIsNotNull() {
            addCriterion("rush_shopping_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andRushShoppingEndTimeEqualTo(Date value) {
            addCriterion("rush_shopping_end_time =", value, "rushShoppingEndTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingEndTimeNotEqualTo(Date value) {
            addCriterion("rush_shopping_end_time <>", value, "rushShoppingEndTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingEndTimeGreaterThan(Date value) {
            addCriterion("rush_shopping_end_time >", value, "rushShoppingEndTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rush_shopping_end_time >=", value, "rushShoppingEndTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingEndTimeLessThan(Date value) {
            addCriterion("rush_shopping_end_time <", value, "rushShoppingEndTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("rush_shopping_end_time <=", value, "rushShoppingEndTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingEndTimeIn(List<Date> values) {
            addCriterion("rush_shopping_end_time in", values, "rushShoppingEndTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingEndTimeNotIn(List<Date> values) {
            addCriterion("rush_shopping_end_time not in", values, "rushShoppingEndTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingEndTimeBetween(Date value1, Date value2) {
            addCriterion("rush_shopping_end_time between", value1, value2, "rushShoppingEndTime");
            return (Criteria) this;
        }

        public Criteria andRushShoppingEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("rush_shopping_end_time not between", value1, value2, "rushShoppingEndTime");
            return (Criteria) this;
        }

        public Criteria andPriceModificationAbsoluteIsNull() {
            addCriterion("price_modification_absolute is null");
            return (Criteria) this;
        }

        public Criteria andPriceModificationAbsoluteIsNotNull() {
            addCriterion("price_modification_absolute is not null");
            return (Criteria) this;
        }

        public Criteria andPriceModificationAbsoluteEqualTo(BigDecimal value) {
            addCriterion("price_modification_absolute =", value, "priceModificationAbsolute");
            return (Criteria) this;
        }

        public Criteria andPriceModificationAbsoluteNotEqualTo(BigDecimal value) {
            addCriterion("price_modification_absolute <>", value, "priceModificationAbsolute");
            return (Criteria) this;
        }

        public Criteria andPriceModificationAbsoluteGreaterThan(BigDecimal value) {
            addCriterion("price_modification_absolute >", value, "priceModificationAbsolute");
            return (Criteria) this;
        }

        public Criteria andPriceModificationAbsoluteGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_modification_absolute >=", value, "priceModificationAbsolute");
            return (Criteria) this;
        }

        public Criteria andPriceModificationAbsoluteLessThan(BigDecimal value) {
            addCriterion("price_modification_absolute <", value, "priceModificationAbsolute");
            return (Criteria) this;
        }

        public Criteria andPriceModificationAbsoluteLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_modification_absolute <=", value, "priceModificationAbsolute");
            return (Criteria) this;
        }

        public Criteria andPriceModificationAbsoluteIn(List<BigDecimal> values) {
            addCriterion("price_modification_absolute in", values, "priceModificationAbsolute");
            return (Criteria) this;
        }

        public Criteria andPriceModificationAbsoluteNotIn(List<BigDecimal> values) {
            addCriterion("price_modification_absolute not in", values, "priceModificationAbsolute");
            return (Criteria) this;
        }

        public Criteria andPriceModificationAbsoluteBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_modification_absolute between", value1, value2, "priceModificationAbsolute");
            return (Criteria) this;
        }

        public Criteria andPriceModificationAbsoluteNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_modification_absolute not between", value1, value2, "priceModificationAbsolute");
            return (Criteria) this;
        }

        public Criteria andPriceModificationRelativeIsNull() {
            addCriterion("price_modification_relative is null");
            return (Criteria) this;
        }

        public Criteria andPriceModificationRelativeIsNotNull() {
            addCriterion("price_modification_relative is not null");
            return (Criteria) this;
        }

        public Criteria andPriceModificationRelativeEqualTo(Float value) {
            addCriterion("price_modification_relative =", value, "priceModificationRelative");
            return (Criteria) this;
        }

        public Criteria andPriceModificationRelativeNotEqualTo(Float value) {
            addCriterion("price_modification_relative <>", value, "priceModificationRelative");
            return (Criteria) this;
        }

        public Criteria andPriceModificationRelativeGreaterThan(Float value) {
            addCriterion("price_modification_relative >", value, "priceModificationRelative");
            return (Criteria) this;
        }

        public Criteria andPriceModificationRelativeGreaterThanOrEqualTo(Float value) {
            addCriterion("price_modification_relative >=", value, "priceModificationRelative");
            return (Criteria) this;
        }

        public Criteria andPriceModificationRelativeLessThan(Float value) {
            addCriterion("price_modification_relative <", value, "priceModificationRelative");
            return (Criteria) this;
        }

        public Criteria andPriceModificationRelativeLessThanOrEqualTo(Float value) {
            addCriterion("price_modification_relative <=", value, "priceModificationRelative");
            return (Criteria) this;
        }

        public Criteria andPriceModificationRelativeIn(List<Float> values) {
            addCriterion("price_modification_relative in", values, "priceModificationRelative");
            return (Criteria) this;
        }

        public Criteria andPriceModificationRelativeNotIn(List<Float> values) {
            addCriterion("price_modification_relative not in", values, "priceModificationRelative");
            return (Criteria) this;
        }

        public Criteria andPriceModificationRelativeBetween(Float value1, Float value2) {
            addCriterion("price_modification_relative between", value1, value2, "priceModificationRelative");
            return (Criteria) this;
        }

        public Criteria andPriceModificationRelativeNotBetween(Float value1, Float value2) {
            addCriterion("price_modification_relative not between", value1, value2, "priceModificationRelative");
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