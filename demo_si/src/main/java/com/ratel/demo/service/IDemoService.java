package com.ratel.demo.service;

import com.ratel.demo.dto.model.Demo;
import com.ratel.demo.dto.vo.DemoVO;

/**
 * 类说明
 * <p>
 *
 * @author niexiang
 * @version 1.0.0
 * @date 2018/12/26
 */
public interface IDemoService {

    DemoVO get(Demo demo);
}
