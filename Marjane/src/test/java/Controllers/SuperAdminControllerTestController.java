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
        superadmin.setPrenom("Hamza");
        superadmin.setEmail("hamza@gmail.com");
        superadmin.setPassword("hamza");
        assertNotNull(SuperAdminController.CreateSuperAdmin(
                superadmin.getNom(),
                superadmin.getPrenom(),
                superadmin.getEmail(),
                superadmin.getPassword()
        ));
    }
}