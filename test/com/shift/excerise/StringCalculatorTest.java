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
    public void add_stringsSeparatedByCustomDelimiter(){
     
    }

}