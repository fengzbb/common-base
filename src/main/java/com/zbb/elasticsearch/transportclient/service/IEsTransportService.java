package com.zbb.elasticsearch.transportclient.service;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHits;

import java.util.Map;

/**
 * 描述：
 *  es  transportclient service
 * @author bbzhou
 * @created 2019/1/11
 */
public interface IEsTransportService {

    // 获取es transportClient 客户端
    TransportClient getTransportClient();

    // 插入数据
    void insert(Map<String, String> modelData, String indexName, String indexType);

    // 根据id做删除
    void deleteById(String indexName, String indexType, Long id);

    // 根据条件做删除
    void deleteByQuery(String indexName, BoolQueryBuilder queryBuilder);

    // 是否存在index
    boolean existsIndex(String indexName);

    // 删除index
    void deleteIndex(String indexName);

    // 查询
    SearchHits search(QueryBuilder queryBuilder, String indexName, String indexType);


    void updateById(String indexName, String indexType, Long id);

}
