package dev.marcosgonzalez.expensetracker.controller;

import dev.marcosgonzalez.expensetracker.dto.CreateCategoryBody;
import dev.marcosgonzalez.expensetracker.model.Category;
import dev.marcosgonzalez.expensetracker.model.CategoryType;
import dev.marcosgonzalez.expensetracker.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public Iterable<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{type}")
    public Iterable<Category> getCategoriesByType(@PathVariable String type) {
        return categoryService.getCategoriesByType(type);
    }

    @PostMapping
    public Category createCategory(@RequestBody @Valid CreateCategoryBody body) {
        return categoryService.createCategory(body);
    }
}
