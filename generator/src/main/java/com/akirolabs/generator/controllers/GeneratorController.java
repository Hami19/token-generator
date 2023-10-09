package com.akirolabs.generator.controllers;

import com.akirolabs.generator.dto.GeneratorResponse;
import com.akirolabs.generator.services.GeneratorService;
import com.akirolabs.generator.services.impl.GeneratorServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/generator")
public class GeneratorController {

    @Autowired
    GeneratorService generatorService;

    private static final Logger logger = LoggerFactory.getLogger(GeneratorController.class);

    @RequestMapping(value="/token/{digits}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> generateToken(@PathVariable("digits") String digits) {
        logger.info(" Started Generating Token Function ");
        logger.debug(" Allowed Digits : ", digits);

        GeneratorResponse response = generatorService.generateToken(digits);

        logger.debug(" Generated Token : ", response.getToken());
        logger.info(" Ended Generating Token Function ");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
