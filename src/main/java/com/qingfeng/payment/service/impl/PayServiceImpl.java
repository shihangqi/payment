package com.qingfeng.payment.service.impl;

import com.qingfeng.payment.dao.PayInfoMapper;
import com.qingfeng.payment.entity.PayInfo;
import com.qingfeng.payment.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shihangqi
 * @date 2019/11/22 - 8:57
 */
@Service
public class PayServiceImpl  implements PayService {

    @Autowired
    private PayInfoMapper payInfoMapper;

    @Override
    public boolean add(PayInfo payInfo) {
        return payInfoMapper.addDept(payInfo);
    }

    @Override
    public PayInfo get(Long id) {
        return payInfoMapper.findById(id);
    }

    @Override
    public List<PayInfo> list() {
        return payInfoMapper.findAll();
    }


}
