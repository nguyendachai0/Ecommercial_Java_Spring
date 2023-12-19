package web.com.fashion.service;

import web.com.fashion.model.Category;
import web.com.fashion.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Product saveProduct(Product product);

    void deleteProduct(Long id);
}
