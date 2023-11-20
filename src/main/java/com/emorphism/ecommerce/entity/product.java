package com.emorphism.ecommerce.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="product")
@Data
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToMany(mappedBy = "id")
    private Set<ProductCategory> productcategory;

    @Column(name = "sku")
    private String sku;
    @Column(name = "name")
    private String name;
    @Column(name = "descriptions")
    private String descriptions;
    @Column(name = "unit_price")
    private BigDecimal unitprice;
    @Column(name = "image_url")
    private String imageurl;
    @Column(name = "active")
    private boolean active;
    @Column(name = "units_in_stock")
    private int unitsInStock;
    @Column(name = "date_created")
    @CreationTimestamp
    private Date datecreated;
    @Column(name = "last_Updated")
    @UpdateTimestamp
    private Date lastUpdated;
}



