package es.fjdearcos.salestaxes.adapter;

import java.util.List;

class SimpleProductRepository {

    private final List<String> products;


    SimpleProductRepository(List<String> products) {
        this.products = products;
    }

    boolean containsProduct(String productName) {
        return products.stream().
                anyMatch(product -> productName.toLowerCase().contains(product));
    }
}
