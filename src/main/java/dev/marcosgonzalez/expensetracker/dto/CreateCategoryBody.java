package dev.marcosgonzalez.expensetracker.dto;

import dev.marcosgonzalez.expensetracker.model.CategoryType;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class CreateCategoryBody {

    @NotBlank(message = "Please complete all required fields.")
    @Length(min = 2, max = 50, message = "The name must be between 2-50 characters.")
    private String name;

    private CategoryType type;

    public CreateCategoryBody(String name, CategoryType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public CategoryType getType() {
        return this.type;
    }
}
