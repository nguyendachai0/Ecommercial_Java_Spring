// CategoryRepository.java
package web.com.fashion.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import web.com.fashion.model.Category;
import web.com.fashion.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can define custom queries or methods if needed
}
