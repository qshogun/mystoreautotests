package com.qshogun.model;

public class User {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;

    public static class Builder {
        User user = new User();

        public Builder setFirstName(String firstName) {
            user.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            user.lastName = lastName;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            user.emailAddress = emailAddress;
            return this;
        }

        public Builder setPassword(String password) {
            user.password = password;
            return this;
        }

        public User build() {
            return user;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }
}
