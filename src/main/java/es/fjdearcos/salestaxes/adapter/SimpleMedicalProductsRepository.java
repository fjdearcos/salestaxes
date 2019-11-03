package es.fjdearcos.salestaxes.adapter;

import es.fjdearcos.salestaxes.repository.MedicalProductsRepository;

import java.util.Arrays;
import java.util.List;

public class SimpleMedicalProductsRepository implements MedicalProductsRepository {

    private static final List<String> MEDICAL_PRODUCTS = Arrays.asList("medicine", "drug", "medicament", "pill");

    private final SimpleProductRepository simpleRepository;


    public SimpleMedicalProductsRepository() {
        this.simpleRepository = new SimpleProductRepository(MEDICAL_PRODUCTS);
    }

    @Override
    public boolean isMedicalProduct(String productName) {
        return simpleRepository.containsProduct(productName);
    }
}
