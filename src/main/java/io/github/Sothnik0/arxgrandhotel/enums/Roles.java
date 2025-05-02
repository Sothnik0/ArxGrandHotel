package io.github.Sothnik0.arxgrandhotel.enums;

public enum Roles {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }

    @Override
    public String toString(){
        return this.role;
    }
}
