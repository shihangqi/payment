package com.qingfeng.payment.service;

import com.qingfeng.payment.entity.PayInfo;

import java.util.List;

/**
 * @author shihangqi
 * @date 2019/11/22 - 8:57
 */
public interface PayService {

    public boolean add(PayInfo dept);

    public PayInfo get(Long id);

    public List<PayInfo> list();

}
