package com.target.myRetail.dao;

import com.target.myRetail.domain.CurrentPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrencyPriceRepo extends MongoRepository<CurrentPrice,String>{
    CurrentPrice findByProductId(long productId);
}