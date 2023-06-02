package dev.marcosgonzalez.expensetracker.service;

import dev.marcosgonzalez.expensetracker.dto.CreateCategoryBody;
import dev.marcosgonzalez.expensetracker.exception.DuplicateException;
import dev.marcosgonzalez.expensetracker.model.Category;
import dev.marcosgonzalez.expensetracker.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(CreateCategoryBody body) {
        if (categoryRepository.existsByNameIgnoreCase(body.getName())) {
            throw new DuplicateException("This category already exists.");
        }

        Category category = new Category(body.getName(), body.getType());
        return categoryRepository.save(category);
    }
}
