package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Product;

public class ActiveTaxesComposite implements SalesTax {

    private final Iterable<SalesTax> activeTaxes;


    public ActiveTaxesComposite(Iterable<SalesTax> activeTaxes) {
        this.activeTaxes = activeTaxes;
    }


    public float applyTax(Product product) {
        float totalTax = 0f;

        for (SalesTax tax: activeTaxes) {
            totalTax += tax.applyTax(product);
        }

        return totalTax;
    }
}
