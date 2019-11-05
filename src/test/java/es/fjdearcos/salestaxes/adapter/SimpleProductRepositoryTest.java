package es.fjdearcos.salestaxes.adapter;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleProductRepositoryTest {

    private static final List<String> PRODUCTS = Arrays.asList("book", "food", "pills");

    private final SimpleProductRepository simpleProductRepository = new SimpleProductRepository(PRODUCTS);

    @Test
    public void testContainsBookProduct() {
        assertTrue(simpleProductRepository.containsProduct("Harry Potter book"));
    }

    @Test
    public void testContainsMusicCD() {
        assertFalse(simpleProductRepository.containsProduct("The Beatles music CD"));
    }

    @Test
    public void testContainsIsNotCaseSensitive() {
        assertTrue(simpleProductRepository.containsProduct("HEADACHE PILLS"));
    }
}