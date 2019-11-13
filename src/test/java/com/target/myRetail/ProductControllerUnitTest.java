package com.target.myRetail;

import com.google.gson.Gson;
import com.target.myRetail.controller.ProductController;
import com.target.myRetail.dto.CurrentPricePojo;
import com.target.myRetail.dto.ProductDto;
import com.target.myRetail.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductControllerUnitTest {

    MockMvc mockMvc;

    @Autowired
    ProductController productController;

    @MockBean
    ProductService productService;

    private ProductDto productDto;

    @Before
    public void setup(){
        this.mockMvc = standaloneSetup(this.productController).build();

        CurrentPricePojo currentPricePojo = new CurrentPricePojo(5001D, "USD");
        productDto = new ProductDto(12345L, "IceCream",currentPricePojo);
    }

    @Test
    public void testUpdateProductprice()throws Exception {
        when(productService.updateProductprice(any(ProductDto.class))).thenReturn(productDto);

        Gson gson = new Gson();
        String json = gson.toJson(productDto);

        this.mockMvc.perform(
                put("/api/v1/products/{productId}", "12345")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testgetProductByProductId()throws Exception {
        when(productService.getProductByProductId(any(Long.TYPE))).thenReturn(productDto);
        mockMvc.perform(get("/api/v1/products/{productId}","12345").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(12345)))
                .andExpect(jsonPath("$.currentPrice.value", is(5001.0)));

    }

    @Test
    public void testCreateNewProduct()throws Exception {
        when(productService.createNewProduct(any(ProductDto.class))).thenReturn(productDto);

        Gson gson = new Gson();
        String json = gson.toJson(productDto);

        this.mockMvc.perform(
                post("/api/v1/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(12345)))
                .andExpect(jsonPath("$.currentPrice.value", is(5001.0)));



    }
}
