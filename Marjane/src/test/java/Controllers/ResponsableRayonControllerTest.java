package Controllers;

import DAO.Imple.ResponsableRayonDao;
import org.junit.jupiter.api.Test;
import Entity.ResponsapleRayon;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ResponsableRayonControllerTest {

    private final ResponsapleRayon responsablerayon;

    public ResponsableRayonControllerTest(){
        responsablerayon = new ResponsapleRayon();
    }

    @Test
    void createResponsableRayon() {
        responsablerayon.setNom("GOUDI");
        responsablerayon.setPrenom("Youssef");
        responsablerayon.setEmail("youssef@gmail.com");
        responsablerayon.setPassword("youssef");
        responsablerayon.setCategorieId(7);
        assertNotNull(ResponsableRayonController.CreateResponsableRayon(
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