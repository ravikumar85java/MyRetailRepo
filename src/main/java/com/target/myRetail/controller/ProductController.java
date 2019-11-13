package com.target.myRetail.controller;

import com.google.gson.GsonBuilder;
import com.target.myRetail.dto.ProductDto;
import com.target.myRetail.exception.MyRetailException;
import com.target.myRetail.service.ProductService;
import com.target.myRetail.service.RedskyTargetRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class ProductController {

    @Autowired
    private
    ProductService productService;

    @Autowired
    RedskyTargetRestService redskyTargetRestService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductDto> getProductByProductId(
            @PathVariable("productId") long productId
    )throws MyRetailException {

        ProductDto productDto = productService.getProductByProductId(productId);
        if(productDto == null){
            throw new MyRetailException("Data not found for given input params", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<?> updateProductPrice(
            @RequestBody ProductDto productDto,
            @PathVariable("productId") long productId
    )throws MyRetailException {
        String response = null;
        if(productDto.getCurrentPrice().getValue()!=null){
            productDto.setProductId(productId);
            productService.updateProductprice(productDto);
            response = "{\"Response\":"+"Current price value "+productDto.getCurrentPrice().getValue()+" is Successfully updated"+"}";
        }else{
            throw new MyRetailException("CurrentPrice value cannot be null, Please provide value", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping("/productName/{productId}")
    public ResponseEntity<String> getProductNameBYId(
            @PathVariable("productId") long productId
    )throws MyRetailException {
        String response = null;
        String productName = redskyTargetRestService.getProductName(productId);
        if(productName == null){
            throw new MyRetailException("Data not found for given input params", HttpStatus.NOT_FOUND);
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        response = "{\"productName\":"+productName+"}";
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }


    @PostMapping("/products")
    public ResponseEntity<?> insertNewProduct(
            @RequestBody ProductDto productDto
    )throws MyRetailException {
        if(productDto.getCurrentPrice().getValue()!=null && productDto.getProductId()!=null){
            productDto = productService.createNewProduct(productDto);
        }else{
            throw new MyRetailException("ProductId and CurrentPrice value Both are required, Please provide value", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
}
