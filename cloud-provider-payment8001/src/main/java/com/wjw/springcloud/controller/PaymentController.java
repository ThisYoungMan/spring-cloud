package com.wjw.springcloud.controller;

import com.wjw.springcloud.entities.CommonResult;
import com.wjw.springcloud.entities.Payment;
import com.wjw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/add")
    public CommonResult add(@RequestBody Payment payment) {
        int result = paymentService.save(payment);
        log.info("********插入" + result + "条数据********");
        if (result > 0) {
            return new CommonResult(200, "操作成功, serverPort" + serverPort, result);
        } else {
            return new CommonResult(500, "操作失败", null);
        }
    }

    @GetMapping("/getInfo/{id}")
    public CommonResult getInfo(@PathVariable Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("********查询数据为：" + result + "********");
        return new CommonResult(200, "操作成功, serverPort" + serverPort, result);
    }

    @GetMapping("/discovery")
    public Object discovery() {

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("services: " + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }
}
