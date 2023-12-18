// CategoryRepository.java
package web.com.fashion.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import web.com.fashion.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // You can define custom queries or methods if needed
}
