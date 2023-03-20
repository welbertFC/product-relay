package com.br.motogear.productrelay.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity implements Serializable {

    private String name;
    private String description;

    private BigDecimal price;

}
