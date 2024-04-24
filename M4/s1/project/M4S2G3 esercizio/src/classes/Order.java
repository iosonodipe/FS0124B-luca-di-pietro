package classes;

import program.Main;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private Long id;
    private OrderStatus status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    public Order(OrderStatus status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.id = Main.orderId;
        Main.orderId += 1;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return String.format("Ordine %d > Stato: %s, Data ordine: %s, Data consegna: %s, Prodotti: %s, Cliente: %s]", id, status, orderDate, deliveryDate, products, customer);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
