package Controllers;

import DAO.Imple.ProduitDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProduitTest {

    @Test
    void createProduit() {
        assertTrue(Produit.CreateProduit("BALLON", 50, 100.00, 2));
    }

    @Test
    void updateProduit() {
        assertTrue(Produit.UpdateProduit(7, "Ballon", 10, 99.99, 2));
    }

    @Test
    void deleteProduit() {
        assertTrue(Produit.DeleteProduit(7));
    }

    @Test
    void getAllProduits() {
        assertNotNull(new ProduitDao().all());
    }

    @Test
    void getProduitById() {
        assertNotNull(Produit.getProduitById(2));
    }
}