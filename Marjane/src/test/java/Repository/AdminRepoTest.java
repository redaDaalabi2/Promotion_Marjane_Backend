package Repository;

import DAO.Imple.AdminDao;
import org.junit.jupiter.api.Test;
import Entity.Admin;

import static org.junit.jupiter.api.Assertions.*;

class AdminRepoTest {

    private final Admin admin;

    public AdminRepoTest() {
        admin = new Admin();
    }

    @Test
    void createAdmin() {
        admin.setNom("GHRABLA");
        admin.setPrenom("Kamal");
        admin.setEmail("kamal@gmail.com");
        admin.setPassword("kamal");
        admin.setCentreId(11);
        assertNotNull(AdminRepo.CreateAdmin(
                admin.getNom(),
                admin.getPrenom(),
                admin.getEmail(),
                admin.getPassword(),
                admin.getCentreId()
        ));
    }

    @Test
    void listAllAdmin(){
        assertNotNull(new AdminDao().all());
    }

}