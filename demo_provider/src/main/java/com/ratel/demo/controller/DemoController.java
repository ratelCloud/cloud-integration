package com.ratel.demo.controller;

import com.ratel.common.dto.RestResult;
import com.ratel.common.exception.BusinessException;
import com.ratel.demo.dto.model.Demo;
import com.ratel.demo.dto.vo.DemoVO;
import com.ratel.demo.service.impl.DemoService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 类说明
 * <p>
 * 拼团推荐商品
 * @author niexiang
 * @version 1.0.0
 * @date 2018/12/10
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DemoService demoService;


    /**
    * getDemo
    * <p>
     * @param demo
    * @return
    * @author  niexiang
    * @version   1.0.0
    * @date  2018/12/18
    */
    @PostMapping("/get")
    @ApiOperation(value = "get",tags = "demo")
    public RestResult<DemoVO> get(@RequestBody @Validated Demo demo) {
        DemoVO demoVO = demoService.get(demo);
        if (demoVO == null) {
            logger.error("获取不到信息，param：{}",demo);
        	throw new BusinessException(1000);
        }
        return new RestResult(demoVO);
    }

    /**
     * getDemo
     * <p>
     * @param demo
     * @return
     * @author  niexiang
     * @version   1.0.0
     * @date  2018/12/18
     */
    @PostMapping("/getCache")
    @ApiOperation(value = "getCache",tags = "demo")
    public RestResult<DemoVO> getCache(@RequestBody @Validated Demo demo) {
        DemoVO demoVO = demoService.getCache(demo);
        return new RestResult(demoVO);
    }

}
