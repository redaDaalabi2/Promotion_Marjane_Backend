package DAO.Imple;

import DAO.BaseDao;
import Entity.Admin;
import Entity.Centre;
import org.hibernate.Session;

import java.util.ArrayList;

public class CentreDao extends BaseDao<Centre> {

    @Override
    public void save(Centre entity) throws Exception {
        super.save(entity);
    }

    @Override
    public void update(Centre entity) throws Exception {
        super.update(entity);
    }

    @Override
    public void delete(Centre entity) throws Exception {
        super.delete(entity);
    }

    public ArrayList<Centre> getAllCenters()  {
        try {
            Session session = getCurrentSession();
            session.getTransaction();
            session.beginTransaction();
            ArrayList<Centre> centres = (ArrayList<Centre>) session.createQuery("SELECT c FROM Centre c", Centre.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return centres;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Centre getOneCentre(long Id) {
        return null;
    }

    public Centre getCentreById(long id){
        return null;
    }

}
