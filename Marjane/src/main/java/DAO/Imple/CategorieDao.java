package DAO.Imple;

import DAO.BaseDao;
import Entity.Categorie;
import org.hibernate.Session;

import java.util.ArrayList;

public class CategorieDao extends BaseDao<Categorie> {

    @Override
    public void save(Categorie entity) throws Exception {
        super.save(entity);
    }

    @Override
    public void update(Categorie entity) throws Exception {
        super.update(entity);
    }

    @Override
    public void delete(Categorie entity) throws Exception {
        super.delete(entity);
    }

    public ArrayList<Categorie> getAllCategorie()  {
        try {
            Session session = getCurrentSession();
            session.getTransaction();
            session.beginTransaction();
            ArrayList<Categorie> categories = (ArrayList<Categorie>) session.createQuery("SELECT c FROM Categorie c", Categorie.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return categories;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
