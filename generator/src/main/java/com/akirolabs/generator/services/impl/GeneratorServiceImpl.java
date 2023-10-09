package com.akirolabs.generator.services.impl;

import com.akirolabs.generator.controllers.GeneratorController;
import com.akirolabs.generator.dto.GeneratorResponse;
import com.akirolabs.generator.exception.InvalidDigitsException;
import com.akirolabs.generator.services.GeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Value("${token.format}")
    private String tokenFormat;

    private static final Logger logger = LoggerFactory.getLogger(GeneratorServiceImpl.class);

    @Override
    public GeneratorResponse generateToken(String digits) {
        logger.info(" Starting GenerateToken Method ");
        Set<Integer> allowDigits = Arrays.stream(digits.split(","))
                .map(digi -> Integer.parseInt(digi.trim()))
                .map(digi -> {
                    if(digi > 0 && digi < 10) {
                        return digi;
                    }
                    else throw new InvalidDigitsException(digi.toString());
                })
                .collect(Collectors.toSet());

        Random random = getRandomObj();
        StringBuilder result = new StringBuilder();

        logger.info(" Calling random.ints() ");
        logger.debug(" Token format : ", tokenFormat);

        do {
            result = result.append(random.ints(tokenFormat.replace("-","").length(), 0, 10).
                    filter(v -> allowDigits.contains(v)).
                    mapToObj(Integer::toString)
                    .collect(Collectors.joining()));
        } while (result.length() < tokenFormat.replace("-","").length());

        logger.debug(" Generated random number before formatting", result);
        logger.info(" Formatting generated random number ");

        for(int i=0; i < tokenFormat.length(); i++) {
            if(tokenFormat.charAt(i) == '-') {
                result.insert(i,"-");
            }
        }
        logger.debug(" Random number after formatting", result);

        GeneratorResponse response = new GeneratorResponse();
        response.setAvailableDigits(digits)
                .setToken(result.substring(0, tokenFormat.length()));
        logger.info(" Ending GenerateToken Method ");

        return response;
    }

    public Random getRandomObj() {
        return new Random();
    }
}
