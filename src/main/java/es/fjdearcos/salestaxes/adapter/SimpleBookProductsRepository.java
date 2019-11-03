package es.fjdearcos.salestaxes.adapter;

import es.fjdearcos.salestaxes.repository.BookProductsRepository;

import java.util.Arrays;
import java.util.List;

public class SimpleBookProductsRepository implements BookProductsRepository {

    private static final List<String> BOOK_PRODUCTS = Arrays.asList("book", "novel", "comic");

    private final SimpleProductRepository simpleRepository;


    public SimpleBookProductsRepository() {
        this.simpleRepository = new SimpleProductRepository(BOOK_PRODUCTS);
    }

    @Override
    public boolean isBookProduct(String productName) {
        return simpleRepository.containsProduct(productName);
    }
}
