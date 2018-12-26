package com.ratel.demo.service;

import com.ratel.demo.dao.DemoMapper;
import com.ratel.demo.dto.model.Demo;
import com.ratel.demo.dto.vo.DemoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DemoService implements IDemoService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public DemoVO get(Demo demo) {
        DemoVO demoVO = demoMapper.get(demo.getId());
        logger.info("demo:{}",demoVO);
        return demoVO;
    }
}
