package com.acme.streamslambdas.exercises;

import com.acme.streamslambdas.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.acme.streamslambdas.Category.*;

public class TestData {

    public static final Product PENCILS = new Product(OFFICE, "Pencils", new BigDecimal("5.79"));
    public static final Product APPLES = new Product(FOOD, "Apples", new BigDecimal("1.29"));
    public static final Product PLATES = new Product(UTENSILS, "Plates", new BigDecimal("12.95"));
    public static final Product SPAGHETTI = new Product(FOOD, "Spaghetti", new BigDecimal("2.79"));
    public static final Product KNIVES = new Product(UTENSILS, "Knives", new BigDecimal("9.95"));
    public static final Product FORKS = new Product(UTENSILS, "Forks", new BigDecimal("14.95"));
    public static final Product DETERGENT = new Product(CLEANING, "Detergent", new BigDecimal("3.79"));

    private static final List<Product> PRODUCTS = List.of(PENCILS, APPLES, PLATES, SPAGHETTI, KNIVES, FORKS, DETERGENT);

    public static List<Product> getProducts() {
        return new ArrayList<>(PRODUCTS);
    }
}
