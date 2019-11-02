package es.fjdearcos.salestaxes.domain;

import lombok.Value;

@Value
public class Receipt {
    private Iterable<TaxedProduct> taxedProducts;
    private float taxes;
    private float total;

    public Receipt(Iterable<TaxedProduct> taxedProducts) {
        float productsTaxes = 0;
        float productsTotal = 0;
        for (TaxedProduct taxedProduct : taxedProducts) {
            productsTaxes += taxedProduct.getTaxes();
            productsTotal += taxedProduct.getTotalPrice();
        }
        this.taxedProducts = taxedProducts;
        this.taxes = productsTaxes;
        this.total = productsTotal;
    }
}
