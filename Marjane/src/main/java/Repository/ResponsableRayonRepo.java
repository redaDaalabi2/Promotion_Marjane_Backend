package Repository;

import DAO.Imple.ResponsableRayonDao;
import Services.Email;
import Services.Hash;

import java.util.List;
import java.util.Objects;

public class ResponsableRayonRepo {

    private static final ResponsableRayonDao responsableRayonDao = new ResponsableRayonDao();

    public static Boolean CreateResponsableRayon(String nom, String prenom, String email, String password, Integer categorie_id){
        List<Entity.ResponsapleRayon> responsapleRayons = responsableRayonDao.all();
        if(checkEmailExists(responsapleRayons, email)){
            return null;
        } else {
            for (Entity.ResponsapleRayon responsapleRayon1: responsapleRayons){
                if(responsapleRayon1.getCategorieId().equals(categorie_id))
                    return null;
            }
            Entity.ResponsapleRayon newResponsapleRayon = new Entity.ResponsapleRayon();
            newResponsapleRayon.setNom(nom);
            newResponsapleRayon.setPrenom(prenom);
            newResponsapleRayon.setEmail(email);
            newResponsapleRayon.setPassword(Hash.getHashedPassword(password));
            newResponsapleRayon.setCategorieId(Math.toIntExact(categorie_id));
            newResponsapleRayon.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
            newResponsapleRayon.setUpdatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
            // sending email .....
            Email.sendMail(email, ResponsapleRayonMessage(email, password));
            return responsableRayonDao.save(newResponsapleRayon) != null;
        }
    }

    public static Boolean checkEmailExists(List<Entity.ResponsapleRayon> responsapleRayons, String email){
        for (Entity.ResponsapleRayon responsapleRayon: responsapleRayons){
            if (Objects.equals(email, responsapleRayon.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public static String ResponsapleRayonMessage(String email, String password){
        return  "Bonjour, le compte a été créer avec succes. \n" +
                "\n\tEmail :   "+ email + "\n\tPassword :   " + password;
    }

}
