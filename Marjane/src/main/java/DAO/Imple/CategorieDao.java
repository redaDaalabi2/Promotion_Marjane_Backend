package DAO.Imple;

import DAO.BaseDao;
import Entity.Categorie;
import Entity.Centre;
import Services.Jpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.util.Optional;
import java.util.List;

public class CategorieDao implements BaseDao<Categorie>{

    Jpa jpa = Jpa.getInstance();
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public CategorieDao(){
        entityManagerFactory = jpa.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @Override
    public Optional<Categorie> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Categorie.class,id));
    }

    @Override
    public Categorie save(Categorie categorie) {
        try {
            entityTransaction.begin();
            if(categorie == null){
                entityManager.persist(null);
            }
            entityManager.merge(categorie);
            entityTransaction.commit();
            return categorie;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            jpa.shutdown();
        }
        return categorie;
    }

    @Override
    public List<Categorie> all() {
        return entityManager.createQuery("from Categorie ", Categorie.class).getResultList();
    }

    @Override
    public Boolean update(Long id, Categorie categorie) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        try{
            entityTransaction.begin();
            Optional<Categorie> categorie = findById(id);
            categorie.ifPresent(c -> entityManager.remove(c));
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
