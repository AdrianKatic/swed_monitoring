package com.adrian.monitoring.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String contact;

    // constructor
    public User(int id, String username, String contact, String password) {
        setId(id);
        setUsername(username);
        setContact(contact);
        setPassword(password);
    }

    // getter
    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getContact() {return contact;
    }
    public String getPassword() {
        return password;
    }

    // setter
    public void setId(int id) {
        if (id < 0 || id > 5) {
            throw new IllegalArgumentException("ID must be between 0 and 5");
        }
        this.id = id;
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        } else if (!username.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Username can only contain letters");
        }
        this.username = username;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("Password must contain at least one number");
        }
        this.password = password;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
