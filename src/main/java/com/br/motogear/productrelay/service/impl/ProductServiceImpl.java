package com.br.motogear.productrelay.service.impl;


import br.com.motogear.product.ProductPost;
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

    @Value("${topic.producer}")
    private String topic;

    private final ProductMapper productMapper;

    private final KafkaTemplate<String, ProductPost> kafkaTemplate;


    public void post (ProductEntity product){
        var productPost = productMapper.entityToEvent(product);

        try {
            kafkaTemplate.send(topic, productPost);
            log.info("m=doSend, send product{} to kafka", productPost);
        } catch (Exception e) {
            log.error("M=doSend, message=error sending event, product={}, e={}", productPost, e);

        }

    }
}
