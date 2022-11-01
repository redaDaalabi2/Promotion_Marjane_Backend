package Controllers;

import DAO.Imple.SuperadminDao;
import Entity.Superadmin;
import Services.Hash;

import java.sql.Timestamp;
import java.util.List;

public class SuperAdminController {

    public static final SuperadminDao superadminDao = new SuperadminDao();

    public static Boolean CreateSuperAdmin(String nom, String prenom, String email, String password) {
        Superadmin newSuperAdmin = new Superadmin();
        newSuperAdmin.setNom(nom);
        newSuperAdmin.setPrenom(prenom);
        newSuperAdmin.setEmail(email);
        newSuperAdmin.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        newSuperAdmin.setPassword(Hash.getHashedPassword(password));
        return superadminDao.save(newSuperAdmin) != null;
    }

}
