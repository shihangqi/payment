package com.qingfeng.payment.dao;

import com.qingfeng.payment.entity.PayInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author shihangqi
 * @date 2019/11/21 - 21:07
 */
@Mapper
public interface PayInfoMapper {

    public PayInfo findById(Long id);

    public List<PayInfo> findAll();

    public boolean addDept(PayInfo payInfo);

}
