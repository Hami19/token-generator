package com.akirolabs.validator.dto;

public class ValidatorResponse {
    private String token;
    private boolean isValid;

    public ValidatorResponse() {}

    public String getToken() {
        return token;
    }

    public ValidatorResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public boolean isValid() {
        return isValid;
    }

    public ValidatorResponse setValid(boolean valid) {
        isValid = valid;
        return this;
    }

    @Override
    public String toString() {
        return "ValidatorResponse{" +
                "token='" + token + '\'' +
                ", isValid=" + isValid +
                '}';
    }
}
