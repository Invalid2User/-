package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    @Test
    public void fewProductsFindedTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Mermaid", 500, "Anderson");
        Book book2 = new Book(2, "Mermaid 2", 400, "Anderson");
        Book book3 = new Book(3, "Mermaid 3", 300, "Anderson");
        Smartphone smartphone1 = new Smartphone(4, "1+", 50_000, "Oppo");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);

        Product[] actual = manager.searchBy("Mermaid");
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void nothingFindedTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Mermaid", 500, "Anderson");
        Book book2 = new Book(2, "Mermaid 2", 400, "Anderson");
        Book book3 = new Book(3, "Mermaid 3", 300, "Anderson");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("The Hobbit");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findedOneTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Mermaid", 500, "Anderson");
        Book book2 = new Book(2, "Mermaid 2", 400, "Anderson");
        Book book3 = new Book(3, "Mermaid 3", 300, "Anderson");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Mermaid 2");
        Product[] expected = {book2};

        Assertions.assertArrayEquals(expected, actual);
    }
}
