package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Product;

public class ImportedGoodTax implements SalesTax {

    private static final float TAX_RATE = 0.05f;


    public float applyTax(Product product) {
        if (product.isImported()) {
            return product.getPrice() * TAX_RATE;
        }
        return 0.0f;
    }
}
