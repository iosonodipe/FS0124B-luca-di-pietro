package classes;

import program.Main;

public class Customer {
    private Long id;
    private String name;
    private CustomerTier tier;

    public Customer(String name, CustomerTier tier){
        this.id = Main.customerId;
        Main.customerId += 1;
        this.name = name;
        this.tier = tier;
    }
}
