package com.wjw.springcloud.controller;

import com.wjw.springcloud.entities.CommonResult;
import com.wjw.springcloud.entities.Payment;
import com.wjw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wjw
 * @date 2022年12月14日 15:41
 */
@RestController
@RequestMapping("/")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/add")
    public CommonResult add(Payment payment) {
        int result = paymentService.save(payment);
        log.info("********插入" + result + "条数据********");
        if (result > 0) {
            return new CommonResult(200, "操作成功", result);
        } else {
            return new CommonResult(500, "操作失败", null);
        }
    }

    @GetMapping("/getInfo/{id}")
    public CommonResult getInfo(@PathVariable Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("********查询数据为：" + result + "********");
        return new CommonResult(200, "操作成功", result);
    }

}
