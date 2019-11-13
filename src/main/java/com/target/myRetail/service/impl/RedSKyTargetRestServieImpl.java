package com.target.myRetail.service.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.target.myRetail.exception.MyRetailException;
import com.target.myRetail.service.RedskyTargetRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class RedSKyTargetRestServieImpl implements RedskyTargetRestService {


    @Value("${redsky.target.com.url}")
    String redSkyUrl;

    @Value("${redsky.target.com.excludesParam}")
    String excludesParam;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String getProductName(long productId) throws MyRetailException{
        ResponseEntity<String> resp = null;
        String url = redSkyUrl+"/"+productId;
        log.info(" Inside getProductName");
        String productName = null;
        try {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url);
            uriBuilder.queryParam("excludes", excludesParam);
            Map<String,String> queryParams  = new HashMap<>();
            queryParams.put("excludes", excludesParam);
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            HttpEntity<String> entity = new HttpEntity<>(headers);
            resp = restTemplate.exchange(
                    uriBuilder.build(queryParams), HttpMethod.GET, entity, String.class);
            if (resp != null && resp.getBody()!=null) {
                JsonObject jsonResponse = new JsonParser().parse(resp.getBody()).getAsJsonObject();
                productName = jsonResponse.getAsJsonObject("product").getAsJsonObject("item").getAsJsonObject("product_description").get("title").toString();
                productName = productName.replace("\"","");
                log.debug("\n------- Title :: " + productName + " --------");
            }
        }
        catch (RestClientException | JsonSyntaxException e) {
            log.error(" Exception occured while fetching produt name from remote url");
            throw new MyRetailException("Exception occured while fetching produt name from remote url", HttpStatus.INTERNAL_SERVER_ERROR, e.fillInStackTrace());
        }
        log.info(" Returning from getProductName");
        return productName;
    }
}
