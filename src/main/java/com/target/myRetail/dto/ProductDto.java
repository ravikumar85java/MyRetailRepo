package com.target.myRetail.dto;

import com.target.myRetail.domain.CurrentPrice;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long productId;

    private String productName;

    private CurrentPricePojo currentPrice;
}
