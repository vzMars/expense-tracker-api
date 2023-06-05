package dev.marcosgonzalez.expensetracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

public class TransactionBody {

    @NotBlank(message = "Please complete all required fields.")
    private String title;

    @NotNull(message = "Please complete all required fields.")
    @Range(min = 1)
    private Integer amount;

    @NotNull(message = "Please complete all required fields.")
    private LocalDate transactionDate;

    @NotBlank(message = "Please complete all required fields.")
    private String description;

    @NotNull(message = "Please complete all required fields.")
    @Range(min = 1)
    private Integer categoryId;

    public TransactionBody(String title, Integer amount, LocalDate transactionDate, String description, Integer categoryId) {
        this.title = title;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.description = description;
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
}
