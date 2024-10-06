package com.ashu.practice.service;

import com.ashu.practice.model.Product;

import java.util.Date;
import java.util.List;

/**
 * Product service.
 *
 * @author ashutosh
 */
public interface ProductService {

    /**
     * Get products for provided properties.
     *
     * @param name      name
     * @param price     price
     * @param startDate start date
     * @param endDate   end date
     * @return list of products
     * @see <a href=
     * "https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#specifications">Specifications</a>
     */
    List<Product> getBySpecificationQuery(String name, int price, Date startDate, Date endDate);

    /**
     * Search products for provided name pattern.
     *
     * @param namePattern name pattern
     * @return list of products
     * @see <a href=
     * "https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#query-by-example">Query
     * by Example</a>
     */
    List<Product> searchByExampleQuery(String namePattern);


    /**
     * Find all products
     *
     * @return products list
     */
    List<Product> findAll();

}
