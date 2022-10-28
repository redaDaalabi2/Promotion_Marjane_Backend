package DAO.Imple;

import DAO.BaseDao;
import Entity.Centre;
import Services.Jpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.util.Optional;
import java.util.List;

public class CentreDao implements BaseDao<Centre> {

    Jpa jpa = Jpa.getInstance();
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public CentreDao(){
        entityManagerFactory = jpa.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }
    @Override
    public Optional<Centre> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Centre save(Centre centre) {
        try {
            entityTransaction.begin();
            if(centre == null){
                entityManager.persist(null);
            }
            entityManager.merge(centre);
            entityTransaction.commit();
            return centre;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            jpa.shutdown();
        }
        return centre;
    }

    @Override
    public List<Centre> all() {
        return null;
    }

    @Override
    public Boolean update(Long id, Centre centre) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

}
