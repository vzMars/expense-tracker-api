package dev.marcosgonzalez.expensetracker.dto;

public class UserInfo {

    private Integer id;
    private String email;
    private String username;

    public UserInfo(Integer id, String email, String username) {
        this.id = id;
        this.email = email;
        this.username = username;
    }

    public Integer getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }
}
