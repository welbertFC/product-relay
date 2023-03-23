package com.br.motogear.productrelay.mapper;

import br.com.motogear.product.ProductPost;
import com.br.motogear.productrelay.controller.dto.ProductRequest;
import com.br.motogear.productrelay.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {


    ProductEntity requestToEntity(ProductRequest input);

    ProductPost entityToEvent(ProductEntity input);
}
