package com.fcc.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fcc.api.dto.TestDto;
import com.fcc.api.service.DemoService;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoConsumerController
 * 消费者控制层
 * @author fcc
 * @date 2018/6/7
 */
@RestController
public class DemoConsumerController {

    @Reference(version = "${demo.service.version}",url = "dubbo://127.0.0.1:20880")
    private DemoService demoService;

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return demoService.sayHello(name);
    }

    @GetMapping("/performanceTest")
    public String performanceTest() {

        TestDto testDto=new TestDto("1","1","1","1","1","1","1","1","1","1");
        StopWatch stopWatch = new StopWatch();
        int testCount=1;
        for(int j=0;j<testCount;j++){
            stopWatch.start("任务"+j);
            for(int i=0;i<10000;i++) {
                demoService.performanceTest(testDto);
            }
            stopWatch.stop();
        }

        System.out.println(stopWatch.prettyPrint());
        System.out.println("1个线程处理10000次请求所需时间:"+stopWatch.getTotalTimeMillis()/testCount);


        return "success";
    }
}
