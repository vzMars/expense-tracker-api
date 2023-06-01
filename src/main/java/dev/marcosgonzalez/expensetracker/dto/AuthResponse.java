package dev.marcosgonzalez.expensetracker.dto;

public class AuthResponse {

    private UserInfo user;

    public AuthResponse(UserInfo user) {
        this.user = user;
    }

    public UserInfo getUser() {
        return this.user;
    }
}
