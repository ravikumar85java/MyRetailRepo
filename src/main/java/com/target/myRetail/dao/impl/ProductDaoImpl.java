package com.target.myRetail.dao.impl;

import com.mongodb.client.result.UpdateResult;
import com.target.myRetail.dao.ProductDao;
import com.target.myRetail.domain.CurrentPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public ProductDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public CurrentPrice updateCurrentPrice(CurrentPrice currentPrice) {

        Query query = new Query();
        Criteria criteria = Criteria.where("product_id").is(currentPrice.getProductId());
        query.addCriteria(criteria);

        Update update = new Update().set("value", currentPrice.getValue()).set("currency_code", currentPrice.getCurrencyCode());
        UpdateResult updateResult = mongoTemplate.upsert(query, update, "current_price");

        return null;
    }
}
