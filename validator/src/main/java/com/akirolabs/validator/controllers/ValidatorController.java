package com.akirolabs.validator.controllers;

import com.akirolabs.validator.dto.ValidatorResponse;
import com.akirolabs.validator.services.ValidatorService;
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
@RequestMapping("/validator")
public class ValidatorController {

    @Autowired
    ValidatorService validatorService;

    private static final Logger logger = LoggerFactory.getLogger(ValidatorController.class);

    @RequestMapping(value="/token/{token}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> validateToken(@PathVariable("token") String token) {
        logger.info(" Started Token Validator Function ");
        logger.debug(" Validating this token : ", token);

        ValidatorResponse response = validatorService.validateToken(token);

        logger.debug(" Validating Token : ", response.getToken());
        logger.info(" Ended Generating Token Function ");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
