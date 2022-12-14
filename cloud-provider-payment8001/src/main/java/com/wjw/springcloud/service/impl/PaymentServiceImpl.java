package com.wjw.springcloud.service.impl;

import com.wjw.springcloud.dao.PaymentDao;
import com.wjw.springcloud.entities.Payment;
import com.wjw.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wjw
 * @date 2022年12月14日 15:38
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
