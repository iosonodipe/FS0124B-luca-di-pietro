package program;

import classes.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static Long customerId = 1L;
    public static Long productId = 1L;
    public static Long orderId = 1L;

    public static void main(String[] args) {
        var productsList = new ArrayList<Product>();
        var customersList = new ArrayList<Customer>();
        var ordersList = new ArrayList<Order>();

        var c1 = new Customer("Luca", CustomerTier.ADMIN);
        var c2 = new Customer("Mario", CustomerTier.CLIENT);
        var c3 = new Customer("Lidia", CustomerTier.GUEST);
        var c4 = new Customer("Michele", CustomerTier.ADMIN);
        Collections.addAll(customersList, c1, c2, c3, c4);

        var p1 = new Product("Prodotto 1", ProductCategory.BOOKS, 101.50);
        var p2 = new Product("Prodotto 2", ProductCategory.BOOKS, 99.00);
        var p3 = new Product("Prodotto 3", ProductCategory.BOOKS, 17.50);
        var p4 = new Product("Prodotto 4", ProductCategory.BOOKS, 139.90);
        var p5 = new Product("Prodotto 5", ProductCategory.BABY, 80.00);
        var p6 = new Product("Prodotto 6", ProductCategory.BABY, 60.00);
        var p7 = new Product("Prodotto 7", ProductCategory.BABY, 29.00);
        var p8 = new Product("Prodotto 8", ProductCategory.BOYS, 15.00);
        var p9 = new Product("Prodotto 9", ProductCategory.BOYS, 25.00);
        var p10 = new Product("Prodotto 10", ProductCategory.BOYS, 30.00);
        Collections.addAll(productsList, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);

        var o1 = new Order(OrderStatus.AWAITING_SHIPMENT, LocalDate.of(2021, 2, 5), LocalDate.of(2021, 2, 10), List.of(p1, p2), c1);
        var o2 = new Order(OrderStatus.ORDER_PACKED, LocalDate.of(2021, 3, 8), LocalDate.of(2021, 3, 12), List.of(p3, p4), c4);
        var o3 = new Order(OrderStatus.SHIPPED, LocalDate.of(2021, 5, 10), LocalDate.of(2021, 5, 15), List.of(p5, p6), c2);
        var o4 = new Order(OrderStatus.DELIVERED, LocalDate.of(2021, 4, 1), LocalDate.of(2021, 4, 4), List.of(p7, p8, p9), c1);
        Collections.addAll(ordersList, o1, o2, o3, o4);

        //Esercizio 1
        productsList.stream()
                .filter(product -> product.getCategory() == ProductCategory.BOOKS && product.getPrice() > 100)
                .forEach(System.out::println);

        ordersList.stream()
                .map(order -> order.getProducts());

    }
}