package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.Category;
import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.util.List;
import java.util.stream.Collectors;

public class BasicStreamsExample05 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // This is not a good way to get the elements of a stream into a list

        // Using collect() you can collect the elements of a stream into a collection
        // Class Collectors contains factory methods for collectors that create different kinds of collections


        // Collectors.joining(...) returns a collector to reduce stream elements into a string

    }
}
