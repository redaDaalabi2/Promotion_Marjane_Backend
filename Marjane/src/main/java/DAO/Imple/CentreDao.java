package DAO.Imple;

import DAO.BaseDao;
import Entity.Centre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Optional;
import java.util.List;

public class CentreDao implements BaseDao<Centre> {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public CentreDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
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
            entityManager.close();
        }
        return centre;
    }

    @Override
    public List<Centre> all() {
        return entityManager.createQuery("from Centre ", Centre.class).getResultList();
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
