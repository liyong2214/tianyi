package com.tianyi.goods.vo;


import com.tianyi.goods.constant.GoodsBrandErrorCode;
import com.tianyi.goods.entity.GoodsBrand;
import com.tianyi.goods.entity.GoodsBrandExample;
import com.tianyi.goods.mapper.GoodsBrandMapper;

public class CreateGoodsBrandRequest {
    private Long brandId;

    private String brandName;

    private String des;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }


    /**
     * <h2>验证数据的有效性</h2>
     *
     * @param goodsBrandMapper
     * @return {@link GoodsBrandErrorCode}
     */
    public GoodsBrandErrorCode validate(GoodsBrandMapper goodsBrandMapper) {


        if (null == this.brandName) {
            return GoodsBrandErrorCode.EMPTY_BRAND_NAME;
        }

        GoodsBrandExample goodsBrandExample = new GoodsBrandExample();
        GoodsBrandExample.Criteria criteria = goodsBrandExample.createCriteria();
        criteria.andBrandNameEqualTo(this.brandName);

        if (goodsBrandMapper.selectByExample(goodsBrandExample).size() != 0) {
            return GoodsBrandErrorCode.DUPLICATE_NAME;
        }


        if (null == this.des) {
            return GoodsBrandErrorCode.EMPTY_DES;
        }

        return GoodsBrandErrorCode.SUCCESS;
    }



    /**
     * <h2> 将数据封装成GoodsBrand对象</h2>
     *
     * @return {@link GoodsBrand}
     */

    public GoodsBrand toGoodsBrand() {

        GoodsBrand goodsBrand = new GoodsBrand();
        goodsBrand.setBrandName(this.brandName);
        goodsBrand.setDes(this.des);

        return goodsBrand;
    }

}