package Controllers;

import DAO.Imple.AdminDao;
import DAO.Imple.ResponsableRayonDao;
import DAO.Imple.SuperadminDao;
import Entity.Admin;
import Entity.Superadmin;
import Entity.ResponsapleRayon;
import Services.Hash;

import java.util.Objects;

public class AuthentificationController {

    public static Superadmin isSuperadminAuth(String email, String password){
        for (Superadmin superadmin: new SuperadminDao().all()){
            if(Objects.equals(superadmin.getEmail(), email) && Hash.verifiedPassword(superadmin.getPassword(), password)){
                return superadmin;
            }
        }
        return null;
    }

    public static Admin isAdminAuth(String email, String password){
        for (Admin admin: new AdminDao().all()){
            if(Objects.equals(admin.getEmail(), email) && Hash.verifiedPassword(admin.getPassword(), password)){
                return admin;
            }
        }
        return null;
    }

    public static ResponsapleRayon isResponsaplerayonAuth(String email, String password){
        for (ResponsapleRayon responsapleRayon: new ResponsableRayonDao().all()){
            if(Objects.equals(responsapleRayon.getEmail(), email) && Hash.verifiedPassword(responsapleRayon.getPassword(), password)){
                return responsapleRayon;
            }
        }
        return null;
    }

}
