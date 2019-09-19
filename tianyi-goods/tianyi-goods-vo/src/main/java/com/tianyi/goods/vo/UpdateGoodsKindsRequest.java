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
public class UpdateGoodsKindsRequest {
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


        if (goodsKindsMapper.selectByPrimaryKey(this.kindId) == null) {
            return GoodsKindErrorCode.EMPTY_KIND;
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
        goodsKinds.setKindId(this.kindId);
        goodsKinds.setKindName(this.kindName);
        goodsKinds.setpKindId(this.pKindId);
        goodsKinds.setDes(this.des);

        return goodsKinds;
    }

}