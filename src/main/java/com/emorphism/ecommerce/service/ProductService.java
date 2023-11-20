package com.emorphism.ecommerce.service;

import com.emorphism.ecommerce.dao.ProductRepository;
import com.emorphism.ecommerce.entity.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository ProductRepository;

    public List<product> findAll(){

        return  ProductRepository.findAll();
    }
}
