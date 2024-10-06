package com.ashu.practice.repository;

import com.ashu.practice.model.Product;
import com.ashu.practice.model.Product_;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Provides {@link Specification}s for product repository.
 *
 * @author ashutosh
 */
public class ProductSpecifications {

    private ProductSpecifications() {
        // No implementation required.
    }

    /**
     * Specification used to construct dynamic query based on JPA Criteria API.
     *
     * @param price Demanded price (must be bigger than 0 to be taken for the query)
     * @param name  Product's name (must be not null to be taken for the query)
     * @return Specification to use with JpaSpecificationExecutor
     */
    public static Specification<Product> withDynamicQuery(final String name, final int price, final Date startDate,
                                                          final Date endDate) {
        return (product, query, builder) -> {
//			if (price == 0 && name == null) {
//				throw new IllegalStateException("At least one parameter should be provided to construct complex query");
//			}
            List<Predicate> predicates = new ArrayList<>();
            if (price > 0) {
                predicates.add(builder.and(builder.gt(product.get(Product_.price), price)));
            }
            if (name != null) {
                predicates.add(builder.and(builder.equal(product.get(Product_.name), name.toLowerCase())));
            }

            if (startDate != null && endDate != null) {
                predicates.add(builder.and(builder.greaterThanOrEqualTo(product.get(Product_.addedDate), startDate)));
                predicates.add(builder.and(builder.lessThanOrEqualTo(product.get(Product_.addedDate), endDate)));
            }
            Predicate[] predicatesArray = new Predicate[predicates.size()];
            return builder.and(predicates.toArray(predicatesArray));
        };
    }

}
