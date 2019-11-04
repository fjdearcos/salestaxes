package es.fjdearcos.salestaxes;


import es.fjdearcos.salestaxes.configuration.SalesTaxesConfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SalesTaxesApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SalesTaxesConfiguration.class);
        ctx.refresh();

        //ctx.getBean(PurchaseProcessorService.class);

        ctx.close();
    }
}
