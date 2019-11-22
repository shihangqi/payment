package com.qingfeng.payment.dto;

import com.qingfeng.payment.entity.GoodsDetail;
import com.qingfeng.payment.utils.Serialnumber;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author shihangqi
 * @date 2019/11/21 - 20:59
 */
@Data
@ToString
@Accessors(chain = true)
public class AlipayBizParameters extends AlipayParameters{


    /**
     * 在公共参数中设置回跳地址
     */
    private String returnUrl = "http://www.shqblog.cn:8000/pay/alipayReturn";
    /**
     * 在公共参数中设置通知地址
     */
    private String notifyUrl = "http://www.shqblog.cn:8001/pay/alipayNotify";

    /**
     * 是否必选：必选
     * 长度：64
     * 描述：商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复
     * 示例：20150320010101001
     */
    private String out_trade_no = Serialnumber.Getnum();
    /**
     * 是否必选：必选
     * 长度：64
     * 描述：销售产品码，与支付宝签约的产品码名称。 注：目前仅支持FAST_INSTANT_TRADE_PAY
     * 示例：FAST_INSTANT_TRADE_PAY
     */
    private String product_code = "FAST_INSTANT_TRADE_PAY";

    /**
     * 是否必选：可选
     * 长度：32
     * 描述：绝对超时时间，格式为yyyy-MM-dd HH:mm:ss
     * 示例：2016-12-31 10:05:01
     */
    private String time_expire;
    /**
     * 是否必选：可选sys_service_provider_id
     * json
     * 描述：订单包含的商品列表信息，json格式，其它说明详见商品明细说明
     */
    private GoodsDetail goods_detail;
    /**
     * 是否必选：可选
     * 长度：512
     * 描述：公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。支付宝只会在同步返回（包括跳转回商户网站）和异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝。
     * 示例：merchantBizType%3d3C%26merchantBizNo%3d2016010101111
     */
    private String passback_params = "merchantBizType%3d3C%26merchantBizNo%3d2016010101111";
    /**
     * 是否必选：可选
     * 长度：2
     * 描述：商品主类型 :0-虚拟类商品,1-实物类商品 注：虚拟类商品不支持使用花呗渠道
     * 示例：	0
     */
    private String goods_type;
    /**
     * 是否必选：可选
     * 长度：6
     * 描述：该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m
     * 示例：90m
     */
    private String timeout_express;
    /**
     * 是否必选：可选
     * 长度：512
     * 描述：优惠参数 注：仅与支付宝协商后可用
     * 示例：{"storeIdType":"1"}
     */
    private String promo_params;
    /**
     * 是否必选：可选
     * 长度：32
     * 描述：商户原始订单号，最大长度限制32位
     * 示例：20161008001
     */
    private String merchant_order_no;
    /**
     * 是否必选：可选
     * 长度：128
     * 描述：可用渠道,用户只能在指定渠道范围内支付，多个渠道以逗号分割
     *  	注，与disable_pay_channels互斥
     *  	渠道列表：https://docs.open.alipay.com/common/wifww7
     * 示例：pcredit,moneyFund,debitCardExpress
     */
    private String enable_pay_channels;
    /**
     * 是否必选：可选
     * 长度：32
     * 描述：商户门店编号
     * 示例：NJ_001
     */
    private String store_id;
    /**
     * 是否必选：可选
     * 长度：128
     * 描述：禁用渠道,用户不可用指定渠道支付，多个渠道以逗号分割
     注，与enable_pay_channels互斥
     渠道列表：https://docs.open.alipay.com/common/wifww7
     * 示例：pcredit,moneyFund,debitCardExpress
     */
    private String disable_pay_channels;
    /**
     * 是否必选：可选
     * 长度：2
     * 描述：PC扫码支付的方式，支持前置模式和
     跳转模式。
     前置模式是将二维码前置到商户
     的订单确认页的模式。需要商户在
     自己的页面中以 iframe 方式请求
     支付宝页面。具体分为以下几种：
     0：订单码-简约前置模式，对应 iframe 宽度不能小于600px，高度不能小于300px；
     1：订单码-前置模式，对应iframe 宽度不能小于 300px，高度不能小于600px；
     3：订单码-迷你前置模式，对应 iframe 宽度不能小于 75px，高度不能小于75px；
     4：订单码-可定义宽度的嵌入式二维码，商户可根据需要设定二维码的大小。
     * 示例：1
     */
    private String qr_pay_mode;
    /**
     * 是否必选：可选
     * 长度：4
     * 描述：商户自定义二维码宽度 注：qr_pay_mode=4时该参数生效
     * 示例：100
     */
    private Integer qrcode_width;
    /**
     * 是否必选：可选
     * 长度：16
     * 描述：请求后页面的集成方式。
     取值范围：
     1. ALIAPP：支付宝钱包内
     2. PCWEB：PC端访问
     默认值为PCWEB。
     * 示例：PCWEB
     */
    private String integration_type;
    /**
     * 是否必选：可选
     * 长度：256
     * 描述：请求来源地址。如果使用ALIAPP的集成方式，用户中途取消支付会返回该地址。
     * 示例：https://
     */
    private String request_from_url;
    /**
     * 是否必选：可选
     * 长度：512
     * 描述：商户传入业务信息，具体值要和支付宝约定，应用于安全，营销等参数直传场景，格式为json格式
     * 示例：{"data":"123"}
     */
    private String business_params;


