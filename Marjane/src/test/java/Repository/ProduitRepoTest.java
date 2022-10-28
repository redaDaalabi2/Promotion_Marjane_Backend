package Repository;

import DAO.Imple.ProduitDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProduitRepoTest {

    @Test
    void createProduit() {
        assertTrue(ProduitRepo.CreateProduit("BALLON", 50, 100.00, 2));
    }

    @Test
    void updateProduit() {
        assertTrue(ProduitRepo.UpdateProduit(2, "DELL Latitude 5410", 10, 15000.00, 8));
    }

    @Test
    void deleteProduit() {
        assertTrue(ProduitRepo.DeleteProduit(6));
    }

    @Test
    void getAllProduits() {
        assertNotNull(new ProduitDao().all());
    }

    @Test
    void getProduitById() {
        assertNotNull(ProduitRepo.getProduitById(2));
    }
}