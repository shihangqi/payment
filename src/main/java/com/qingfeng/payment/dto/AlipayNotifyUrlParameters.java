package com.qingfeng.payment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author shihangqi
 * @date 2019/11/21 - 20:59
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AlipayNotifyUrlParameters {

    //公共参数

    /**
     * 是否必填：是
     * 描述：通知的发送时间。格式为yyyy-MM-dd HH:mm:ss
     * 示例：2015-14-27 15:45:58
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date notify_time;
    /**
     * 是否必填：是
     * 描述：通知的类型
     * 示例：trade_status_sync
     */
    private String notify_type;
    /**
     * 是否必填：是
     * 描述：通知校验ID
     * 示例：ac05099524730693a8b330c5ecf72da978
     */
    private String notify_id;
    /**
     * 是否必填：是
     * 描述：编码格式，如utf-8、gbk、gb2312等
     * 示例：utf-8
     */
    private String charset;
    /**
     * 是否必填：是
     * 描述：调用的接口版本，固定为：1.0
     * 示例：1.0
     */
    private String version;
    /**
     * 是否必填：是
     * 描述：签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
     * 示例：RSA2
     */
    private String sign_type;
    /**
     * 是否必填：是
     * 描述：需要对所有结果进行验证正确性
     * 示例：	601510b7970e52cc63db0f44997cf70e
     */
    private String sign;
    /**
     * 是否必填：是
     * 描述：授权方的appid，由于本接口暂不开放第三方应用授权，因此auth_app_id=app_id
     * 示例：2014072300007148
     */
    private String auth_app_id;




    //业务参数
    //注：receipt_amount、invoice_amount、buyer_pay_amount、point_amount、voucher_detail_list 等参数在用户使用优惠券时才会返回，其他情况请不要使用。
    /**
     * 是否必填：是
     * 描述：支付宝交易凭证号
     * 示例：	2013112011001004330000121536
     */
    private String trade_no;
    /**
     * 是否必填：是
     * 描述：支付宝分配给开发者的应用 ID
     * 示例：2014072300007148
     */
    private String app_id;
    /**
     * 是否必填：是
     * 描述：	原支付请求的商户订单号
     * 示例：6823789339978248
     */
    private String out_trade_no;
    /**
     * 是否必填：否
     * 描述：商户业务 ID，主要是退款通知中返回退款申请的流水号
     * 示例：HZRF001
     */
    private String out_biz_no;
    /**
     * 是否必填：否
     * 描述：买家支付宝账号对应的支付宝唯一用户号。以 2088 开头的纯 16 位数字
     * 示例：	2088102122524333
     */
    private String buyer_id;
    /**
     * 是否必填：否
     * 描述：卖家支付宝用户号
     * 示例：	2088101106499364
     */
    private String seller_id;
    /**
     * 是否必填：否
     * 描述：交易目前所处的状态
     * 示例：TRADE_CLOSED
     */
    private String trade_status;
    /**
     * 是否必填：否
     * 描述：	本次交易支付的订单金额，单位为人民币（元），精确到小数点后2位
     * 示例：20.00
     */
    private String total_amount;
    /**
     * 是否必填：否
     * 描述：商家在交易中实际收到的款项，单位为元，精确到小数点后2位
     * 示例：15.00
     */
    private String receipt_amount;
    /**
     * 是否必填：否
     * 描述：用户在交易中支付的可开发票的金额，单位为元，精确到小数点后2位
     * 示例：10.00
     */
    private String invoice_amount;
    /**
     * 是否必填：否
     * 描述：用户在交易中支付的金额，单位为元，精确到小数点后2位
     * 示例：13.88
     */
    private String buyer_pay_amount;
    /**
     * 是否必填：否
     * 描述：使用集分宝支付的金额，单位为元，精确到小数点后2位
     * 示例：	12.00
     */
    private String point_amount;
    /**
     * 是否必填：否
     * 描述：退款通知中，返回总退款金额，单位为元，精确到小数点后2位
     * 示例：2.58
     */
    private String refund_fee;
    /**
     * 是否必填：否
     * 描述：商品的标题/交易标题/订单标题/订单关键字等，是请求时对应的参数，原样通知回来
     * 示例：当面付交易
     */
    private String subject;
    /**
     * 是否必填：否
     * 描述：该订单的备注、描述、明细等。对应请求时的body参数，原样通知回来
     * 示例：当面付交易内容
     */
    private String body;
    /**
     * 是否必填：否
     * 描述：该笔交易创建的时间。格式为yyyy-MM-dd HH:mm:ss
     * 示例：2015-04-27 15:45:57
     */
    private String gmt_create;
    /**
     * 是否必填：否
     * 描述：该笔交易的买家付款时间。格式为yyyy-MM-dd HH:mm:ss
     * 示例：2015-04-27 15:45:57
     */
    private String gmt_payment;
    /**
     * 是否必填：否
     * 描述：该笔交易的退款时间。格式为yyyy-MM-dd HH:mm:ss.S
     * 示例：2015-04-28 15:45:57.320
     */
    private String gmt_refund;
    /**
     * 是否必填：否
     * 描述：该笔交易结束时间。格式为yyyy-MM-dd HH:mm:ss
     * 示例：2015-04-29 15:45:57
     */
    private String gmt_close;
    /**
     * 是否必填：否
     * 描述：支付成功的各个渠道金额信息
     * 示例：[{“amount”:“15.00”,“fundChannel”:“ALIPAYACCOUNT”}]
     */
    private String fund_bill_list;
    /**
     * 是否必填：否
     * 描述：本交易支付时所使用的所有优惠券信息
     * 示例：[{“amount”:“0.20”,“merchantContribute”:“0.00”,“name”:“一键创建券模板的券名称”,“otherContribute”:“0.20”,“type”:“ALIPAY_DISCOUNT_VOUCHER”,“memo”:“学生卡8折优惠”]
     */
    private String voucher_detail_list;
    /**
     * 是否必填：否
     * 描述：	公共回传参数，如果请求时传递了该参数，则返回给商户时会在异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝
     * 示例：merchantBizType%3d3C%26merchantBizNo%3d2016010101111
     */
    private String passback_params;

}
