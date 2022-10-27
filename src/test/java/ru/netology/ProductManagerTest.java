package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Book;
import ru.netology.manager.ProductManager;
import ru.netology.repository.RepositoryOfProducts;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {

    private Book first = new Book(1, "Idiot", 150, "Dostoevsky");
    private Smartphone second = new Smartphone(2, "Iphone XS", 900, "USA");
    private Book third = new Book(3, "Kapitanskaya Dochka", 200, "Pushkin");
    private Smartphone fourth = new Smartphone(4, "Iphone 13", 1100, "USA");

    @Test
    void ShouldFindProductsOnText() {
        ProductManager manager = new ProductManager(new RepositoryOfProducts());

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] actual = manager.searchBy("ph");
        Product[] expected = {second, fourth};
        assertArrayEquals(actual, expected);
    }

    @Test
    void ShouldNotFindProductsOnText() {
        ProductManager manager = new ProductManager(new RepositoryOfProducts());

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] actual = manager.searchBy("pl");
        Product[] expected = {};
        assertArrayEquals(actual, expected);
    }

    @Test
    void ShouldSaveNewProduct() {
        RepositoryOfProducts repository = new RepositoryOfProducts();
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        Product[] actual = repository.getAll();
        Product[] expected = {first, second, third, fourth};
        assertArrayEquals(actual, expected);
    }

    @Test
    void ShouldDeleteById() {
        RepositoryOfProducts repository = new RepositoryOfProducts();
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.deleteById(2);
        Product[] actual = repository.getAll();
        Product[] expected = {first, third, fourth};
        assertArrayEquals(actual, expected);
    }

}
