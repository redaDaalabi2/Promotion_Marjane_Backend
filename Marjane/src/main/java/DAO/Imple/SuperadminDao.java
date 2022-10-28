package DAO.Imple;

import DAO.BaseDao;
import Entity.Superadmin;
import Services.Jpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.util.Optional;
import java.util.List;

public class SuperadminDao implements BaseDao<Superadmin> {

    Jpa jpa = Jpa.getInstance();
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public SuperadminDao(){
        entityManagerFactory = jpa.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @Override
    public Optional<Superadmin> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Superadmin save(Superadmin superadmin) {
        try {
            entityTransaction.begin();
            if(superadmin == null){
                entityManager.persist(null);
            }
            entityManager.merge(superadmin);
            entityTransaction.commit();
            return superadmin;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            jpa.shutdown();
        }
        return superadmin;
    }

    @Override
    public List<Superadmin> all() {
        return entityManager.createQuery("from Superadmin ", Superadmin.class).getResultList();
    }

    @Override
    public Boolean update(Long id, Superadmin superadmin) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

}
