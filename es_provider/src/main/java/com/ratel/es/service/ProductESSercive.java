/*
 * 天虹商场股份有限公司版权所有.
 */
package com.ratel.es.service;



import com.ratel.es.entity.ProductESDTO;

import java.util.List;

/**
 * 类说明
 * <p>
 *
 * @author niexiang
 * @version 1.0.0
 * @date 2018/12/24
 */
public interface ProductESSercive {
    void save(ProductESDTO entity);

    List<ProductESDTO> searchProduct(Integer pageNumber, Integer pageSize, String searchContent);
}
