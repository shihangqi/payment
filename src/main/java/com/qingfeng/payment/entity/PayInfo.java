package com.qingfeng.payment.entity;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author shihangqi
 * @date 2019/11/21 - 21:01
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)


public class PayInfo extends BaseEntity<Long>{
    /**
     *
     */
    private static final long serialVersionUID = 315034024793503175L;
    private String payNumber;
    private String information;
    private String note;
}
