package es.fjdearcos.salestaxes.domain;

import lombok.Value;

@Value
public class Receipt {
    private Iterable<TaxedProduct> taxedProducts;
    private float taxes;
    private float total;

    public Receipt(Iterable<TaxedProduct> taxedProducts) {
        float taxes = 0, total = 0;
        for (TaxedProduct taxedProduct : taxedProducts) {
            taxes += taxedProduct.getTaxes();
            total += taxedProduct.getTotalPrice();
        }
        this.taxedProducts = taxedProducts;
        this.taxes = taxes;
        this.total = total;
    }
}
