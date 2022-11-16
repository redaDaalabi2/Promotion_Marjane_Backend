package Controllers;

import DAO.Imple.AdminDao;
import Entity.Admin;
import Entity.Produit;
import Services.Email;
import Services.Hash;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class AdminController {

    private static final AdminDao adminDao = new AdminDao();

    public static Boolean CreateAdmin(String nom, String prenom, String email, String password, Integer centre_id) {
        List<Admin> admin = adminDao.all();
        if(checkEmailExists(admin, email)){
            return null;
        } else {
            for (Entity.Admin admin1: admin){
                if(admin1.getCentreId().equals(centre_id))
                    return null;
            }
            Admin newAdmin = new Admin();
            newAdmin.setNom(nom);
            newAdmin.setPrenom(prenom);
            newAdmin.setEmail(email);
            newAdmin.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            newAdmin.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            newAdmin.setPassword(Hash.getHashedPassword(password));
            newAdmin.setCentreId(Math.toIntExact(centre_id));
            // sending email .....
            Email.sendMail(email, adminMessage(email));
            return adminDao.save(newAdmin) != null;
        }
    }

    public static Boolean checkEmailExists(List<Admin> admins, String email){
        for (Entity.Admin admin: admins){
            if (Objects.equals(email, admin.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public static String adminMessage(String email){
        return  "Bonjour, le compte a été créer avec succes. \n" +
                "\nEmail :   "+ email + "\n Voilà le lien pour login : http://localhost:8080/AdminLoginServlet";
    }

    public static List<Admin> countAllAdmin() {
        return adminDao.CountAdmin();
    }

}
