package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Product;

abstract class SalesTaxTemplate implements SalesTax {
    @Override
    public float applyTax(Product product) {
        if (isExempt(product)) {
            return 0.0f;
        }
        return roundToNearestFiveCents(product.getPrice() * getTaxRate());
    }

    abstract boolean isExempt(Product product);

    private float roundToNearestFiveCents(float price) {
        return (float) Math.ceil(price * 20.0) / 20.0f;
    }

    abstract float getTaxRate();
}
