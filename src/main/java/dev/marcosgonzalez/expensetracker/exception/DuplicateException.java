package dev.marcosgonzalez.expensetracker.exception;

public class DuplicateException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public DuplicateException(String message) {
        super(message);
    }
}
