package com.akirolabs.generator.dto;

public class GeneratorResponse {
    private String token;
    private String availableDigits;

    public GeneratorResponse() {}

    public GeneratorResponse(String token, String availableDigits) {
        this.token = token;
        this.availableDigits = availableDigits;
    }

    public String getToken() {
        return token;
    }

    public GeneratorResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public String getAvailableDigits() {
        return availableDigits;
    }

    public GeneratorResponse setAvailableDigits(String availableDigits) {
        this.availableDigits = availableDigits;
        return this;
    }
}
