package service;

import model.ModelClass;
import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

public class GenericDAO<T extends ModelClass> {
    final Class<T> classParameter;

    public GenericDAO(Class<T> classParameter) {
        this.classParameter = classParameter;
    }

    public void createUser(User newUser) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(newUser);
        session.flush();
        session.close();
    }

    public T selectUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        T userToSelect = session.find(classParameter, id);
        session.close();
        return userToSelect;
    }

    public void deleteUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(user);
        session.flush();
        session.close();
    }

    public void updateUser(User updateUser) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        if (session.find(classParameter, updateUser.getId()) != null) {
            session.merge(updateUser);
        }
        session.flush();
        session.close();

    }

}
