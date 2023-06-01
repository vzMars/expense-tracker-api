package dev.marcosgonzalez.expensetracker.dto;

public class ErrorMsgResponse {

    private String error;

    public ErrorMsgResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }
}
