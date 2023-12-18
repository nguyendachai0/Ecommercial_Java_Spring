// Category.java
package web.com.fashion.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category") // Change "categories" to "category"
    private List<Product> products;

    // Constructors, getters, and setters

    public Category() {
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Add other constructors, getters, and setters as needed
}
