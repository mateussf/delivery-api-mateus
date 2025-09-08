package com.deliverytech.delivery.model;



public enum UserRole {
    ADMIN("admin"),
    USER("user"),
    GUEST("ROLE_GUEST");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
