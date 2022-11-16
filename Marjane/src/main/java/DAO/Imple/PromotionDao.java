package DAO.Imple;

import DAO.BaseDao;
import Entity.Promotion;
import jakarta.persistence.*;

import java.util.Optional;
import java.util.List;

public class PromotionDao implements BaseDao<Promotion>{

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public PromotionDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @Override
    public Optional<Promotion> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Promotion.class, id));
    }

    public Promotion get(Integer id) {
        return entityManager.find(Promotion.class, id);
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
            entityManager.close();
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
            entityManager.merge(promotion);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            return false;
        }
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
            entityManager.close();
        }
        return true;
    }

}
