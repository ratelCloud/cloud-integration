/*
 * 天虹商场股份有限公司版权所有.
 */
package com.ratel.es.service.impl;

import com.ratel.es.entity.ProductESDTO;
import com.ratel.es.repository.ProductRepository;
import com.ratel.es.service.ProductESSercive;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类说明
 * <p>
 *
 * @author niexiang
 * @version 1.0.0
 * @date 2018/12/24
 */
@Service
public class ProductESServiceImpl implements ProductESSercive {

    /**  搜索模式
     * 权重分求和模式
     */
    private static final String SCORE_MODE_SUM = "sum";
    /**
     * 由于无相关性的分值默认为 1 ，设置权重分最小值为 10
     */
    private static final Float  MIN_SCORE = 10.0F;


    @Autowired
    private ProductRepository productRepository;




    @Override
    public void save(ProductESDTO entity){
        productRepository.save(entity);
    }


    @Override
    public List<ProductESDTO> searchProduct(Integer pageNumber, Integer pageSize, String searchContent){
        SearchQuery productSearchQuery = getProductSearchQuery(pageNumber, pageSize, searchContent);
        return productRepository.search(productSearchQuery).getContent();
    }

    /**
     * 根据搜索词构造搜索查询语句
     *
     * 代码流程：
     *      - 权重分查询
     *      - 短语匹配
     *      - 设置权重分最小值
     *      - 设置分页参数
     *
     * @param pageNumber 当前页码
     * @param pageSize 每页大小
     * @param searchContent 搜索内容
     * @return
     */
    private SearchQuery getProductSearchQuery(Integer pageNumber, Integer pageSize, String searchContent){
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.matchPhraseQuery("name", searchContent),
                        ScoreFunctionBuilders.weightFactorFunction(1000))
                .add(QueryBuilders.matchPhraseQuery("description", searchContent),
                        ScoreFunctionBuilders.weightFactorFunction(500))
                .scoreMode(SCORE_MODE_SUM).setMinScore(MIN_SCORE);

        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
    }

}
