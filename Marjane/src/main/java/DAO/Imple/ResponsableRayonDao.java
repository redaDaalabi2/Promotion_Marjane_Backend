package DAO.Imple;

import DAO.BaseDao;
import Entity.ResponsapleRayon;
import org.hibernate.Session;

import java.util.ArrayList;

public class ResponsableRayonDao extends BaseDao<ResponsapleRayon> {

    @Override
    public void save(ResponsapleRayon entity) throws Exception {
        super.save(entity);
    }

    @Override
    public void update(ResponsapleRayon entity) throws Exception {
        super.update(entity);
    }

    @Override
    public void delete(ResponsapleRayon entity) throws Exception {
        super.delete(entity);
    }

    public ArrayList<ResponsapleRayon> getAllResponsapleRayon()  {
        try {
            Session session = getCurrentSession();
            session.getTransaction();
            session.beginTransaction();
            ArrayList<ResponsapleRayon> responsapleRayons = (ArrayList<ResponsapleRayon>) session.createQuery("SELECT r FROM ResponsapleRayon r", ResponsapleRayon.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return responsapleRayons;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
