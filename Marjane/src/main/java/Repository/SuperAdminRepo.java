package Repository;

import DAO.Imple.SuperadminDao;
import Services.Hash;

import java.sql.Timestamp;
import java.util.List;

public class SuperAdminRepo {

    public static final SuperadminDao superadminDao = new SuperadminDao();

    public static Boolean CreateSuperAdmin(String nom, String prenom, String email, String password) {
        List<Entity.Superadmin> superadmins = superadminDao.all();
        Entity.Superadmin newSuperAdmin = new Entity.Superadmin();
        newSuperAdmin.setNom(nom);
        newSuperAdmin.setPrenom(prenom);
        newSuperAdmin.setEmail(email);
        newSuperAdmin.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        newSuperAdmin.setPassword(Hash.getHashedPassword(password));
        return superadminDao.save(newSuperAdmin) != null;
    }
}
