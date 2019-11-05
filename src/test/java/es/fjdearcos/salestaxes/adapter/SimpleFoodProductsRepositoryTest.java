package es.fjdearcos.salestaxes.adapter;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleFoodProductsRepositoryTest {

    private final SimpleFoodProductsRepository foodProductsRepository = new SimpleFoodProductsRepository();

    @Test
    public void testBoxOfChocolateIsFoodProduct() {
        assertTrue(foodProductsRepository.isFoodProduct("box of Chocolate"));
    }

    @Test
    public void testMusicCdIsNotFoodProduct() {
        assertFalse(foodProductsRepository.isFoodProduct("The Beatles music CD"));
    }
}