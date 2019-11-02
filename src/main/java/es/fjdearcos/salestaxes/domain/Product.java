package es.fjdearcos.salestaxes.domain;

import lombok.Value;

@Value
public class Product {
    private int quantity;
    private String name;
    private float price;
    private boolean imported;
}
