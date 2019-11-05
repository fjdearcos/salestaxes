package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Product;

public class ImportedGoodTax extends SalesTaxTemplate {

    private static final float TAX_RATE = 0.05f;

    @Override
    boolean isExempt(Product product) {
        return !product.isImported();
    }

    @Override
    float getTaxRate() {
        return TAX_RATE;
    }
}
