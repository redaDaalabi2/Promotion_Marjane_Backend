package Controllers;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AuthentificationTest {

    @Test
    void isSuperadminAuth() {
        assertNotNull(Authentification.isSuperadminAuth("reda@gmail.com", "reda"));
    }

    @Test
    void isAdminAuth() {
        assertNotNull(Authentification.isAdminAuth("wassi@gmail.com", "wassi"));
    }

    @Test
    void isResponsaplerayonAuth() {
        assertNotNull(Authentification.isResponsaplerayonAuth("saad@gmail.com", "saad"));
    }
}