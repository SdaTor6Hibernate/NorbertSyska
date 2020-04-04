import model.Order;
import service.OrderDAO;

import java.time.LocalDateTime;
import java.util.List;

public class zad2 {
    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
        List<Order> orders =orderDAO.findafterDate(LocalDateTime.of(2020,1,29,15,35,05));
        orders.forEach(order -> System.out.println(order.toString()));
    }
}
