package com.shift.excerise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    @Test
    public void add_stringsSeparatedByComma(){
        int result2 = 0;
        String numbers = "1,2,5";
        String numbersWithNoValues="";
        int expected = 8;
        int expected2 = 0;
        String delimiter =  ",";
        int result = Arrays.asList(numbers.split("(" + delimiter + ")"))
                .stream()
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue).sum();
        if (!numbersWithNoValues.isEmpty()) {
            result2 =  Arrays.asList(numbersWithNoValues.split("(" + delimiter + ")"))
                    .stream()
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue).sum();
        }
        assertEquals(expected, result);
        assertEquals(expected2, result2);
    }

    @Test
    public void add_stringsSeparatedByComma_handleNewLines(){
        int result1 = 0;
        int result2 = 0;
        String testNumbers1 = "1\n,2,3";
        String testNumbers2 = "1,\n2,4";
        int expected1 = 6;
        int expected2 = 7;
        String delimiter =  ",|\n";
        result1 =  Arrays.asList(testNumbers1.split("([" + delimiter + "])"))
                .stream()
                .filter(number -> number.matches("\\d+"))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue).sum();
        result2 =  Arrays.asList(testNumbers2.split("([" + delimiter + "])"))
                .stream()
                .filter(number -> number.matches("\\d+"))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue).sum();
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
    }


    @Test
    public void add_stringsSeparatedByCustomDelimiter(){

    }

}