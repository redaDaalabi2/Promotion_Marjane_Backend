package Controllers;

import DAO.Imple.ResponsableRayonDao;
import Entity.ResponsapleRayon;
import Services.Email;
import Services.Hash;

import java.util.List;
import java.util.Objects;

public class ResponsableRayonController {

    private static final ResponsableRayonDao responsableRayonDao = new ResponsableRayonDao();

    public static Boolean CreateResponsableRayon(String nom, String prenom, String email, String password, Integer categorie_id){
        List<ResponsapleRayon> responsapleRayons = responsableRayonDao.all();
        if(checkEmailExists(responsapleRayons, email)){
            return null;
        } else {
            for (ResponsapleRayon responsapleRayon1: responsapleRayons){
                if(responsapleRayon1.getCategorieId().equals(categorie_id))
                    return null;
            }
            ResponsapleRayon newResponsapleRayon = new ResponsapleRayon();
            newResponsapleRayon.setNom(nom);
            newResponsapleRayon.setPrenom(prenom);
            newResponsapleRayon.setEmail(email);
            newResponsapleRayon.setPassword(Hash.getHashedPassword(password));
            newResponsapleRayon.setCategorieId(Math.toIntExact(categorie_id));
            newResponsapleRayon.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
            newResponsapleRayon.setUpdatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
            // sending email .....
            Email.sendMail(email, ResponsapleRayonMessage(email));
            return responsableRayonDao.save(newResponsapleRayon) != null;
        }
    }

    public static Boolean checkEmailExists(List<ResponsapleRayon> responsapleRayons, String email){
        for (ResponsapleRayon responsapleRayon: responsapleRayons){
            if (Objects.equals(email, responsapleRayon.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public static String ResponsapleRayonMessage(String email){
        return  "Bonjour, le compte a été créer avec succes. \n" +
                "\nEmail :   "+ email + "\n Voilà le lien pour login : http://localhost:8080/ResponsapleRayonLoginServlet";
    }

}
