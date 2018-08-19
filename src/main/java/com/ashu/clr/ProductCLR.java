package com.ashu.clr;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashu.entity.Product;
import com.ashu.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Product command line runner.
 *
 * @author ashutosh
 *
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class ProductCLR implements CommandLineRunner {

	private final ProductService productService;

	@Override
	public void run(String... args) throws Exception {

		List<Product> teas = productService.getBySpecificationQuery("tea", 35, null, null);
		log.info("number of expensive teas was found : " + teas.size());

		List<Product> allTeas = productService.getBySpecificationQuery("tea", 0, null, null);
		log.info("Some teas were found  : " + allTeas.size());

		List<Product> expensiveProducts = productService.getBySpecificationQuery(null, 40, null, null);
		log.info("coffee and tea should be present in expensive product's query : \n" + expensiveProducts);

		List<Product> gold = productService.getBySpecificationQuery("golden", 0, null, null);
		log.info("They're no gold in the database: " + gold.size());

		Date startDate = Date.from(Instant.parse("2014-05-03T10:15:30.00Z"));
		Date endDate = Date.from(Instant.parse("2014-07-03T10:15:30.00Z"));
		List<Product> products = productService.getBySpecificationQuery(null, 0, startDate, endDate);
		log.info("Product found added from {} - {} : \n {} ", startDate, endDate, products);

		List<Product> allProducts = productService.getBySpecificationQuery(null, 0, null, null);
		log.info("All Products {} ", allProducts.size());

		List<Product> productsThatNameContainsE = productService.searchByExampleQuery("e");
		log.info("Products that contains `e` \n {} ", productsThatNameContainsE);
	}

}
