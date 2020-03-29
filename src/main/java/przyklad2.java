import model.Country;
import org.hibernate.Session;
import util.HibernateUtil;

public class przyklad2 {
    public static void main(String[] args) {

    }

    public static void usePersist(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country newCountry = new Country();
        newCountry.setName("India");
        newCountry.setAlias("IN");
        session.persist(newCountry);
        session.flush();
        session.close();
    }
}
