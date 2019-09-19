package com.tianyi.goods.vo;

import com.tianyi.goods.constant.ApproveErrorCode;
import com.tianyi.goods.entity.Approve;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateApproveRequest {
    private Long id;

    private Integer approveGrade;

    private Long approverId;

    private Integer approveResult;

    private String opinion;
    private Integer proposeType;

    private Integer proposeId;




    /**
     * @return 返回错误码                          f
     */
    public ApproveErrorCode validate() {


        if (null == this.approveGrade) {
            return ApproveErrorCode.EMPTY_GRADE;
        }
        if (null == this.approverId) {
            return ApproveErrorCode.EMPTY_APPROVER;
        }

        if (null == this.opinion) {
            return ApproveErrorCode.EMPTY_OPINION;
        }
        if (null == this.approveResult) {
            return ApproveErrorCode.EMPTY_RESULT;
        }
        if (null == this.proposeType) {
            return ApproveErrorCode.EMPTY_PROPOSE_TYPE;
        }
        if (null == this.proposeId) {
            return ApproveErrorCode.EMPTY_PROPOSE_ID;
        }

        return ApproveErrorCode.SUCCESS;
    }

    /**
     * <h2>将接受的数据转换为Approve审批对象</h2>
     *
     * @return {@link Approve}
     */

    public Approve toApprove() {

        Approve approve = new Approve();
        approve.setId(this.id);
        approve.setApproveGrade(this.approveGrade);
        approve.setApproverId(this.approverId);
        approve.setApproveResult(this.approveResult);
        approve.setOpinion(this.opinion);
        approve.setProposeType(this.proposeType);
        approve.setProposeId(this.proposeId);
        return approve;
    }


}