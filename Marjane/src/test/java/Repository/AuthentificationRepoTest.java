package Repository;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AuthentificationRepoTest {

    @Test
    void isSuperadminAuth() {
        assertNotNull(AuthentificationRepo.isSuperadminAuth("reda@gmail.com", "reda"));
    }

    @Test
    void isAdminAuth() {
        assertNotNull(AuthentificationRepo.isAdminAuth("wassi@gmail.com", "wassi"));
    }

    @Test
    void isResponsaplerayonAuth() {
        assertNotNull(AuthentificationRepo.isResponsaplerayonAuth("saad@gmail.com", "saad"));
    }
}