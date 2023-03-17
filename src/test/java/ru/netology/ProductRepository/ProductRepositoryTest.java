package ru.netology.ProductRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product product1 = new Product(1, "productName1", "name1", 600);
    Product product2 = new Product(2, "productName2", "name2", 450);

    Book book1 = new Book(3, "book", "name3", 250, "author1");
    Book book2 = new Book(4, "book", "name4", 250, "author2");

    Smartphone smartphone1 = new Smartphone(5, "smartphone", "name5", 50_000, "manufacturer1");
    Smartphone smartphone2 = new Smartphone(6, "smartphone", "name6", 40_000, "manufacturer2");


    ProductRepository repo = new ProductRepository();

    @BeforeEach
    public void testPreparation() {
        repo.save(product2);
        repo.save(book1);
        repo.save(smartphone1);
    }


    @Test
    public void getAllProducts() {

        Product[] expected = {product2, book1, smartphone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveProduct() {
        repo.save(product1);

        Product[] expected = {product2, book1, smartphone1, product1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveBookAndSmartphone() {
        repo.save(book2);
        repo.save(smartphone2);

        Product[] expected = {product2, book1, smartphone1, book2, smartphone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIDWhenIdIsFound() {
        repo.removeById(3);

        Product[] expected = {product2, smartphone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


}
