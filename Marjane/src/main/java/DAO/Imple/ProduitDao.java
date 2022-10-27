package DAO.Imple;

import DAO.BaseDao;
import Entity.Produit;
import org.hibernate.Session;

import java.util.ArrayList;

public class ProduitDao extends BaseDao<Produit> {

    @Override
    public void save(Produit entity) throws Exception {
        super.save(entity);
    }

    @Override
    public void update(Produit entity) throws Exception {
        super.update(entity);
    }

    @Override
    public void delete(Produit entity) throws Exception {
        super.delete(entity);
    }

    public ArrayList<Produit> getAllProduit()  {
        try {
            Session session = getCurrentSession();
            session.getTransaction();
            session.beginTransaction();
            ArrayList<Produit> produits = (ArrayList<Produit>) session.createQuery("SELECT p FROM Produit p", Produit.class).getResultList();
            session.getTransaction().commit();
            session.close();
            return produits;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
