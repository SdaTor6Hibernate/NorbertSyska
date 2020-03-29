package service;

import model.Address;
import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

import java.time.LocalDateTime;

public class UserDAO {
    private static void createUser(String firstName, String lastName, Address address, String email, String password, LocalDateTime birthDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setAddress(address);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setBirthDate(birthDate);
        session.persist(newUser);
        session.flush();
        session.close();
    }
}
