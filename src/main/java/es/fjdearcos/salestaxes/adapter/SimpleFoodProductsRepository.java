package es.fjdearcos.salestaxes.adapter;

import es.fjdearcos.salestaxes.repository.FoodProductsRepository;

import java.util.Arrays;
import java.util.List;

public class SimpleFoodProductsRepository implements FoodProductsRepository {

    private static final List<String> FOOD_PRODUCTS = Arrays.asList("meat", "fish", "fruit", "chocolate");

    private final SimpleProductRepository simpleRepository;


    public SimpleFoodProductsRepository() {
        this.simpleRepository = new SimpleProductRepository(FOOD_PRODUCTS);
    }

    @Override
    public boolean isFoodProduct(String productName) {
        return simpleRepository.containsProduct(productName);
    }
}
