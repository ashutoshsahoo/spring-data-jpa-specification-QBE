package com.ashu.practice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * Product entity.
 *
 * @author ashutosh
 */
@Entity
@Table(name = "PRODUCTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private static final String PRODUCT_SEQUENCE = "PRODUCT_ID_SEQUENCE";

    @Serial
    private static final long serialVersionUID = -8492192607665559978L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = PRODUCT_SEQUENCE)
    @SequenceGenerator(name = PRODUCT_SEQUENCE, sequenceName = PRODUCT_SEQUENCE, allocationSize = 1)
    private Integer id;
    private String name;
    private String color;
    private double price;
    private Date addedDate;

}
