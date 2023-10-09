package com.akirolabs.validator.services.impl;

import com.akirolabs.validator.dto.ValidatorResponse;
import com.akirolabs.validator.services.ValidatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ValidatorServiceImpl implements ValidatorService {

    private static final Logger logger = LoggerFactory.getLogger(ValidatorServiceImpl.class);

    @Override
    public ValidatorResponse validateToken(String token) {
        logger.info(" Starting Validating Token Method ");
        String onlyTokenDigits = token.replace("-","");
        int nDigits = onlyTokenDigits.length();

        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--) {
            int d = onlyTokenDigits.charAt(i) - '0';
            if (isSecond == true)
                d = d * 2;

            nSum += d / 10;
            nSum += d % 10;

            isSecond = !isSecond;
        }
        ValidatorResponse response = new ValidatorResponse();
        response.setToken(token)
                .setValid(nSum % 10 == 0);
        logger.debug(" Validating Token Response : ", response.isValid());
        logger.info(" Ending Validating Method ");

        return response;
    }

    public Random getRandomObj() {
        return new Random();
    }
}
