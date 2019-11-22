package com.qingfeng.payment.entity;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author shihangqi
 * @date 2019/11/21 - 21:00
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
public class Order extends GoodsDetail {
    private static final long serialVersionUID = -1005609769044268137L;
    /**
     * 支付宝交易号
     */
    private String trade_no;
    /**
     * 商户订单号
     */
    private String out_trade_no;
    /**
     * 	收款支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字
     */
    private String seller_id;
    /**
     * 交易金额
     */
    private String total_amount;
    /**
     * 商户原始订单号，最大长度限制32位
     */
    private String merchant_order_no;

}
