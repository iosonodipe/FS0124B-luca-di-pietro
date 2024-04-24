package classes;

import program.Main;

public class Product {
    private Long id;
    private String name;
    private ProductCategory category;
    private Double price;

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Prodotto > Nome: %s, Categoria: %s, Prezzo: %f", name, category, price);
    }

    public Product(String name, ProductCategory category, Double price) {
        this.id = Main.productId;
        Main.productId += 1;
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
