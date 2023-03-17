package ru.netology.ProductRepository;
public class Product {
    protected int id;
    protected String productName;
    protected String name;
    protected int price;


    public Product(int id, String productName, String name, int price) {
        this.id = id;
        this.productName = productName;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setProductName(String productName) {
        this.name = productName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
