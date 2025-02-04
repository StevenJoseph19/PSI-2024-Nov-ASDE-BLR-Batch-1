package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedStreamsExample06 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("5.00");

        // Partitioning is a special case of grouping, where the classifier function is a Predicate
        // and the stream elements are divided into two groups.
        // The result is a map with two entries, with boolean values 'true' and 'false' as keys.
        Map<Boolean, List<Product>> partitionedProducts = products.stream()
                .collect(Collectors.partitioningBy(product -> product.getPrice().compareTo(priceLimit) < 0));

        System.out.println("Cheap products: ");
        partitionedProducts.get(true).forEach(System.out::println);

        System.out.println("Expensive products: ");
        partitionedProducts.get(false).forEach(System.out::println);
    }
}
