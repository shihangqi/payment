package com.qingfeng.payment.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author shihangqi
 * @date 2019/11/22 - 16:28
 */


@Data
@ToString
@Accessors(chain = true)
public class AlipayReturnParameters {

    private String charset;
    private String out_trade_no;
    private String method;
    private String total_amount;
    private String sign;
    private String trade_no;
    private String auth_app_id;
    private String version;
    private String app_id;
    private String sign_type;
    private String seller_id;
    private String timestamp;


}
