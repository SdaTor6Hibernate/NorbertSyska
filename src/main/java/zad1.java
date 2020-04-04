import model.Address;
import model.User;
import service.GenericDAO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class zad1 {
    public static void main(String[] args) {
        GenericDAO<Address> addressDao = new GenericDAO<>(Address.class);
        GenericDAO<User> userDao = new GenericDAO<>(User.class);
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setFirstName("Harry");
        user1.setLastName("Potter");
        user1.setPassword("buraki");
        user1.setEmail("kochamvoldemorta123@horkruks.uk");
        user1.setBirthDate(LocalDateTime.now());
        user1.setAddress(addressDao.selectUser(5));

        User user2 = new User();
        user2.setFirstName("Johhny");
        user2.setLastName("Bravo");
        user2.setPassword("majtki");
        user2.setEmail("miesnie@duze.com");
        user2.setBirthDate(LocalDateTime.now());
        user2.setAddress(addressDao.selectUser(10));

        User user3 = new User();
        user3.setFirstName("Kame");
        user3.setLastName("Hame");
        user3.setPassword("Ha");
        user3.setEmail("goku@ssj3.jp");
        user3.setBirthDate(LocalDateTime.now());
        user3.setAddress(addressDao.selectUser(12));

        users.add(user1);
        users.add(user2);
        users.add(user3);

        users.forEach(userDao::createUser);

        users.forEach(user -> {
            user.setLastName(user.getLastName() + "- zakażony");
            userDao.updateUser(user);
        });

        userDao.deleteUser(users.get(0));
        userDao.deleteUser(users.get(users.size()-1));
    }
}
