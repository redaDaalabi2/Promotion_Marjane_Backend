import Entity.Categorie;
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
            Categorie categorie = new Categorie();
            categorie.setNomCategorie("aaaaaa");
            categorie.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            categorie.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            entityManager.persist(categorie);
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
