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
        admin.setNom("DAALABI");
        admin.setPrenom("Reda");
        admin.setEmail("reda@gmail.com");
        admin.setPassword("reda");
        admin.setCentreId(10);
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