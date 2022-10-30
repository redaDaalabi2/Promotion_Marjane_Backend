package Controllers;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AuthentificationControllerTest {

    @Test
    void isSuperadminAuth() {
        assertNotNull(AuthentificationController.isSuperadminAuth("reda@gmail.com", "reda"));
    }

    @Test
    void isAdminAuth() {
        assertNotNull(AuthentificationController.isAdminAuth("wassi@gmail.com", "wassi"));
    }

    @Test
    void isResponsaplerayonAuth() {
        assertNotNull(AuthentificationController.isResponsaplerayonAuth("saad@gmail.com", "saad"));
    }
}