package Services;

import jakarta.persistence.*;

public class Jpa {
    private static Jpa instance;

    private final EntityManagerFactory entityManagerFactory;

    private Jpa(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }

    public static synchronized Jpa getInstance(){
        return instance == null ? instance = new Jpa() : instance ;
    }

    public void shutdown(){
        if(entityManagerFactory != null){
            entityManagerFactory.close();
            instance = null;
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
