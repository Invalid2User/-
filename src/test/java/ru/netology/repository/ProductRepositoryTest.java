package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.ProductManager;

class ProductRepositoryTest {

    @Test
    public void removingTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Mermaid", 500, "Anderson");
        Book book2 = new Book(2, "Mermaid 2", 400, "Anderson");
        Book book3 = new Book(3, "Mermaid 3", 300, "Anderson");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        repo.remove(3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeAndNegativeException() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Mermaid", 500, "Anderson");
        Book book2 = new Book(2, "Mermaid 2", 400, "Anderson");
        Book book3 = new Book(3, "Mermaid 3", 300, "Anderson");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(7));
    }

    @Test
    public void findAllTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Mermaid", 500, "Anderson");
        Book book2 = new Book(2, "Mermaid 2", 400, "Anderson");
        Book book3 = new Book(3, "Mermaid 3", 300, "Anderson");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);

    }

}