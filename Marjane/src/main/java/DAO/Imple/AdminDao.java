package DAO.Imple;

import DAO.BaseDao;
import Entity.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Optional;
import java.util.List;

public class AdminDao implements BaseDao<Admin> {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public AdminDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Admin.class, id));
    }

    @Override
    public Admin save(Admin admin) {
        try {
            entityTransaction.begin();
            if(admin == null){
                entityManager.persist(null);
            }
            entityManager.merge(admin);
            entityTransaction.commit();
            return admin;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<Admin> all() {
        return entityManager.createQuery("from Admin ", Admin.class).getResultList();
    }

    @Override
    public Boolean update(Long id, Admin admin) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        try{
            entityTransaction.begin();
            Optional<Admin> admin = findById(id);
            admin.ifPresent(a -> entityManager.remove(a));
            entityTransaction.commit();
        }catch (Exception e){
            entityTransaction.rollback();
            return false;
        } finally {
            entityManager.close();
        }
        return true;
    }

    public List<Admin> CountAdmin() {
        return entityManager.createQuery("SELECT COUNT(*) as counter FROM Admin", Admin.class).getResultList();
    }

}
