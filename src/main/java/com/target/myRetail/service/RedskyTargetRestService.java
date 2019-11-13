package com.target.myRetail.service;

import com.target.myRetail.exception.MyRetailException;

public interface RedskyTargetRestService {
    String getProductName(long productId) throws MyRetailException;
}
