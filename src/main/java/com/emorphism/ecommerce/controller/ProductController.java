package com.emorphism.ecommerce.controller;

import com.emorphism.ecommerce.dao.ProductRepository;
import com.emorphism.ecommerce.entity.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController

public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all-product")
    public List<product> findAllProduct(){
        List<product> list = productRepository.findAll();
        if(list!=null && !list.isEmpty()){
            list.stream().forEach(ac->{
                System.out.println("Name "+ac.getName());
            }

            );
        }else{
            System.out.println("No Product Found.");
        }
        return list;
    }
}
