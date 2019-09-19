package com.tianyi.goods.vo;

import com.tianyi.goods.constant.ParamErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: tianyi
 * @description:
 * @author: Simon
 * @create: 2019-09-11 18:45
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateParam {


    private String param;


    public ParamErrorCode validate() {
        if (param == null) {
            return ParamErrorCode.EMPTY_PARAM;
        }
        return ParamErrorCode.SUCCESS;
    }
}
