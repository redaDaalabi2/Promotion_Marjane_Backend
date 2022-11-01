package Controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Entity.Superadmin;

class SuperAdminControllerTestController {

    private final Superadmin superadmin;

    public SuperAdminControllerTestController() {
        superadmin = new Superadmin();
    }

    @Test
    void createSuperAdmin() {
        superadmin.setNom("DAALABI");
        superadmin.setPrenom("Reda");
        superadmin.setEmail("reda@gmail.com");
        superadmin.setPassword("reda");
        assertNotNull(SuperAdminController.CreateSuperAdmin(
                superadmin.getNom(),
                superadmin.getPrenom(),
                superadmin.getEmail(),
                superadmin.getPassword()
        ));
    }
}