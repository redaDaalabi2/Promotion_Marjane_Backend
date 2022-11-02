package Controllers;

import DAO.Imple.CentreDao;
import Entity.Centre;

import java.util.List;

public class CentreController {

    private static final CentreDao centreDao = new CentreDao();

    public static List<Centre> getAllCentres() {
        return centreDao.all();
    }
}
