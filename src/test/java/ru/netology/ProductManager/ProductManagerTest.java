package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.ProductRepository.Book;
import ru.netology.ProductRepository.Product;
import ru.netology.ProductRepository.ProductRepository;
import ru.netology.ProductRepository.Smartphone;

public class ProductManagerTest {

    Product product1 = new Product(1, "productName1", "name1", 600);
    Product product2 = new Product(2, "productName2", "name2", 450);

    Book book1 = new Book(3, "book", "name3", 250, "author1");
    Book book2 = new Book(4, "book", "name4", 250, "author2");

    Smartphone smartphone1 = new Smartphone(5, "smartphone", "name5", 50_000, "manufacturer1");
    Smartphone smartphone2 = new Smartphone(6, "smartphone", "name6", 40_000, "manufacturer2");
    ProductRepository repo = new ProductRepository();

    ProductManager manager = new ProductManager(repo);

    @BeforeEach
    public void testPreparation() {
        repo.save(product2);
        repo.save(book1);
        repo.save(smartphone1);
    }

    @Test
    public void addProducts() {
        manager.add(product1);
        manager.add(book2);
        manager.add(smartphone2);

        Product[] expected = {product2, book1, smartphone1, product1, book2, smartphone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchByTextWhenTextIsFound() {

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("name5");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTextWhenTextIsNotFound() {

        Product[] expected = {null};
        Product[] actual = manager.searchBy("name6");

        Assertions.assertArrayEquals(expected, actual);
    }


}
