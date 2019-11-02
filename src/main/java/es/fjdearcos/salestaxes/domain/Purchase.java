package es.fjdearcos.salestaxes.domain;

import lombok.Value;

@Value
public class Purchase {
    private Iterable<Product> products;
}
