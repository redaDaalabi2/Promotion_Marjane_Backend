package DAO.Imple;

import DAO.BaseDao;
import Entity.Promotion;
import Services.Jpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.Optional;
import java.util.List;

public class PromotionDao implements BaseDao<Promotion>{

    Jpa jpa = Jpa.getInstance();
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public PromotionDao(){
        entityManagerFactory = jpa.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @Override
    public Optional<Promotion> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Promotion.class, id));
    }

    @Override
    public Promotion save(Promotion promotion) {
        try {
            entityTransaction.begin();
            if(promotion == null){
                entityManager.persist(null);
            }
            entityManager.merge(promotion);
            entityTransaction.commit();
            return promotion;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            jpa.shutdown();
        }
        return promotion;
    }

    @Override
    public List<Promotion> all() {
        return entityManager.createQuery("from Promotion ", Promotion.class).getResultList();
    }

    @Override
    public Boolean update(Long id, Promotion promotion) {
        try {
            entityTransaction.begin();
            String hql = "UPDATE Promotion set status = :status " + "WHERE id = :id";
            Query qry = entityManager.createQuery(hql);
            qry.setParameter("status", promotion.getStatus());
            qry.setParameter("id", id);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            jpa.shutdown();
        }
        return false;
    }

    @Override
    public Boolean delete(Long id) {
        try{
            entityTransaction.begin();
            Optional<Promotion> promotion = findById(id);
            promotion.ifPresent(pro -> entityManager.remove(promotion));
            entityTransaction.commit();
        }catch (Exception e){
            entityTransaction.rollback();
            return false;
        } finally {
            jpa.shutdown();
        }
        return true;
    }

}
