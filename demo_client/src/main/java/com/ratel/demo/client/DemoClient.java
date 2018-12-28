package com.ratel.demo.client;

import com.ratel.common.dto.RestResult;
import com.ratel.demo.dto.model.Demo;
import com.ratel.demo.dto.vo.DemoVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name= "demo")
public interface DemoClient {

    @PostMapping({"/demo/get"})
    RestResult<DemoVO> get(@RequestBody Demo var1);
}
