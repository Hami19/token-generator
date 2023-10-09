package com.akirolabs.generator.services;

import com.akirolabs.generator.dto.GeneratorResponse;

public interface GeneratorService {
    GeneratorResponse generateToken (String digits);
}
