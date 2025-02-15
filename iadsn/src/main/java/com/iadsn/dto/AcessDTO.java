package com.iadsn.dto;

public class AcessDTO {
    private String token;

    public AcessDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
