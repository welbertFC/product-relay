package com.br.motogear.productrelay.mapper;

import com.br.motogear.productrelay.ProductEvent;
import com.br.motogear.productrelay.controller.dto.ProductRequest;
import com.br.motogear.productrelay.entity.ProductEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-20T22:03:33-0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductEntity requestToEntity(ProductRequest input) {
        if ( input == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setName( input.getName() );
        productEntity.setDescription( input.getDescription() );
        productEntity.setPrice( input.getPrice() );

        return productEntity;
    }

    @Override
    public ProductEvent entityToEvent(ProductEntity input) {
        if ( input == null ) {
            return null;
        }

        ProductEvent.Builder productEvent = ProductEvent.newBuilder();

        productEvent.setName( input.getName() );
        productEvent.setDescription( input.getDescription() );
        if ( input.getPrice() != null ) {
            productEvent.setPrice( input.getPrice().doubleValue() );
        }

        return productEvent.build();
    }
}
