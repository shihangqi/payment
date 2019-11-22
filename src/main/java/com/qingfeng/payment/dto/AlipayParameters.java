package com.qingfeng.payment.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author shihangqi
 * @date 2019/11/22 - 15:50
 */

@Data
@ToString
@Accessors(chain = true)
public class AlipayParameters implements Serializable {

    /**
     * 是否必选：必选
     * 长度：11
     * 描述：订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。
     * 示例：88.88
     */
    private Float total_amount;


    /**
     * 是否必选：必选
     * 长度：256
     * 描述：订单标题
     * 示例：Iphone6 16G
     */
    private String subject;
    /**
     * 是否必选：可选
     * 长度：128
     * 描述：订单描述
     * 示例：Iphone6 16G
     */
    private String body;



}
