package Controllers;

import DAO.Imple.AdminDao;
import Entity.Admin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {

    private final Admin admin;

    public AdminControllerTest() {
        admin = new Admin();
    }

    @Test
    void createAdmin() {
        admin.setNom("FADEL");
        admin.setPrenom("Youness");
        admin.setEmail("youness@gmail.com");
        admin.setPassword("youness");
        admin.setCentreId(12);
        assertNotNull(AdminController.CreateAdmin(
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