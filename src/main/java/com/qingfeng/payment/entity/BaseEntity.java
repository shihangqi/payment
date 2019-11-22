package com.qingfeng.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shihangqi
 * @date 2019/11/21 - 21:00
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 2054813493011812469L;

    private ID id;
    private Date createTime = new Date();
    private Date updateTime = new Date();

}
