package DAO.Imple;

import DAO.BaseDao;
import Entity.Promotion;
import org.hibernate.Session;

import java.util.ArrayList;

public class PromotionDao extends BaseDao<Promotion> {

    @Override
    public void save(Promotion entity) throws Exception {
        super.save(entity);
    }

    @Override
    public void update(Promotion entity) throws Exception {
        super.update(entity);
    }

    @Override
    public void delete(Promotion entity) throws Exception {
        super.delete(entity);
    }

    public ArrayList<Promotion> getAllPromotion()  {
        try {
            Session session = getCurrentSession();
            session.getTransaction();
            session.beginTransaction();
            ArrayList<Promotion> promotions = (ArrayList<Promotion>) session.createQuery("SELECT p FROM Promotion p", Promotion.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return promotions;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
