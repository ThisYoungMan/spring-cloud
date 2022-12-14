package com.wjw.springcloud.service;

import com.wjw.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 *
 * @author wjw
 * @date 2022年12月14日 15:36
 */
public interface PaymentService {

    int save(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
