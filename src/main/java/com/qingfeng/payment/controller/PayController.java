package com.qingfeng.payment.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.qingfeng.payment.dto.AlipayBizParameters;
import com.qingfeng.payment.dto.AlipayNotifyUrlParameters;
import com.qingfeng.payment.dto.AlipayReturnParameters;
import com.qingfeng.payment.entity.PayInfo;
import com.qingfeng.payment.properties.AliPayProperties;
import com.qingfeng.payment.service.PayService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author shihangqi
 * @date 2019/11/21 - 21:06
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayService payService;

    @Autowired
    private AliPayProperties aliPayProperties;

    @PostMapping("/add")
    public boolean add(@RequestBody PayInfo dept){
        return payService.add(dept);
    }

    @GetMapping("/get/{id}")
    public PayInfo get(@PathVariable("id") Long id){
        return payService.get(id);
    }

    @GetMapping("/list")
    public List<PayInfo> list(){
        return payService.list();
    }


    @GetMapping("/pay")
    public String pay(HttpServletResponse httpResponse,AlipayBizParameters alipayBizParameters)throws ServletException, IOException {
//        AlipayBizParameters alipayBizParameters = new AlipayBizParameters();
//        BeanUtils.copyProperties(alipayParameters, alipayBizParameters);
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayProperties.getServerUrl(),aliPayProperties.getAppId(),aliPayProperties.getPrivateKey(),aliPayProperties.getFormat(),aliPayProperties.getCharset(),
                aliPayProperties.getAlipayPulicKey(),aliPayProperties.getSignType()); //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl(alipayBizParameters.getReturnUrl());
        alipayRequest.setNotifyUrl(alipayBizParameters.getNotifyUrl());//在公共参数中设置回跳和通知地址
        System.out.println(JSON.toJSON(alipayBizParameters).toString());
        /*"{" +
	        "    \"out_trade_no\":\"20150320010101001\"," +
	        "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
	        "    \"total_amount\":88.88," +
	        "    \"subject\":\"Iphone6 16G\"," +
	        "    \"body\":\"Iphone6 16G\"," +
	        "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
	        "    \"extend_params\":{" +
	        "    \"sys_service_provider_id\":\"2088511833207846\"" +
	        "    }"+
	        "  }"*/
       alipayRequest.setBizContent(
                JSON.toJSON(alipayBizParameters).toString());//填充业务参数
        String form="";
        try {
            AlipayTradePagePayResponse response = alipayClient.pageExecute(alipayRequest);
            form = response.getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
//	    httpResponse.setContentType("text/html;charset=UTF-8");
//	    httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
//	    httpResponse.getWriter().flush();
//	    httpResponse.getWriter().close();
        return form;
    }






    @PostMapping("/alipayNotify")
    public void alipayNotify(AlipayNotifyUrlParameters alipayNotifyUrlParameters){
        System.out.println("alipayNotifyUrlParameters:\t"+alipayNotifyUrlParameters);
    }


    @GetMapping("/alipayReturn")
    public void alipayReturn(AlipayReturnParameters alipayReturnParameters){
        System.out.println("alipayReturnParameters\t"+alipayReturnParameters);
    /*alipayReturnParameters   AlipayReturnParameters(charset=utf-8, out_trade_no=20150320010101010, method=alipay.trade.page.pay.return, total_amount=500.00, sign=MpP/YDQlNf/1GyhZ5BCS3nA8SrWOHXmZia2d1tnqi1zivC3vyy9414qWyF8EnPax4OunVjUsS0jJP5Rv95Gm2nS8dIKauRmzFw7d8ys9G9OuDwWe7yOqFhA4CCzCEacR38ucJ+D6+jzTAP1ekDEM6lV833huJ/9Ia2TbfSAc6ptQlliuQp+c6hUpBRu1r3XH5AceS5gyU8t2Cv4ZzZvTic9kY6mRYA0jTapZ020h21a2nSJGO+Uya5dNYgZbkvOm4QY8+OH37lNgBaMel78+LBvfOWwWM3WaFbHy36UB9inNh0BcANOyJbGQFNutgQWfkfjUDjJtZJTqwYbobyZVlQ==, trade_no=2019112222001433401000032953, auth_app_id=2016101100662295, version=1.0, app_id=2016101100662295, sign_type=RSA2, seller_id=2088102179110312, timestamp=2019-11-22 18:12:56)
     */
    }


//	http://www.shqblog.com/?
//	charset=utf-8&
//			out_trade_no=20150320010101002&
//			method=alipay.trade.page.pay.return&
//					total_amount=50.00&
//					sign=xwLZp4XCgd0dm9V23u6WyQDkEYFN%2B%2FqODI%2B95pBClRr8hVpeRwEP4Uzu%2Ffjxh3aVsKN9GKkyaM10flp8DPkGxrAswyQ0Eravo7DshMLl%2F4O8HKGYhxgL%2FykX5BvYuUzHpdm9KT8UhWT5zWESYYztuUkgbVwPMJ7dlGaR5f5NbHHjUvJCXIjtp4iqewi4cZPi%2FDuVCodjI6wNU8TAPFNKjy3eJzabeVWCTc73SvnZIxsjTPxWU6sn3jjbJHp3ZxXsUvz%2Fow4%2F4pNQ4OmimE1lwrhfpagUy6adBYo6D%2Be9ittpZmowRvAF0ild8cA5EftS6gTqN06QT%2Frs21%2FfZzZCkA%3D%3D&
//					trade_no=2019071522001433401000022172&
//					auth_app_id=2016101100662295&
//					version=1.0&
//					app_id=2016101100662295&
//					sign_type=RSA2&
//					seller_id=2088102179110312&
//					timestamp=2019-07-15+20%3A25%3A53

    //http://www.shqblog.com/?charset=utf-8&out_trade_no=20150320010101003&method=alipay.trade.page.pay.return&total_amount=500.00&sign=lUBx6y4JSLRFC820JZPTJ7ttt0Q8MqGTu64I2ZSAYVU5JMAqZRLenl5WHly02cGQuwc%2FP2QpGK5wgtEn5Ec2M712FzwODpIAF6NglGs1aD6YBwt6UXsQULPlFoHRcozDOzfDbVDnEdcCNeW9inXqhtVx97OBR9JjIuS5DZVhcBNdnL5NZgEhaIYS%2F%2FV18snGyELDsmDaXoxcPc6uskKTSsW2b%2Bpra8sJgHn0a3imqB8f1%2FtiBroKmFiwVa6hXbgdn64%2BMuMFPGC4Z58IDaLuVPRHHnJW68e7kbeVPKMBoabp%2BEBlYaU4Zc7sqULlmiR4rMsGbISDTeNvXjtQHjkigg%3D%3D&trade_no=2019112222001433401000029884&auth_app_id=2016101100662295&version=1.0&app_id=2016101100662295&sign_type=RSA2&seller_id=2088102179110312&timestamp=2019-11-22+16%3A09%3A53

//  "out_trade_no":"20150320010101002","product_code":"FAST_INSTANT_TRADE_PAY","total_amount":"50.0","subject":"Iphone6 64G","body":"Iphone6 64G","passback_params":"merchantBizType%3d3C%26merchantBizNo%3d2016010101111"

}
