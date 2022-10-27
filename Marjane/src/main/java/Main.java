import Entity.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Admin admin = new Admin();
            admin.setNom("DAALABI");
            admin.setPrenom("Reda");
            admin.setEmail("reda@gmail.com");
            admin.setPassword("reda");
            admin.setCentreId(9);
            admin.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            admin.setUpdatedAt(new Timestamp((System.currentTimeMillis())));
            entityManager.persist(admin);
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
