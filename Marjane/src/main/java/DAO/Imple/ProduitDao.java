package DAO.Imple;

import DAO.BaseDao;
import Entity.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Optional;
import java.util.List;

public class ProduitDao implements BaseDao<Produit> {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public ProduitDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @Override
    public Optional<Produit> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Produit.class, id));
    }

    @Override
    public Produit save(Produit produit) {
        try {
            entityTransaction.begin();
            if(produit == null){
                entityManager.persist(null);
            }
            entityManager.merge(produit);
            entityTransaction.commit();
            return produit;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<Produit> all() {
        return entityManager.createQuery("from Produit ", Produit.class).getResultList();
    }

    @Override
    public Boolean update(Long id, Produit produit) {
        try {
            entityTransaction.begin();
            entityManager.merge(produit);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Boolean delete(Long id) {
        try{
            entityTransaction.begin();
            Optional<Produit> produit = findById(id);
            produit.ifPresent(pr -> entityManager.remove(pr));
            entityTransaction.commit();
        }catch (Exception e){
            entityTransaction.rollback();
            return false;
        } finally {
            entityManager.close();
        }
        return true;
    }

}
