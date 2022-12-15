package com.wjw.springcloud.controller;

import com.wjw.springcloud.entities.CommonResult;
import com.wjw.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wjw
 * @date 2022年12月14日 22:08
 */
@RestController
@Slf4j
@RequestMapping("/")
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:8001/payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/add")
    public CommonResult<Payment> add(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/add", payment, CommonResult.class);
    }

    @GetMapping("/consumer/getInfo/{id}")
    public CommonResult<Payment> getInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/getInfo/" + id, CommonResult.class);
    }
}
