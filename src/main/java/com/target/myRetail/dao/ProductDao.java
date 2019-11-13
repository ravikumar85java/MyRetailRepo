package com.target.myRetail.dao;

import com.target.myRetail.domain.CurrentPrice;
import com.target.myRetail.dto.ProductDto;

public interface ProductDao {

    CurrentPrice updateCurrentPrice(CurrentPrice currentPrice);
}
