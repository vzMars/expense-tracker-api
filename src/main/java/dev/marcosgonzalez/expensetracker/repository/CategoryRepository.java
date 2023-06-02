package dev.marcosgonzalez.expensetracker.repository;

import dev.marcosgonzalez.expensetracker.model.Category;
import dev.marcosgonzalez.expensetracker.model.CategoryType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    boolean existsByNameIgnoreCase(String name);
    Iterable<Category> findAllByType(CategoryType type);
}
