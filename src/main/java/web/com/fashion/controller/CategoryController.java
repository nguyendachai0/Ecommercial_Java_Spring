package web.com.fashion.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.com.fashion.model.Category;
import web.com.fashion.service.CategoryService;

import java.util.List;
import java.util.Optional;

// CategoryController.java
@Controller
@RequestMapping("/admin/category")
public class CategoryController {



        private final CategoryService categoryService;

        // Constructor injection
        public CategoryController(CategoryService categoryService) {
            this.categoryService = categoryService;
        }

        @GetMapping
        public String index(Model model) {
            List<Category> categories = categoryService.getAllCategories();
            model.addAttribute("categories", categories);
            return "admin/category/index";
        }

        @GetMapping("/create")
        public String createForm(Model model) {
            model.addAttribute("category", new Category());
            return "admin/category/create";
        }

        @PostMapping("/create")
        public String create(@ModelAttribute Category category) {
            categoryService.saveCategory(category);
            return "redirect:/admin/category";
        }

        @GetMapping("/edit/{id}")
        public String editForm(@PathVariable Long id, Model model) {
            Optional<Category> category = categoryService.getCategoryById(id);
            model.addAttribute("category", category);
            return "admin/category/edit";
        }

        @PostMapping("/edit/{id}")
        public String edit(@PathVariable Long id, @ModelAttribute Category category) {
            category.setId(id);
            categoryService.saveCategory(category);
            return "redirect:/admin/category";
        }

        @GetMapping("/delete/{id}")
        public String delete(@PathVariable Long id) {
            categoryService.deleteCategory(id);
            return "redirect:/admin/category";
        }

    // Other category-related methods
}
