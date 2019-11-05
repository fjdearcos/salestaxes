package es.fjdearcos.salestaxes.domain;

import lombok.Value;

@Value
public class TaxedProduct {
    private int quantity;
    private String name;
    private boolean imported;
    private float taxes;
    private float totalPrice;
}
