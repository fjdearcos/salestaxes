package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Product;
import es.fjdearcos.salestaxes.repository.BookProductsRepository;
import es.fjdearcos.salestaxes.repository.FoodProductsRepository;
import es.fjdearcos.salestaxes.repository.MedicalProductsRepository;

public class BasicSalesTax extends SalesTaxTemplate {

    private static final float TAX_RATE = 0.10f;


    private final BookProductsRepository bookProductsRepository;
    private final FoodProductsRepository foodProductsRepository;
    private final MedicalProductsRepository medicalProductsRepository;


    public BasicSalesTax(BookProductsRepository bookProductsRepository, FoodProductsRepository foodProductsRepository,
                         MedicalProductsRepository medicalProductsRepository) {
        this.bookProductsRepository = bookProductsRepository;
        this.foodProductsRepository = foodProductsRepository;
        this.medicalProductsRepository = medicalProductsRepository;
    }

    @Override
    boolean isExempt(Product product) {
        return bookProductsRepository.isBookProduct(product.getName()) ||
                foodProductsRepository.isFoodProduct(product.getName()) ||
                medicalProductsRepository.isMedicalProduct(product.getName());
    }

    @Override
    float getTaxRate() {
        return TAX_RATE;
    }
}
