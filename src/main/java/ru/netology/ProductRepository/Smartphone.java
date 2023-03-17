package ru.netology.ProductRepository;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String productName, String name, int price, String manufacturer) {
        super(id, productName, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}
