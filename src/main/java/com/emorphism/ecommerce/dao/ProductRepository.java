package com.emorphism.ecommerce.dao;

import com.emorphism.ecommerce.entity.product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "product",path = "product")
@Repository
@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<product, Long> {
    Page<product> findByproduct(@Param("id") Long id, Pageable pageable);







}
