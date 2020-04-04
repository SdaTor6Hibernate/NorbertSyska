import model.User;
import service.UserCriteriaDAO;

import java.time.LocalDateTime;
import java.util.List;

public class zad3 {

    //Dopisz kolejne implementacje metod do klasy UserCriteriaDao i wyświetl ich rezultaty
// 1. findAllBornBetween()
// 2. findByEmail()
// 3. findAllByCityName(); tak aby obiekty user zawierały jednocześnie informacje o adresie
// 4. findAllByCountryAlias(); tak aby obiekty user zawierały informacje zawarte w tabeli user
// 5. TRUDNE findAllWhoBoughtProduct();
    public static void main(String[] args) {
        UserCriteriaDAO userCriteriaDAO = new UserCriteriaDAO();
        List<User> users = userCriteriaDAO.findAllBornBetween(LocalDateTime.now(), LocalDateTime.now().minusYears(1));
        users.forEach(user -> System.out.println(user.toString()));

    }
}
