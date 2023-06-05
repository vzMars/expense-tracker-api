package dev.marcosgonzalez.expensetracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private Integer amount;
    private LocalDate transactionDate;
    private String description;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    public Transaction(String title, Integer amount, LocalDate transactionDate, String description, User user, Category category) {
        this.title = title;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.description = description;
        this.user = user;
        this.category = category;
    }

    public Transaction() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }
}
