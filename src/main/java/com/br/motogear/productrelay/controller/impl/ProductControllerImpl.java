package com.br.motogear.productrelay.controller.impl;

import com.br.motogear.productrelay.controller.ProductController;
import com.br.motogear.productrelay.controller.dto.ProductRequest;
import com.br.motogear.productrelay.mapper.ProductMapper;
import com.br.motogear.productrelay.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;


    @PostMapping
    public ResponseEntity<Void> post(@Valid @RequestBody ProductRequest productRequest){
        productService.post(productMapper.requestToEntity(productRequest));

        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{name}")
                .buildAndExpand(productRequest.getName())
                .toUri();

        return ResponseEntity.created(uri).build();

    }
}
