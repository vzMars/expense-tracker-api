package dev.marcosgonzalez.expensetracker.service;

import dev.marcosgonzalez.expensetracker.dto.CreateCategoryBody;
import dev.marcosgonzalez.expensetracker.exception.CategoryTypeException;
import dev.marcosgonzalez.expensetracker.exception.DuplicateException;
import dev.marcosgonzalez.expensetracker.model.Category;
import dev.marcosgonzalez.expensetracker.model.CategoryType;
import dev.marcosgonzalez.expensetracker.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Iterable<Category> getCategoriesByType(String type) {
        if (type.equalsIgnoreCase("Income")) {
            return categoryRepository.findAllByType(CategoryType.Income);
        }

        if (type.equalsIgnoreCase("Expense")) {
            return categoryRepository.findAllByType(CategoryType.Expense);
        }

        throw new CategoryTypeException("Invalid category type.");
    }

    public Category createCategory(CreateCategoryBody body) {
        if (categoryRepository.existsByNameIgnoreCase(body.getName())) {
            throw new DuplicateException("This category already exists.");
        }

        Category category = new Category(body.getName(), body.getType());
        return categoryRepository.save(category);
    }
}
