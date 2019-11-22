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
public class GoodsDetail extends BaseEntity<Long>{
    /**
     *
     */
    private static final long serialVersionUID = -288921576693133486L;

    /**
     * 必填
     * 描述：商品的编号
     * 最大长度：32
     */
    private String goods_id;
    /**
     * 选填
     * 描述：支付宝定义的统一商品编号
     * 最大长度：32
     */
    private String alipay_goods_id;
    /**
     * 必填
     * 描述：商品名称
     * 最大长度：256
     */
    private String goods_name;
    /**
     * 必填
     * 描述：商品数量
     * 最大长度：10
     */
    private Integer quantity;
    /**
     * 必填
     * 描述：商品价格
     * 最大长度：9
     */
    private Float price;
    /**
     * 选填
     * 描述：商品类目
     * 最大长度：24
     */
    private String goods_category;
    /**
     * 选填
     * 描述：商品类目树，从商品类目根节点到叶子节点的类目id组成，类目id值使用|分割
     * 最大长度：128
     */
    private String categories_tree;
    /**
     * 选填
     * 描述：商品描述信息
     * 最大长度：1000
     */
    private String body;
    /**
     * 选填
     * 描述：商品的展示地址
     * 最大长度：400
     */
    private String show_url;


//    public String getJson(){
//        String json = "{" ;
//        if (goods_id!=null) {
//            json += "\"goods_id\":\""+goods_id+"\",";
//        }
//        if (alipay_goods_id!=null) {
//            json+= "\"alipay_goods_id\":\""+alipay_goods_id+"\",";
//        }
//        if (goods_name!=null) {
//            json+="\"goods_name\":\""+goods_name+"\",";
//        }
//        if (quantity!=null) {
//            json+="\"quantity\":"+quantity+",";
//        }
//        if (price!=null) {
//            json+="\"price\":"+price+",";
//        }
//        if (goods_category!=null) {
//            json+= "\"goods_category\":\""+goods_category+"\",";
//        }
//        if (alipay_goods_id!=null) {
//            json+= "\"alipay_goods_id\":\""+alipay_goods_id+"\",";
//        }
//        if (categories_tree!=null) {
//            json+= "\"categories_tree\":\""+categories_tree+"\",";
//        }
//        if (body!=null) {
//            json+= "\"body\":\""+body+"\",";
//        }
//        if (show_url!=null) {
//            json+= "\"show_url\":\""+show_url+"\",";
//        }
//        json = json.substring(0,json.length()-1);
//        json+="}";
//
//        return json;
//
//    }



}
