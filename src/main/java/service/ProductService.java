package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "thit bo`", "123", "123", "123"));
        productList.put(2, new Product(2, "thit heo", "qwe", "qwe", "qwe"));
        productList.put(3, new Product(3, "thit ga`", "asd", "asd", "asd"));
        productList.put(4, new Product(4, "thit ngan", "zxc", "zxc", "zxc"));
        productList.put(5, new Product(5, "ca'", "456", "456", "456"));
    }

    @Override
    public List<Product> findAllProduct() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void create(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public Product findByName(String name) {
        return productList.get(name);
    }
}
