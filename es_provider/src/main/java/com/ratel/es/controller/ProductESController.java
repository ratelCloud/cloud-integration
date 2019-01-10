package com.ratel.es.controller;

import com.ratel.common.dto.RestResult;
import com.ratel.es.entity.ProductESDTO;
import com.ratel.es.service.ProductESSercive;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 类说明
 * <p>
 * 拼团推荐商品
 * @author niexiang
 * @version 1.0.0
 * @date 2018/12/10
 */
@RestController
@RequestMapping(value = "/es")
public class ProductESController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductESSercive productESSercive;


    /**
    * getDemo
    * <p>
     * @param content
    * @return
    * @author  niexiang
    * @version   1.0.0
    * @date  2018/12/18
    */
    @PostMapping("/get")
    @ApiOperation(value = "get",tags = "product")
    public RestResult<List<ProductESDTO>> get(@RequestBody String content) {
        List<ProductESDTO> productESDTOS = productESSercive.searchProduct(1, 10, content);
        return new RestResult(productESDTOS);
    }


}
