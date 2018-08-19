package com.ashu.model;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import org.springframework.data.jpa.domain.Specification;

/**
 * Product static meta model for {@link Specification}.
 * 
 * @author ashutosh
 *
 */
@StaticMetamodel(Product.class)
public class Product_ {

	public static volatile SingularAttribute<Product, Integer> id;
	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, String> color;
	public static volatile SingularAttribute<Product, Double> price;
	public static volatile SingularAttribute<Product, Date> addedDate;
}
