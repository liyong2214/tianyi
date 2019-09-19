package com.tianyi.goods.vo;

import com.tianyi.goods.constant.GoodsKindErrorCode;
import com.tianyi.goods.entity.GoodsKinds;
import com.tianyi.goods.entity.GoodsKindsExample;
import com.tianyi.goods.mapper.GoodsKindsMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGoodsKindsRequest {
    private Long kindId;

    private String kindName;

    private Long pKindId;

    private String des;


    /**
     * <h2>验证数据的有效性</h2>
     *
     * @param goodsKindsMapper
     * @return {@link GoodsKindErrorCode}
     */
    public GoodsKindErrorCode validate(GoodsKindsMapper goodsKindsMapper) {


        if (null == this.kindName) {
            return GoodsKindErrorCode.EMPTY_KIND_NAME;
        }

        GoodsKindsExample goodsKindsExample = new GoodsKindsExample();
        GoodsKindsExample.Criteria criteria = goodsKindsExample.createCriteria();
        criteria.andKindNameEqualTo(this.kindName);


        if (goodsKindsMapper.selectByExample(goodsKindsExample).size() != 0) {
            return GoodsKindErrorCode.DUPLICATE_NAME;
        }


        if (null == this.des) {
            return GoodsKindErrorCode.EMPTY_DES;
        }

        return GoodsKindErrorCode.SUCCESS;
    }


    /**
     * <h2> 将数据封装成GoodsKinds对象</h2>
     *
     * @return {@link GoodsKinds}
     */

    public GoodsKinds toGoodsKinds() {


        GoodsKinds goodsKinds = new GoodsKinds();
        goodsKinds.setKindName(this.kindName);
        goodsKinds.setpKindId(this.pKindId);
        goodsKinds.setDes(this.des);

        return goodsKinds;
    }

}