package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class BasicStreamsExample04 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // findFirst() will return an Optional with the first element in the stream, or an empty Optional
        // This is often used together with filter() to search for an element on arbitrary criteria


        // If you only want to check if the stream contains an element that matches your search criteria,
        // then you can use anyMatch(), which will return a boolean result
        // Unlike findFirst() and findAny(), you don't have to filter first - anyMatch() takes a Predicate

        // To check if all elements of the stream match specific criteria, use allMatch()

        // noneMatch() returns the opposite of anyMatch()

    }
}
