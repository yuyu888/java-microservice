package com.myproject.feignapi.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "testservice", path="/test-service/api/test", contextId = "test-service-test", decode404 = true)
public interface ServiceAPiTestServiceTest {
    @RequestMapping("/feignapi-test")
    public String feignApiTest();
}
