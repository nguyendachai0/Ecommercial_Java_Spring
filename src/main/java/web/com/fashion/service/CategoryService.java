// CategoryService.java
package web.com.fashion.service;

import web.com.fashion.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategories();

    Optional<Category> getCategoryById(Long id);

    void saveCategory(Category category);

    void deleteCategory(Long id);
}
