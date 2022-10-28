package Repository;

import DAO.Imple.AdminDao;
import DAO.Imple.ResponsableRayonDao;
import org.junit.jupiter.api.Test;
import Entity.ResponsapleRayon;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ResponsableRayonRepoTest {

    private final ResponsapleRayon responsablerayon;

    public ResponsableRayonRepoTest(){
        responsablerayon = new ResponsapleRayon();
    }

    @Test
    void createResponsableRayon() {
        responsablerayon.setNom("ZGARDAH");
        responsablerayon.setPrenom("Saad");
        responsablerayon.setEmail("saad@gmail.com");
        responsablerayon.setPassword("saad");
        responsablerayon.setCategorieId(5);
        assertNotNull(ResponsableRayonRepo.CreateResponsableRayon(
                responsablerayon.getNom(),
                responsablerayon.getPrenom(),
                responsablerayon.getEmail(),
                responsablerayon.getPassword(),
                responsablerayon.getCategorieId()
        ));
    }

    @Test
    void listAllResponsableRayon(){
        assertNotNull(new ResponsableRayonDao().all());
    }

}