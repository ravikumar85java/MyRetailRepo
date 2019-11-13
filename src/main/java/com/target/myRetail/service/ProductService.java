package com.target.myRetail.service;

import com.target.myRetail.dto.ProductDto;
import com.target.myRetail.exception.MyRetailException;

public interface ProductService {
    ProductDto getProductByProductId(long productId) throws MyRetailException;

    ProductDto updateProductprice(ProductDto productDto)throws MyRetailException;

    ProductDto createNewProduct(ProductDto productDto)throws MyRetailException;

}
