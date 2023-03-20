package com.br.motogear.productrelay.service.impl;

import com.br.motogear.productrelay.ProductEvent;
import com.br.motogear.productrelay.entity.ProductEntity;
import com.br.motogear.productrelay.mapper.ProductMapper;
import com.br.motogear.productrelay.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

//    @Value("${topic.producer}")
//    private final String topic;

    private final ProductMapper productMapper;

    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;


    public void post (ProductEntity product){
        var productEvent = productMapper.entityToEvent(product);

        try {
            kafkaTemplate.send("product-post", productEvent);
            log.info("m=doSend, send product{} to kafka", productEvent);
        } catch (Exception e) {
            log.error("M=doSend, message=error sending event, product={}, e={}", productEvent, e);

        }

    }
}
