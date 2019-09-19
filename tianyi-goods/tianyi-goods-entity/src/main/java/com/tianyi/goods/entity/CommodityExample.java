package com.tianyi.goods.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CommodityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommodityExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andKindIdIsNull() {
            addCriterion("kind_id is null");
            return (Criteria) this;
        }

        public Criteria andKindIdIsNotNull() {
            addCriterion("kind_id is not null");
            return (Criteria) this;
        }

        public Criteria andKindIdEqualTo(Long value) {
            addCriterion("kind_id =", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotEqualTo(Long value) {
            addCriterion("kind_id <>", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdGreaterThan(Long value) {
            addCriterion("kind_id >", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdGreaterThanOrEqualTo(Long value) {
            addCriterion("kind_id >=", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdLessThan(Long value) {
            addCriterion("kind_id <", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdLessThanOrEqualTo(Long value) {
            addCriterion("kind_id <=", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdIn(List<Long> values) {
            addCriterion("kind_id in", values, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotIn(List<Long> values) {
            addCriterion("kind_id not in", values, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdBetween(Long value1, Long value2) {
            addCriterion("kind_id between", value1, value2, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotBetween(Long value1, Long value2) {
            addCriterion("kind_id not between", value1, value2, "kindId");
            return (Criteria) this;
        }

        public Criteria andGoodsShortTitleIsNull() {
            addCriterion("goods_short_title is null");
            return (Criteria) this;
        }

        public Criteria andGoodsShortTitleIsNotNull() {
            addCriterion("goods_short_title is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsShortTitleEqualTo(String value) {
            addCriterion("goods_short_title =", value, "goodsShortTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsShortTitleNotEqualTo(String value) {
            addCriterion("goods_short_title <>", value, "goodsShortTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsShortTitleGreaterThan(String value) {
            addCriterion("goods_short_title >", value, "goodsShortTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsShortTitleGreaterThanOrEqualTo(String value) {
            addCriterion("goods_short_title >=", value, "goodsShortTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsShortTitleLessThan(String value) {
            addCriterion("goods_short_title <", value, "goodsShortTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsShortTitleLessThanOrEqualTo(String value) {
            addCriterion("goods_short_title <=", value, "goodsShortTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsShortTitleLike(String value) {
            addCriterion("goods_short_title like", value, "goodsShortTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsShortTitleNotLike(String value) {
            addCriterion("goods_short_title not like", value, "goodsShortTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsShortTitleIn(List<String> values) {
            addCriterion("goods_short_title in", values, "goodsShortTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsShortTitleNotIn(List<String> values) {
            addCriterion("goods_short_title not in", values, "goodsShortTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsShortTitleBetween(String value1, String value2) {
            addCriterion("goods_short_title between", value1, value2, "goodsShortTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsShortTitleNotBetween(String value1, String value2) {
            addCriterion("goods_short_title not between", value1, value2, "goodsShortTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsLongTitleIsNull() {
            addCriterion("goods_long_title is null");
            return (Criteria) this;
        }

        public Criteria andGoodsLongTitleIsNotNull() {
            addCriterion("goods_long_title is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsLongTitleEqualTo(String value) {
            addCriterion("goods_long_title =", value, "goodsLongTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsLongTitleNotEqualTo(String value) {
            addCriterion("goods_long_title <>", value, "goodsLongTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsLongTitleGreaterThan(String value) {
            addCriterion("goods_long_title >", value, "goodsLongTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsLongTitleGreaterThanOrEqualTo(String value) {
            addCriterion("goods_long_title >=", value, "goodsLongTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsLongTitleLessThan(String value) {
            addCriterion("goods_long_title <", value, "goodsLongTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsLongTitleLessThanOrEqualTo(String value) {
            addCriterion("goods_long_title <=", value, "goodsLongTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsLongTitleLike(String value) {
            addCriterion("goods_long_title like", value, "goodsLongTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsLongTitleNotLike(String value) {
            addCriterion("goods_long_title not like", value, "goodsLongTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsLongTitleIn(List<String> values) {
            addCriterion("goods_long_title in", values, "goodsLongTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsLongTitleNotIn(List<String> values) {
            addCriterion("goods_long_title not in", values, "goodsLongTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsLongTitleBetween(String value1, String value2) {
            addCriterion("goods_long_title between", value1, value2, "goodsLongTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsLongTitleNotBetween(String value1, String value2) {
            addCriterion("goods_long_title not between", value1, value2, "goodsLongTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsAdsIsNull() {
            addCriterion("goods_ads is null");
            return (Criteria) this;
        }

        public Criteria andGoodsAdsIsNotNull() {
            addCriterion("goods_ads is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsAdsEqualTo(String value) {
            addCriterion("goods_ads =", value, "goodsAds");
            return (Criteria) this;
        }

        public Criteria andGoodsAdsNotEqualTo(String value) {
            addCriterion("goods_ads <>", value, "goodsAds");
            return (Criteria) this;
        }

        public Criteria andGoodsAdsGreaterThan(String value) {
            addCriterion("goods_ads >", value, "goodsAds");
            return (Criteria) this;
        }

        public Criteria andGoodsAdsGreaterThanOrEqualTo(String value) {
            addCriterion("goods_ads >=", value, "goodsAds");
            return (Criteria) this;
        }

        public Criteria andGoodsAdsLessThan(String value) {
            addCriterion("goods_ads <", value, "goodsAds");
            return (Criteria) this;
        }

        public Criteria andGoodsAdsLessThanOrEqualTo(String value) {
            addCriterion("goods_ads <=", value, "goodsAds");
            return (Criteria) this;
        }

        public Criteria andGoodsAdsLike(String value) {
            addCriterion("goods_ads like", value, "goodsAds");
            return (Criteria) this;
        }

        public Criteria andGoodsAdsNotLike(String value) {
            addCriterion("goods_ads not like", value, "goodsAds");
            return (Criteria) this;
        }

        public Criteria andGoodsAdsIn(List<String> values) {
            addCriterion("goods_ads in", values, "goodsAds");
            return (Criteria) this;
        }

        public Criteria andGoodsAdsNotIn(List<String> values) {
            addCriterion("goods_ads not in", values, "goodsAds");
            return (Criteria) this;
        }

        public Criteria andGoodsAdsBetween(String value1, String value2) {
            addCriterion("goods_ads between", value1, value2, "goodsAds");
            return (Criteria) this;
        }

        public Criteria andGoodsAdsNotBetween(String value1, String value2) {
            addCriterion("goods_ads not between", value1, value2, "goodsAds");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightIsNull() {
            addCriterion("goods_weight is null");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightIsNotNull() {
            addCriterion("goods_weight is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightEqualTo(Double value) {
            addCriterion("goods_weight =", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightNotEqualTo(Double value) {
            addCriterion("goods_weight <>", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightGreaterThan(Double value) {
            addCriterion("goods_weight >", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("goods_weight >=", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightLessThan(Double value) {
            addCriterion("goods_weight <", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightLessThanOrEqualTo(Double value) {
            addCriterion("goods_weight <=", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightIn(List<Double> values) {
            addCriterion("goods_weight in", values, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightNotIn(List<Double> values) {
            addCriterion("goods_weight not in", values, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightBetween(Double value1, Double value2) {
            addCriterion("goods_weight between", value1, value2, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightNotBetween(Double value1, Double value2) {
            addCriterion("goods_weight not between", value1, value2, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andTimeToMarketIsNull() {
            addCriterion("time_to_market is null");
            return (Criteria) this;
        }

        public Criteria andTimeToMarketIsNotNull() {
            addCriterion("time_to_market is not null");
            return (Criteria) this;
        }

        public Criteria andTimeToMarketEqualTo(Date value) {
            addCriterionForJDBCDate("time_to_market =", value, "timeToMarket");
            return (Criteria) this;
        }

        public Criteria andTimeToMarketNotEqualTo(Date value) {
            addCriterionForJDBCDate("time_to_market <>", value, "timeToMarket");
            return (Criteria) this;
        }

        public Criteria andTimeToMarketGreaterThan(Date value) {
            addCriterionForJDBCDate("time_to_market >", value, "timeToMarket");
            return (Criteria) this;
        }

        public Criteria andTimeToMarketGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("time_to_market >=", value, "timeToMarket");
            return (Criteria) this;
        }

        public Criteria andTimeToMarketLessThan(Date value) {
            addCriterionForJDBCDate("time_to_market <", value, "timeToMarket");
            return (Criteria) this;
        }

        public Criteria andTimeToMarketLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("time_to_market <=", value, "timeToMarket");
            return (Criteria) this;
        }

        public Criteria andTimeToMarketIn(List<Date> values) {
            addCriterionForJDBCDate("time_to_market in", values, "timeToMarket");
            return (Criteria) this;
        }

        public Criteria andTimeToMarketNotIn(List<Date> values) {
            addCriterionForJDBCDate("time_to_market not in", values, "timeToMarket");
            return (Criteria) this;
        }

        public Criteria andTimeToMarketBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("time_to_market between", value1, value2, "timeToMarket");
            return (Criteria) this;
        }

        public Criteria andTimeToMarketNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("time_to_market not between", value1, value2, "timeToMarket");
            return (Criteria) this;
        }

        public Criteria andGoodsMarketPriceIsNull() {
            addCriterion("goods_market_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsMarketPriceIsNotNull() {
            addCriterion("goods_market_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsMarketPriceEqualTo(BigDecimal value) {
            addCriterion("goods_market_price =", value, "goodsMarketPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsMarketPriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_market_price <>", value, "goodsMarketPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsMarketPriceGreaterThan(BigDecimal value) {
            addCriterion("goods_market_price >", value, "goodsMarketPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsMarketPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_market_price >=", value, "goodsMarketPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsMarketPriceLessThan(BigDecimal value) {
            addCriterion("goods_market_price <", value, "goodsMarketPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsMarketPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_market_price <=", value, "goodsMarketPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsMarketPriceIn(List<BigDecimal> values) {
            addCriterion("goods_market_price in", values, "goodsMarketPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsMarketPriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_market_price not in", values, "goodsMarketPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsMarketPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_market_price between", value1, value2, "goodsMarketPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsMarketPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_market_price not between", value1, value2, "goodsMarketPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsTianyiPriceIsNull() {
            addCriterion("goods_tianyi_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTianyiPriceIsNotNull() {
            addCriterion("goods_tianyi_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTianyiPriceEqualTo(BigDecimal value) {
            addCriterion("goods_tianyi_price =", value, "goodsTianyiPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsTianyiPriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_tianyi_price <>", value, "goodsTianyiPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsTianyiPriceGreaterThan(BigDecimal value) {
            addCriterion("goods_tianyi_price >", value, "goodsTianyiPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsTianyiPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_tianyi_price >=", value, "goodsTianyiPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsTianyiPriceLessThan(BigDecimal value) {
            addCriterion("goods_tianyi_price <", value, "goodsTianyiPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsTianyiPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_tianyi_price <=", value, "goodsTianyiPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsTianyiPriceIn(List<BigDecimal> values) {
            addCriterion("goods_tianyi_price in", values, "goodsTianyiPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsTianyiPriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_tianyi_price not in", values, "goodsTianyiPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsTianyiPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_tianyi_price between", value1, value2, "goodsTianyiPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsTianyiPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_tianyi_price not between", value1, value2, "goodsTianyiPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionPriceIsNull() {
            addCriterion("goods_promotion_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionPriceIsNotNull() {
            addCriterion("goods_promotion_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionPriceEqualTo(BigDecimal value) {
            addCriterion("goods_promotion_price =", value, "goodsPromotionPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionPriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_promotion_price <>", value, "goodsPromotionPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionPriceGreaterThan(BigDecimal value) {
            addCriterion("goods_promotion_price >", value, "goodsPromotionPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_promotion_price >=", value, "goodsPromotionPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionPriceLessThan(BigDecimal value) {
            addCriterion("goods_promotion_price <", value, "goodsPromotionPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_promotion_price <=", value, "goodsPromotionPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionPriceIn(List<BigDecimal> values) {
            addCriterion("goods_promotion_price in", values, "goodsPromotionPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionPriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_promotion_price not in", values, "goodsPromotionPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_promotion_price between", value1, value2, "goodsPromotionPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_promotion_price not between", value1, value2, "goodsPromotionPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionPlaceIsNull() {
            addCriterion("goods_production_place is null");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionPlaceIsNotNull() {
            addCriterion("goods_production_place is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionPlaceEqualTo(String value) {
            addCriterion("goods_production_place =", value, "goodsProductionPlace");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionPlaceNotEqualTo(String value) {
            addCriterion("goods_production_place <>", value, "goodsProductionPlace");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionPlaceGreaterThan(String value) {
            addCriterion("goods_production_place >", value, "goodsProductionPlace");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("goods_production_place >=", value, "goodsProductionPlace");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionPlaceLessThan(String value) {
            addCriterion("goods_production_place <", value, "goodsProductionPlace");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionPlaceLessThanOrEqualTo(String value) {
            addCriterion("goods_production_place <=", value, "goodsProductionPlace");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionPlaceLike(String value) {
            addCriterion("goods_production_place like", value, "goodsProductionPlace");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionPlaceNotLike(String value) {
            addCriterion("goods_production_place not like", value, "goodsProductionPlace");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionPlaceIn(List<String> values) {
            addCriterion("goods_production_place in", values, "goodsProductionPlace");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionPlaceNotIn(List<String> values) {
            addCriterion("goods_production_place not in", values, "goodsProductionPlace");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionPlaceBetween(String value1, String value2) {
            addCriterion("goods_production_place between", value1, value2, "goodsProductionPlace");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionPlaceNotBetween(String value1, String value2) {
            addCriterion("goods_production_place not between", value1, value2, "goodsProductionPlace");
            return (Criteria) this;
        }

        public Criteria andIsPutawayIsNull() {
            addCriterion("is_putaway is null");
            return (Criteria) this;
        }

        public Criteria andIsPutawayIsNotNull() {
            addCriterion("is_putaway is not null");
            return (Criteria) this;
        }

        public Criteria andIsPutawayEqualTo(Integer value) {
            addCriterion("is_putaway =", value, "isPutaway");
            return (Criteria) this;
        }

        public Criteria andIsPutawayNotEqualTo(Integer value) {
            addCriterion("is_putaway <>", value, "isPutaway");
            return (Criteria) this;
        }

        public Criteria andIsPutawayGreaterThan(Integer value) {
            addCriterion("is_putaway >", value, "isPutaway");
            return (Criteria) this;
        }

        public Criteria andIsPutawayGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_putaway >=", value, "isPutaway");
            return (Criteria) this;
        }

        public Criteria andIsPutawayLessThan(Integer value) {
            addCriterion("is_putaway <", value, "isPutaway");
            return (Criteria) this;
        }

        public Criteria andIsPutawayLessThanOrEqualTo(Integer value) {
            addCriterion("is_putaway <=", value, "isPutaway");
            return (Criteria) this;
        }

        public Criteria andIsPutawayIn(List<Integer> values) {
            addCriterion("is_putaway in", values, "isPutaway");
            return (Criteria) this;
        }

        public Criteria andIsPutawayNotIn(List<Integer> values) {
            addCriterion("is_putaway not in", values, "isPutaway");
            return (Criteria) this;
        }

        public Criteria andIsPutawayBetween(Integer value1, Integer value2) {
            addCriterion("is_putaway between", value1, value2, "isPutaway");
            return (Criteria) this;
        }

        public Criteria andIsPutawayNotBetween(Integer value1, Integer value2) {
            addCriterion("is_putaway not between", value1, value2, "isPutaway");
            return (Criteria) this;
        }

        public Criteria andPackingListIsNull() {
            addCriterion("packing_list is null");
            return (Criteria) this;
        }

        public Criteria andPackingListIsNotNull() {
            addCriterion("packing_list is not null");
            return (Criteria) this;
        }

        public Criteria andPackingListEqualTo(String value) {
            addCriterion("packing_list =", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListNotEqualTo(String value) {
            addCriterion("packing_list <>", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListGreaterThan(String value) {
            addCriterion("packing_list >", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListGreaterThanOrEqualTo(String value) {
            addCriterion("packing_list >=", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListLessThan(String value) {
            addCriterion("packing_list <", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListLessThanOrEqualTo(String value) {
            addCriterion("packing_list <=", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListLike(String value) {
            addCriterion("packing_list like", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListNotLike(String value) {
            addCriterion("packing_list not like", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListIn(List<String> values) {
            addCriterion("packing_list in", values, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListNotIn(List<String> values) {
            addCriterion("packing_list not in", values, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListBetween(String value1, String value2) {
            addCriterion("packing_list between", value1, value2, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListNotBetween(String value1, String value2) {
            addCriterion("packing_list not between", value1, value2, "packingList");
            return (Criteria) this;
        }

        public Criteria andRelatePhotoIsNull() {
            addCriterion("relate_photo is null");
            return (Criteria) this;
        }

        public Criteria andRelatePhotoIsNotNull() {
            addCriterion("relate_photo is not null");
            return (Criteria) this;
        }

        public Criteria andRelatePhotoEqualTo(String value) {
            addCriterion("relate_photo =", value, "relatePhoto");
            return (Criteria) this;
        }

        public Criteria andRelatePhotoNotEqualTo(String value) {
            addCriterion("relate_photo <>", value, "relatePhoto");
            return (Criteria) this;
        }

        public Criteria andRelatePhotoGreaterThan(String value) {
            addCriterion("relate_photo >", value, "relatePhoto");
            return (Criteria) this;
        }

        public Criteria andRelatePhotoGreaterThanOrEqualTo(String value) {
            addCriterion("relate_photo >=", value, "relatePhoto");
            return (Criteria) this;
        }

        public Criteria andRelatePhotoLessThan(String value) {
            addCriterion("relate_photo <", value, "relatePhoto");
            return (Criteria) this;
        }

        public Criteria andRelatePhotoLessThanOrEqualTo(String value) {
            addCriterion("relate_photo <=", value, "relatePhoto");
            return (Criteria) this;
        }

        public Criteria andRelatePhotoLike(String value) {
            addCriterion("relate_photo like", value, "relatePhoto");
            return (Criteria) this;
        }

        public Criteria andRelatePhotoNotLike(String value) {
            addCriterion("relate_photo not like", value, "relatePhoto");
            return (Criteria) this;
        }

        public Criteria andRelatePhotoIn(List<String> values) {
            addCriterion("relate_photo in", values, "relatePhoto");
            return (Criteria) this;
        }

        public Criteria andRelatePhotoNotIn(List<String> values) {
            addCriterion("relate_photo not in", values, "relatePhoto");
            return (Criteria) this;
        }

        public Criteria andRelatePhotoBetween(String value1, String value2) {
            addCriterion("relate_photo between", value1, value2, "relatePhoto");
            return (Criteria) this;
        }

        public Criteria andRelatePhotoNotBetween(String value1, String value2) {
            addCriterion("relate_photo not between", value1, value2, "relatePhoto");
            return (Criteria) this;
        }

        public Criteria andRelateAccessoriesIsNull() {
            addCriterion("relate_accessories is null");
            return (Criteria) this;
        }

        public Criteria andRelateAccessoriesIsNotNull() {
            addCriterion("relate_accessories is not null");
            return (Criteria) this;
        }

        public Criteria andRelateAccessoriesEqualTo(String value) {
            addCriterion("relate_accessories =", value, "relateAccessories");
            return (Criteria) this;
        }

        public Criteria andRelateAccessoriesNotEqualTo(String value) {
            addCriterion("relate_accessories <>", value, "relateAccessories");
            return (Criteria) this;
        }

        public Criteria andRelateAccessoriesGreaterThan(String value) {
            addCriterion("relate_accessories >", value, "relateAccessories");
            return (Criteria) this;
        }

        public Criteria andRelateAccessoriesGreaterThanOrEqualTo(String value) {
            addCriterion("relate_accessories >=", value, "relateAccessories");
            return (Criteria) this;
        }

        public Criteria andRelateAccessoriesLessThan(String value) {
            addCriterion("relate_accessories <", value, "relateAccessories");
            return (Criteria) this;
        }

        public Criteria andRelateAccessoriesLessThanOrEqualTo(String value) {
            addCriterion("relate_accessories <=", value, "relateAccessories");
            return (Criteria) this;
        }

        public Criteria andRelateAccessoriesLike(String value) {
            addCriterion("relate_accessories like", value, "relateAccessories");
            return (Criteria) this;
        }

        public Criteria andRelateAccessoriesNotLike(String value) {
            addCriterion("relate_accessories not like", value, "relateAccessories");
            return (Criteria) this;
        }

        public Criteria andRelateAccessoriesIn(List<String> values) {
            addCriterion("relate_accessories in", values, "relateAccessories");
            return (Criteria) this;
        }

        public Criteria andRelateAccessoriesNotIn(List<String> values) {
            addCriterion("relate_accessories not in", values, "relateAccessories");
            return (Criteria) this;
        }

        public Criteria andRelateAccessoriesBetween(String value1, String value2) {
            addCriterion("relate_accessories between", value1, value2, "relateAccessories");
            return (Criteria) this;
        }

        public Criteria andRelateAccessoriesNotBetween(String value1, String value2) {
            addCriterion("relate_accessories not between", value1, value2, "relateAccessories");
            return (Criteria) this;
        }

        public Criteria andRelateEvaluatingIsNull() {
            addCriterion("relate_evaluating is null");
            return (Criteria) this;
        }

        public Criteria andRelateEvaluatingIsNotNull() {
            addCriterion("relate_evaluating is not null");
            return (Criteria) this;
        }

        public Criteria andRelateEvaluatingEqualTo(String value) {
            addCriterion("relate_evaluating =", value, "relateEvaluating");
            return (Criteria) this;
        }

        public Criteria andRelateEvaluatingNotEqualTo(String value) {
            addCriterion("relate_evaluating <>", value, "relateEvaluating");
            return (Criteria) this;
        }

        public Criteria andRelateEvaluatingGreaterThan(String value) {
            addCriterion("relate_evaluating >", value, "relateEvaluating");
            return (Criteria) this;
        }

        public Criteria andRelateEvaluatingGreaterThanOrEqualTo(String value) {
            addCriterion("relate_evaluating >=", value, "relateEvaluating");
            return (Criteria) this;
        }

        public Criteria andRelateEvaluatingLessThan(String value) {
            addCriterion("relate_evaluating <", value, "relateEvaluating");
            return (Criteria) this;
        }

        public Criteria andRelateEvaluatingLessThanOrEqualTo(String value) {
            addCriterion("relate_evaluating <=", value, "relateEvaluating");
            return (Criteria) this;
        }

        public Criteria andRelateEvaluatingLike(String value) {
            addCriterion("relate_evaluating like", value, "relateEvaluating");
            return (Criteria) this;
        }

        public Criteria andRelateEvaluatingNotLike(String value) {
            addCriterion("relate_evaluating not like", value, "relateEvaluating");
            return (Criteria) this;
        }

        public Criteria andRelateEvaluatingIn(List<String> values) {
            addCriterion("relate_evaluating in", values, "relateEvaluating");
            return (Criteria) this;
        }

        public Criteria andRelateEvaluatingNotIn(List<String> values) {
            addCriterion("relate_evaluating not in", values, "relateEvaluating");
            return (Criteria) this;
        }

        public Criteria andRelateEvaluatingBetween(String value1, String value2) {
            addCriterion("relate_evaluating between", value1, value2, "relateEvaluating");
            return (Criteria) this;
        }

        public Criteria andRelateEvaluatingNotBetween(String value1, String value2) {
            addCriterion("relate_evaluating not between", value1, value2, "relateEvaluating");
            return (Criteria) this;
        }

        public Criteria andGoodsComplimentaryIsNull() {
            addCriterion("goods_complimentary is null");
            return (Criteria) this;
        }

        public Criteria andGoodsComplimentaryIsNotNull() {
            addCriterion("goods_complimentary is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsComplimentaryEqualTo(Integer value) {
            addCriterion("goods_complimentary =", value, "goodsComplimentary");
            return (Criteria) this;
        }

        public Criteria andGoodsComplimentaryNotEqualTo(Integer value) {
            addCriterion("goods_complimentary <>", value, "goodsComplimentary");
            return (Criteria) this;
        }

        public Criteria andGoodsComplimentaryGreaterThan(Integer value) {
            addCriterion("goods_complimentary >", value, "goodsComplimentary");
            return (Criteria) this;
        }

        public Criteria andGoodsComplimentaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_complimentary >=", value, "goodsComplimentary");
            return (Criteria) this;
        }

        public Criteria andGoodsComplimentaryLessThan(Integer value) {
            addCriterion("goods_complimentary <", value, "goodsComplimentary");
            return (Criteria) this;
        }

        public Criteria andGoodsComplimentaryLessThanOrEqualTo(Integer value) {
            addCriterion("goods_complimentary <=", value, "goodsComplimentary");
            return (Criteria) this;
        }

        public Criteria andGoodsComplimentaryIn(List<Integer> values) {
            addCriterion("goods_complimentary in", values, "goodsComplimentary");
            return (Criteria) this;
        }

        public Criteria andGoodsComplimentaryNotIn(List<Integer> values) {
            addCriterion("goods_complimentary not in", values, "goodsComplimentary");
            return (Criteria) this;
        }

        public Criteria andGoodsComplimentaryBetween(Integer value1, Integer value2) {
            addCriterion("goods_complimentary between", value1, value2, "goodsComplimentary");
            return (Criteria) this;
        }

        public Criteria andGoodsComplimentaryNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_complimentary not between", value1, value2, "goodsComplimentary");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Long value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Long value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Long value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Long value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Long value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Long value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Long> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Long> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Long value1, Long value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Long value1, Long value2) {
            addCriterion("num not between", value1, value2, "num");
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