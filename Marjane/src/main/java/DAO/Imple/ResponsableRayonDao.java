package DAO.Imple;

import DAO.BaseDao;
import Entity.ResponsapleRayon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Optional;
import java.util.List;

public class ResponsableRayonDao implements BaseDao<ResponsapleRayon> {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public ResponsableRayonDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @Override
    public Optional<ResponsapleRayon> findById(Long id) {
        return Optional.ofNullable(entityManager.find(ResponsapleRayon.class, id));
    }

    @Override
    public ResponsapleRayon save(ResponsapleRayon responsapleRayon) {
        try {
            entityTransaction.begin();
            if(responsapleRayon == null){
                entityManager.persist(null);
            }
            entityManager.merge(responsapleRayon);
            entityTransaction.commit();
            return responsapleRayon;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<ResponsapleRayon> all() {
        return entityManager.createQuery("from ResponsapleRayon ", ResponsapleRayon.class).getResultList();
    }

    @Override
    public Boolean update(Long id, ResponsapleRayon responsapleRayon) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        try{
            entityTransaction.begin();
            Optional<ResponsapleRayon> responsapleRayon = findById(id);
            responsapleRayon.ifPresent(rr -> entityManager.remove(rr));
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
