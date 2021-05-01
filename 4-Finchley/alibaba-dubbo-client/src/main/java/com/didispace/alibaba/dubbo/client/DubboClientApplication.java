package com.didispace.alibaba.dubbo.client;

import com.didispace.alibaba.dubbo.api.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableDiscoveryClient
@SpringBootApplication
public class DubboClientApplication {
    /**
     * 启动方式
     * -Djava.net.preferIPv4Stack=true -Dcsp.sentinel.api.port=8001 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=alibaba-dubbo-server
     * -Djava.net.preferIPv4Stack=true -Dcsp.sentinel.api.port=8002 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=alibaba-dubbo-client
     */

    public static void main(String[] args) {
        SpringApplication.run(DubboClientApplication.class, args);
    }

    @Slf4j
    @RestController
    static class TestController {

        @Reference
        HelloService helloService;

        @GetMapping("/test")
        public String test() {
            return helloService.hello("didispace.com");
        }
    }

}