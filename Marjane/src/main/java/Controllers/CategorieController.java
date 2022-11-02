package Controllers;

import DAO.Imple.CategorieDao;
import Entity.Categorie;

import java.util.List;

public class CategorieController {

    private static final CategorieDao categorieDao = new CategorieDao();

    public static List<Categorie> getAllCategorie() {
        return categorieDao.all();
    }

}
