package com.akirolabs.validator.services;

import com.akirolabs.validator.dto.ValidatorResponse;

public interface ValidatorService {
    ValidatorResponse validateToken (String token);
}
