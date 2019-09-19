package com.tianyi.goods.vo;


import com.tianyi.goods.constant.TransformGoodsComplimentaryErrorCode;
import com.tianyi.goods.entity.TransformGoodsComplimentary;
import com.tianyi.goods.mapper.GoodsMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateTransformGoodsComplimentaryRequest {
    private Integer id;

    private Long goodsId;

    private Integer translationNum;

    private Integer approveState;

    private Boolean approveResult;

    private Long proposerId;

    private Integer proposeType;

    /**
     * <h2>验证数据的有效性</h2>
     *
     * @param goodsMapper
     * @return {@link TransformGoodsComplimentaryErrorCode 转换申请单的错误码}
     */
    public TransformGoodsComplimentaryErrorCode valiDate(GoodsMapper goodsMapper) {

        if (this.goodsId == null) {
            return TransformGoodsComplimentaryErrorCode.EMPTY_GOODS_ID;
        }
        if (goodsMapper.selectByPrimaryKey(this.goodsId) == null) {
            return TransformGoodsComplimentaryErrorCode.MISTAKE_GOODS;
        }
        if (null == this.proposerId) {
            return TransformGoodsComplimentaryErrorCode.EMPTY_PROPOSER;
        }
        if (null == this.translationNum || this.translationNum < 0l) {
            return TransformGoodsComplimentaryErrorCode.EMPTY_TRANSLATION_NUM;
        }
        if (goodsMapper.selectByPrimaryKey(this.goodsId).getStockNum() <= this.translationNum) {
            return TransformGoodsComplimentaryErrorCode.MISTAKE_TRANSLATION_NUM;
        }


        return TransformGoodsComplimentaryErrorCode.SUCCESS;
    }


    /**
     * 数据转换
     *
     * @return
     */
    public TransformGoodsComplimentary toTransformGoodsComplimentary() {
        TransformGoodsComplimentary transformGoodsComplimentary = new TransformGoodsComplimentary();
        transformGoodsComplimentary.setId(this.id);
        transformGoodsComplimentary.setGoodsId(this.goodsId);
        transformGoodsComplimentary.setProposerId(this.proposerId);
        transformGoodsComplimentary.setTranslationNum(this.translationNum);
        transformGoodsComplimentary.setApproveState(this.approveState == null ? 1 : this.approveState);
        transformGoodsComplimentary.setApproveResult(this.approveResult == null ? false : this.approveResult);
        transformGoodsComplimentary.setProposeType(this.proposeType);
        return transformGoodsComplimentary;
    }
}