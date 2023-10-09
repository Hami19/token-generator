package com.akirolabs.validator;

import com.akirolabs.validator.services.impl.ValidatorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ValidatorServiceTest {
    private ValidatorServiceImpl validatorService;

    @BeforeEach
    void setUp()
    {
        this.validatorService = new ValidatorServiceImpl();
    }

    @Test
    public void validateToken() throws Exception {
        String token = "8742-7828-4787-7247";

        boolean isValid = validatorService.validateToken(token).isValid();
        assertTrue(isValid);
    }
}
