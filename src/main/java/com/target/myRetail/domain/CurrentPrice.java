package com.target.myRetail.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "current_price")
@AllArgsConstructor
@NoArgsConstructor
public class CurrentPrice {

    @NonNull
    @Indexed(name = "retailProductId", unique = true)
    @Field("product_id")
    private long productId;

    @Field("value")
    private double value;

    @Field("currency_code")
    private String currencyCode;

}
