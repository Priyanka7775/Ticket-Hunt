package com.project.authentication.rabbitmq;

public class RegistrationDTO {
    private String emailID;
    private String password;
    private String role;

    public RegistrationDTO() {

    }

    public RegistrationDTO(String emailID, String password, String role) {
        this.emailID = emailID;
        this.password = password;
        this.role = role;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
