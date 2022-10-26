package DAO;

import org.hibernate.Session;
import Services.SessionService;

public abstract class BaseDao<T> {

    public void save(T entity) throws Exception {
        Session session = getCurrentSession();
        session.getTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void update(T entity) throws Exception {
        Session session = getCurrentSession();
        session.getTransaction();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(T entity) throws Exception {
        Session session = getCurrentSession();
        session.getTransaction();
        session.remove(entity);
        session.getTransaction().commit();
        session.close();
    }

    protected Session getCurrentSession() {
        return SessionService.getCurrentSession();
    }

}
