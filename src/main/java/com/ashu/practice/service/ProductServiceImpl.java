package com.ashu.practice.service;

import com.ashu.practice.model.Product;
import com.ashu.practice.repository.ProductRepository;
import com.ashu.practice.repository.ProductSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Default implementation for {@link ProductService}.
 *
 * @author ashutosh
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    /**
     * Product repository.
     */
    private final ProductRepository productsRepo;

    @Override
    public List<Product> getBySpecificationQuery(String name, int price, Date startDate, Date endDate) {
        return productsRepo.findAll(ProductSpecifications.withDynamicQuery(name, price, startDate, endDate));
    }

    @Override
    public List<Product> searchByExampleQuery(String namePattern) {
        Product product = new Product();
        product.setName(namePattern);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnorePaths("price")
                .withMatcher("name", GenericPropertyMatcher::contains);
        Example<Product> example = Example.of(product, matcher);
        return productsRepo.findAll(example);
    }

    @Override
    public List<Product> findAll() {
        return productsRepo.findAll();
    }

}
