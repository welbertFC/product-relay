package com.br.motogear.productrelay.controller;

import com.br.motogear.productrelay.controller.dto.ProductRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Product", description = "product manager")
public interface ProductController {

     @Operation(summary = "post product",
             description = "send product to queue")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "201", description = "create product"),
             @ApiResponse(responseCode = "404", description = "failed to create product"),
             @ApiResponse(responseCode = "500", description = "internal server error")
     })
     ResponseEntity<Void> post(ProductRequest productRequest);
}
