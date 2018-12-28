package com.ratel.demo.dao;

import com.ratel.demo.dto.vo.DemoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 类
 * <p>
 *
 * @author niexiang
 * @version 1.0.0
 * @date 2018/12/24
 */
@Mapper
public interface DemoMapper {


    /**
     * getById
     * @param id
     * @return
     */
    @Select("select id,product_name productName,group_price groupPrice from product where id = #{id}")
    DemoVO get(@Param("id") Long id);

}