  /*  public String getJson(){
        String json = "{" ;
        if (out_trade_no!=null) {
            json += "\"out_trade_no\":\""+out_trade_no+"\",";
        }
        if (product_code!=null) {
            json+= "\"product_code\":\""+product_code+"\",";
        }
        if (total_amount!=null) {
            json+="\"total_amount\":\""+total_amount+"\",";
        }
        if (subject!=null) {
            json+="\"subject\":\""+subject+"\",";
        }
        if (body!=null) {
            json+="\"body\":\""+body+"\",";
        }
        if (time_expire!=null) {
            json+= "\"time_expire\":\""+time_expire+"\",";
        }
        if (goods_detail!=null) {
            json+= "\"goods_detail\":\""+goods_detail.getJson()+"\",";
        }
        if (passback_params!=null) {
            json+= "\"passback_params\":\""+passback_params+"\",";
        }
        if (goods_type!=null) {
            json+= "\"goods_type\":\""+goods_type+"\",";
        }
        if (timeout_express!=null) {
            json+= "\"timeout_express\":\""+timeout_express+"\",";
        }
        if (promo_params!=null) {
            json+= "\"promo_params\":\""+promo_params+"\",";
        }
        if (merchant_order_no!=null) {
            json+= "\"merchant_order_no\":\""+merchant_order_no+"\",";
        }
        if (enable_pay_channels!=null) {
            json+= "\"enable_pay_channels\":\""+enable_pay_channels+"\",";
        }
        if (store_id!=null) {
            json+= "\"store_id\":\""+store_id+"\",";
        }
        if (disable_pay_channels!=null) {
            json+= "\"disable_pay_channels\":\""+disable_pay_channels+"\",";
        }
        if (qr_pay_mode!=null) {
            json+= "\"qr_pay_mode\":\""+qr_pay_mode+"\",";
        }
        if (qrcode_width!=null) {
            json+= "\"qrcode_width\":\""+qrcode_width+"\",";
        }
        if (integration_type!=null) {
            json+= "\"integration_type\":\""+integration_type+"\",";
        }
        if (request_from_url!=null) {
            json+= "\"request_from_url\":\""+request_from_url+"\",";
        }
        if (business_params!=null) {
            json+= "\"business_params\":\""+business_params+"\",";
        }
        json = json.substring(0,json.length()-1);
        json+="}";

        return json;

    }
*/


}
