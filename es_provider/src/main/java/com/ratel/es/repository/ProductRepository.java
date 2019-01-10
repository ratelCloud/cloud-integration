/*
 * 天虹商场股份有限公司版权所有.
 */
package com.ratel.es.repository;

import com.ratel.es.entity.ProductESDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * 类说明
 * <p>
 *
 * @author niexiang
 * @version 1.0.0
 * @date 2018/12/24
 */
@Repository
public interface ProductRepository extends ElasticsearchRepository<ProductESDTO,Long> {
}
