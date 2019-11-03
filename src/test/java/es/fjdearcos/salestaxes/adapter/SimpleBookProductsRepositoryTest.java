package es.fjdearcos.salestaxes.adapter;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleBookProductsRepositoryTest {

    private final SimpleBookProductsRepository bookProductsRepository = new SimpleBookProductsRepository();

    @Test
    public void testComicIsBookProduct() {
        assertTrue(bookProductsRepository.isBookProduct("Watchmen Comic"));
    }

    @Test
    public void testMusicCdIsNotBookProduct() {
        assertFalse(bookProductsRepository.isBookProduct("The Beatles music CD"));
    }
}