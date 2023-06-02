package dev.marcosgonzalez.expensetracker.repository;

import dev.marcosgonzalez.expensetracker.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    boolean existsByNameIgnoreCase(String name);
}
