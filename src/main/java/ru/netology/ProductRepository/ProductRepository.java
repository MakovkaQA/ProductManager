package ru.netology.ProductRepository;

public class ProductRepository {
    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public Product[] findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                Product[] prodID = new Product[1];
                prodID[0] = product;
                return prodID;
            }
        }
        return null;
    }

    public void save(Product newProduct) {
        for (Product product : findAll()) {
            if (findById(newProduct.getId()) != null) {
                throw new AlreadyExistsException("Element with id: " + product.getId() + " already exists");
            }
        }
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = newProduct;
        products = tmp;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : findAll()) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
}
