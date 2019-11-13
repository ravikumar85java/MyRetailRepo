package com.target.myRetail.service.impl;

import com.target.myRetail.dao.CurrencyPriceRepo;
import com.target.myRetail.dao.ProductDao;
import com.target.myRetail.domain.CurrentPrice;
import com.target.myRetail.dto.CurrentPricePojo;
import com.target.myRetail.dto.ProductDto;
import com.target.myRetail.exception.MyRetailException;
import com.target.myRetail.service.ProductService;
import com.target.myRetail.service.RedskyTargetRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    CurrencyPriceRepo currencyPriceRepo;

    @Autowired
    ProductDao productDao;

    @Autowired
    RedskyTargetRestService redskyTargetRestService;

    @Override
    public ProductDto getProductByProductId(long productId) {
        CurrentPrice currentPrice = currencyPriceRepo.findByProductId(productId);

        CurrentPricePojo currentPricePojo = null;
        ProductDto productDto = constructProductDto(productId, currentPrice);
        return productDto;
    }

    private ProductDto constructProductDto(long productId, CurrentPrice currentPrice) {
        CurrentPricePojo currentPricePojo;
        ProductDto productDto = null;
        if(currentPrice!=null){
            productDto = new ProductDto();
            productDto.setProductId(currentPrice.getProductId());

            currentPricePojo = new CurrentPricePojo();
            currentPricePojo.setValue(currentPrice.getValue());
            currentPricePojo.setCurrencyCode(currentPrice.getCurrencyCode());
            productDto.setCurrentPrice(currentPricePojo);
            try{
                String productName = redskyTargetRestService.getProductName(productId);
                productDto.setProductName(productName);
            }catch(Exception ex){
                log.error(ex.getMessage(), ex.fillInStackTrace());
                productDto.setProductName(null);
            }
        }
        return productDto;
    }

    @Override
    public ProductDto updateProductprice(ProductDto productDto) throws MyRetailException {
        CurrentPrice currentPrice = currencyPriceRepo.findByProductId(productDto.getProductId());
        if(currentPrice==null){
            throw new MyRetailException("ProductId is not present in System");
        }
        currentPrice.setValue(productDto.getCurrentPrice().getValue());
        currentPrice.setCurrencyCode(productDto.getCurrentPrice().getCurrencyCode());
        productDao.updateCurrentPrice(currentPrice);
        return productDto;
    }

    @Override
    public ProductDto createNewProduct(ProductDto productDto) {
        CurrentPrice currentPrice = new CurrentPrice(productDto.getProductId(),productDto.getCurrentPrice().getValue(),productDto.getCurrentPrice().getCurrencyCode());
        currentPrice = currencyPriceRepo.save(currentPrice);
        productDto = constructProductDto(productDto.getProductId(), currentPrice);
        return productDto;

    }
}
