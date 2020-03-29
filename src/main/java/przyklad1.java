import model.Country;
import model.Order;
import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

public class przyklad1 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
     //   Order order = session.find(Order.class, 1);
        session.close();
    //    System.out.println(order.toString());
    }
}
