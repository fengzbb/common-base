package com.zbb.elasticsearch.transportclient.service.impl;

import com.zbb.elasticsearch.Elasticsearchbll;
import com.zbb.elasticsearch.transportclient.service.IEsTransportService;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 描述：
 *
 * @author bbzhou
 * @created 2019/1/22
 */
@Service
public class EsTransportServiceImpl implements IEsTransportService {

    @Autowired
    private Elasticsearchbll elasticsearchbll;

    @Override
    public TransportClient getTransportClient() {
        return null;
    }

    @Override
    public void insert(Map<String, String> modelData, String indexName, String indexType) {

    }

    @Override
    public void deleteById(String indexName, String indexType, Long id) {

    }

    @Override
    public void deleteByQuery(String indexName, BoolQueryBuilder queryBuilder) {

    }

    @Override
    public boolean existsIndex(String indexName) {
        return false;
    }

    @Override
    public void deleteIndex(String indexName) {

    }

    @Override
    public SearchHits search(QueryBuilder queryBuilder, String indexName, String indexType) {
        return null;
    }

    @Override
    public void updateById(String indexName, String indexType, Long id) {

    }
}
