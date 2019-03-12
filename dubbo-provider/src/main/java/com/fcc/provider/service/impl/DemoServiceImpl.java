package com.fcc.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fcc.api.dto.TestDto;
import com.fcc.api.service.DemoService;

/**
 * DemoServiceImpl
 * 服务提供类
 * @author fcc
 * @date 2018/6/7
 */
@Service(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }

    @Override
    public void performanceTest(TestDto testDto) {
//        System.out.println(testDto);
    }
}
