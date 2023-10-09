package com.akirolabs.generator.exception;

public class InvalidDigitsException extends RuntimeException{
    public InvalidDigitsException(String digits){
        super("Allow Digits are [0-9], your input contain Invalid Digit : " + digits);
    }
}
