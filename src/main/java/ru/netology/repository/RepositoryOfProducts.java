package ru.netology.repository;

import ru.netology.domain.Product;

public class RepositoryOfProducts {
    private Product[] products = new Product[0];

    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    public Product[] getAll() {
        return products;
    }

    public void deleteById(int id) {
        int length = products.length - 1;
        Product[] result = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                result[index] = product;
                index++;
            }
        }
        products = result;
    }

}
