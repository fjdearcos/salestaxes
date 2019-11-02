package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Product;
import es.fjdearcos.salestaxes.repository.BookProductsRepository;
import es.fjdearcos.salestaxes.repository.FoodProductsRepository;
import es.fjdearcos.salestaxes.repository.MedicalProductsRepository;

public class BasicSalesTax implements SalesTax {

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


    public float applyTax(Product product) {
        if (isExemptProduct(product)) {
            return 0;
        }
        return product.getPrice() * TAX_RATE;
    }

    private boolean isExemptProduct(Product product) {
        return bookProductsRepository.isBookProduct(product.getName()) ||
                foodProductsRepository.isFoodProduct(product.getName()) ||
                medicalProductsRepository.isMedicalProduct(product.getName());
    }
}
