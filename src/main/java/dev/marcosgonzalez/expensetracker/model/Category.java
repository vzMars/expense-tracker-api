package dev.marcosgonzalez.expensetracker.model;

import jakarta.persistence.*;

@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryType type;

    public Category(String name, CategoryType type) {
        this.name = name;
        this.type = type;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }
}
