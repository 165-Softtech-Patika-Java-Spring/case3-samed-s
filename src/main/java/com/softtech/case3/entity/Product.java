package com.softtech.case3.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product {
    @Id
    @SequenceGenerator(name = "Product", sequenceName = "PRODUCT_ID_SEQ")
    @GeneratedValue(generator = "Product")
    private Long id;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "PRICE", precision = 19, scale = 2)
    private BigDecimal price;
}
