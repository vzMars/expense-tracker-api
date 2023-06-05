package dev.marcosgonzalez.expensetracker.dto;

import dev.marcosgonzalez.expensetracker.model.CategoryType;

import java.time.LocalDate;

public class TransactionInfo {

    private Integer id;
    private String title;
    private Integer amount;
    private LocalDate transactionDate;
    private String description;
    private Integer userId;
    private Integer categoryId;
    private String categoryName;
    private CategoryType categoryType;

    public TransactionInfo(Integer id, String title, Integer amount, LocalDate transactionDate, String description,
                           Integer userId, Integer categoryId, String categoryName, CategoryType categoryType) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.description = description;
        this.userId = userId;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public Integer getId() {
        return id;
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

    public Integer getUserId() {
        return userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }
}
