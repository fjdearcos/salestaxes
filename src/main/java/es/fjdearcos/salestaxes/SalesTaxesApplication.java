package es.fjdearcos.salestaxes;

import es.fjdearcos.salestaxes.configuration.SalesTaxesConfiguration;
import es.fjdearcos.salestaxes.service.PurchaseProcessorService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class SalesTaxesApplication  implements Runnable {

    private final PurchaseProcessorService purchaseProcessorService;


    private SalesTaxesApplication(PurchaseProcessorService purchaseProcessorService) {
        this.purchaseProcessorService = purchaseProcessorService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input purchase:");
        StringBuilder purchaseDescription = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            purchaseDescription.append(line).append("\n");
        }
        String receiptDescription = purchaseProcessorService.process(purchaseDescription.toString());

        System.out.println("Output receipt:");
        System.out.println(receiptDescription);
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SalesTaxesConfiguration.class);
        ctx.refresh();

        PurchaseProcessorService purchaseProcessorService = ctx.getBean(PurchaseProcessorService.class);
        SalesTaxesApplication salesTaxesApplication = new SalesTaxesApplication(purchaseProcessorService);
        salesTaxesApplication.run();

        ctx.close();
    }
}
