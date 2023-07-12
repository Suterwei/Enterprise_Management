package com.project1.springboot.service;

import com.project1.springboot.entity.Product;
import com.project1.springboot.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public int save(Product product) {
        if(product.getId() == null) {
            return productMapper.insert(product);
        }else {
            return productMapper.update(product);
        }
    }
}
