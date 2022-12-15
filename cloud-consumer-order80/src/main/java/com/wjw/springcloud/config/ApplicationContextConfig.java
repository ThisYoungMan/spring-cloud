package com.wjw.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Description: RestTemplate配置类
 *
 * @author wjw
 * @date 2022年12月14日 22:12
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced   // 开启负载均衡配置
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
