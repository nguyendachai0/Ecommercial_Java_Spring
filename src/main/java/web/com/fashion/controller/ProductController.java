package web.com.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.com.fashion.model.Category;
import web.com.fashion.model.Product;
import web.com.fashion.service.CategoryService;
import web.com.fashion.service.ProductService;

import java.util.List;
import java.util.Optional;

// productController.java
@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private CategoryService categoryService;
    // You need to have a CategoryService to retrieve categories

    private final ProductService productService;

    // Constructor injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String index(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "admin/product/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        List<Category> categories = categoryService.getAllCategories(); // Replace this with the actual method to get categories
        model.addAttribute("categories", categories);
        return "admin/product/create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        // Logic to save the product to the database
        productService.saveProduct(product);
        return "redirect:/admin/product"; // Redirect to the product list page
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productService.getProductById(id);
        List<Category> categories = categoryService.getAllCategories(); // Replace this with the actual method to get categories
        model.addAttribute("categories", categories);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "admin/product/edit";
        } else {
            // Redirect to an error page or return an appropriate response
            return "error/productNotFound";
        }
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute Product product) {
        product.setId(id);
        productService.saveProduct(product);
        return "redirect:/admin/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin/product";
    }

    // Other product-related methods
}
