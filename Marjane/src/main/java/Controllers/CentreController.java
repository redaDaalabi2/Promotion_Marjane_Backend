package Controllers;

import DAO.Imple.CentreDao;
import Entity.Centre;

import java.sql.Timestamp;
import java.util.List;

public class CentreController {

    private static final CentreDao centreDao = new CentreDao();

    public static List<Centre> getAllCentres() {
        return centreDao.all();
    }

    public static Boolean CreateCentre(String nom_centre, String ville_centre) {
        Centre centre = new Centre();
        centre.setNomCentre(nom_centre);
        centre.setVilleCentre(ville_centre);
        centre.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return centreDao.save(centre) != null;
    }

}
