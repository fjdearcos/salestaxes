package es.fjdearcos.salestaxes.configuration;

import es.fjdearcos.salestaxes.adapter.*;
import es.fjdearcos.salestaxes.port.PurchaseInputParser;
import es.fjdearcos.salestaxes.port.ReceiptOutputPrinter;
import es.fjdearcos.salestaxes.repository.BookProductsRepository;
import es.fjdearcos.salestaxes.repository.FoodProductsRepository;
import es.fjdearcos.salestaxes.repository.MedicalProductsRepository;
import es.fjdearcos.salestaxes.service.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SalesTaxesConfiguration {

    @Bean
    public FoodProductsRepository foodProductsRepository() {
        return new SimpleFoodProductsRepository();
    }

    @Bean
    public BookProductsRepository bookProductsRepository() {
        return new SimpleBookProductsRepository();
    }

    @Bean
    public MedicalProductsRepository medicalProductsRepository() {
        return new SimpleMedicalProductsRepository();
    }

    @Bean
    public SalesTax basicSalesTax(BookProductsRepository bookProductsRepository,
                                  FoodProductsRepository foodProductsRepository,
                                  MedicalProductsRepository medicalProductsRepository) {
        return new BasicSalesTax(bookProductsRepository, foodProductsRepository, medicalProductsRepository);
    }

    @Bean
    public SalesTax importedGoodTax() {
        return new ImportedGoodTax();
    }

    @Bean
    public SalesTax activeTaxesComposite(SalesTax basicSalesTax, SalesTax importedGoodTax) {
        return new ActiveTaxesComposite(Arrays.asList(basicSalesTax, importedGoodTax));
    }

    @Bean
    public SalesTaxesService salesTaxesService(SalesTax activeTaxesComposite) {
        return new SalesTaxesServiceImpl(activeTaxesComposite);
    }

    @Bean
    public PurchaseInputParser purchaseInputParser() {
        return new ClearTextPurchaseInputParser();
    }

    @Bean
    public ReceiptOutputPrinter receiptOutputPrinter() {
        return new ClearTextReceiptOutputPrinter();
    }

    @Bean
    public PurchaseProcessorService purchaseProcessorService(PurchaseInputParser purchaseInputParser,
                                                             SalesTaxesService salesTaxesService,
                                                             ReceiptOutputPrinter receiptOutputPrinter) {
        return new PurchaseProcessorServiceImpl(purchaseInputParser, salesTaxesService, receiptOutputPrinter);
    }
}
