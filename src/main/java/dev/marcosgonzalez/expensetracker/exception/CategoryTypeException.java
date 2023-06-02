package dev.marcosgonzalez.expensetracker.exception;

public class CategoryTypeException extends RuntimeException {

    private static final long serialVersionUID = 2;

    public CategoryTypeException(String message) {
        super(message);
    }
}
