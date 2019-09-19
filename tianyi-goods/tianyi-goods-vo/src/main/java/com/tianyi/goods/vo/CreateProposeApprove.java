package com.tianyi.goods.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProposeApprove {
    private Long id;

    private Integer proposeId;

    private Integer approveId;

    private Integer proposeType;


}