package dev.marcosgonzalez.expensetracker.exception;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 3;

    public NotFoundException(String message) {
        super(message);
    }
}
