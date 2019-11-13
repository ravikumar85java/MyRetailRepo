package com.target.myRetail.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentPricePojo {

    private Double value;

    private String currencyCode;

}
