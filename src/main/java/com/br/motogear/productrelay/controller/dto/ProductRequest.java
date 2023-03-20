package com.br.motogear.productrelay.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Schema(description = "model to create product")
public class ProductRequest implements Serializable {

    @NotBlank
    @Size(max = 100, min = 3, message = "size must be between 3 and 100")
//    @Schema(description = "name of product", example = "Product Test")
    private String name;

    @NotBlank
    @Size(min = 5, max = 500, message = "size must be between 5 and 500")
//    @Schema(description = "description of product", example = "This is a product")
    private String description;

    @NotNull
//    @Schema(description = "price of product", example = "12.00")
    private BigDecimal price;
}
