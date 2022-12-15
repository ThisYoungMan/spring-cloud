package com.wjw.springcloud.dao;

import com.wjw.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Description: mapper层
 *
 * @author wjw
 * @date 2022年12月14日 15:11
 */
@Mapper
public interface PaymentDao {

    int save(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
