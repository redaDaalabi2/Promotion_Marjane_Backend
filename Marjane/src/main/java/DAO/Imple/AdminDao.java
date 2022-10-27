package DAO.Imple;

import DAO.BaseDao;
import Entity.Admin;
import org.hibernate.Session;

import java.util.ArrayList;

public class AdminDao extends BaseDao<Admin> {

    @Override
    public void save(Admin entity) throws Exception {
        super.save(entity);
    }

    @Override
    public void update(Admin entity) throws Exception {
        super.update(entity);
    }

    @Override
    public void delete(Admin entity) throws Exception {
        super.delete(entity);
    }

    public ArrayList<Admin> getAllAdmin()  {
        try {
            Session session = getCurrentSession();
            session.getTransaction();
            session.beginTransaction();
            ArrayList<Admin> admins = (ArrayList<Admin>) session.createQuery("SELECT a FROM Admin a", Admin.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return admins;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
