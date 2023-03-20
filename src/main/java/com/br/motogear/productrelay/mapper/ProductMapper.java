package com.br.motogear.productrelay.mapper;

import com.br.motogear.productrelay.ProductEvent;
import com.br.motogear.productrelay.controller.dto.ProductRequest;
import com.br.motogear.productrelay.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {


    ProductEntity requestToEntity(ProductRequest input);

    ProductEvent entityToEvent(ProductEntity input);
}
