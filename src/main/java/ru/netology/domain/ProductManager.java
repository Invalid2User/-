package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository products;

    public ProductManager(ProductRepository products) {
        this.products = products;
    }

    public void add(Product product){
        products.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : products.findAll()) {
            if (matches(product, text)) {
                result[result.length - 1] = product;
            }
        }
        return result;
    }
    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}
