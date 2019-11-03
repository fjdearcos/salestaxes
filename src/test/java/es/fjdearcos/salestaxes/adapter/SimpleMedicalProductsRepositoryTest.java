package es.fjdearcos.salestaxes.adapter;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleMedicalProductsRepositoryTest {

    private final SimpleMedicalProductsRepository medicalProductsRepository = new SimpleMedicalProductsRepository();

    @Test
    public void testPillsAreMedicalProduct() {
        assertTrue(medicalProductsRepository.isMedicalProduct("Headache pills"));
    }

    @Test
    public void testMusicCdIsNotMedicalProduct() {
        assertFalse(medicalProductsRepository.isMedicalProduct("The Beatles music CD"));
    }
}