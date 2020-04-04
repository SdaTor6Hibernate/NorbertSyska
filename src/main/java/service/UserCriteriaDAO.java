package service;

import org.hibernate.Query;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

public class UserCriteriaDAO {
    private Session session;

    void openSession() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public List<User> findAllBornBetween(LocalDateTime date1,LocalDateTime date2) {
        openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);
        query.select(userRoot).where(builder.between(userRoot.get("birthDate"),date1,date2));
        TypedQuery<User> q = session.createQuery(query);
        List<User> usersList = q.getResultList();
        session.close();
        return usersList;
    }
}
