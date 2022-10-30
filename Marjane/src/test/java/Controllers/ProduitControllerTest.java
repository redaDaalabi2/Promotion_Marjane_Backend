package Controllers;

import DAO.Imple.ProduitDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProduitControllerTest {

    @Test
    void createProduit() {
        assertTrue(ProduitController.CreateProduit("BALLON", 50, 100.00, 2));
    }

    @Test
    void updateProduit() {
        assertTrue(ProduitController.UpdateProduit(12, "Ballon", 10, 99.99, 2));
    }

    @Test
    void deleteProduit() {
        assertTrue(ProduitController.DeleteProduit(12));
    }

    @Test
    void getAllProduits() {
        assertNotNull(new ProduitDao().all());
    }

    @Test
    void getProduitById() {
        assertNotNull(ProduitController.getProduitById(2));
    }
}