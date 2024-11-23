package com.acme.streamslambdas.examples;

import com.acme.streamslambdas.ExampleData;
import com.acme.streamslambdas.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LambdasExample06 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
//        FileWriter writer = new FileWriter("products.txt");


        // According to forEach(), the lambda expression implements interface Consumer. The accept() method
        // of this interface does not declare any checked exceptions, so the lambda expression is not allowed
        // to throw any checked exceptions. We are forced to handle the IOException inside the lambda expression.

    }
}