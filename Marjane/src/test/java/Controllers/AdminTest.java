package Controllers;

import DAO.Imple.AdminDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    private final Entity.Admin admin;

    public AdminTest() {
        admin = new Entity.Admin();
    }

    @Test
    void createAdmin() {
        admin.setNom("FADEL");
        admin.setPrenom("Youness");
        admin.setEmail("youness@gmail.com");
        admin.setPassword("youness");
        admin.setCentreId(12);
        assertNotNull(Admin.CreateAdmin(
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