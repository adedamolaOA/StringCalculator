package com.shift.excerise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        int result1 = 0;
        int result2 = 0;
        int result3 = 0;
        String testNumbers1 = "//;\n1;3;4";
        String testNumbers2 = "//$\n1$2$3";
        String testNumbers3 = "//@\n2@3@8";
        int expected1 = 8;
        int expected2 = 6;
        int expected3 = 13;
        String delimiter1 =  getDelimiter(testNumbers1);
        String delimiter2 =  getDelimiter(testNumbers2);
        String delimiter3 =  getDelimiter(testNumbers3);

        result1 =  Arrays.asList(testNumbers1.split("([" + delimiter1 + "])"))
                .stream()
                .filter(number -> number.matches("\\d+"))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue).sum();
        result2 =  Arrays.asList(testNumbers2.split("([" + delimiter2 + "])"))
                .stream()
                .filter(number -> number.matches("\\d+"))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue).sum();
        result3 =  Arrays.asList(testNumbers3.split("([" + delimiter3 + "])"))
                .stream()
                .filter(number -> number.matches("\\d+"))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue).sum();
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
    }

    @Test
    public void add_stringsSeparatedByComma_hasNegativeValue() {
        String result = "";
        String numbers = "1,2,-10";
        String numbersWithNoValues = "";
        String expected = "Negatives not allowed, caused by [-10]";
        int expected2 = 0;
        String delimiter = ",";
        List<Integer> numberList = Arrays.asList(numbers.split("([" + delimiter + "])"))
                .stream()
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> negatives = numberList.stream().filter(number -> number < 0).collect(Collectors.toList());
        if (!negatives.isEmpty()) {
            result = String.format("Negatives not allowed, caused by %s", negatives.toString());
        }
        assertEquals(expected, result);
    }

    private static String getDelimiter(String numbers) {
        return numbers.substring((numbers.indexOf("//") + 2), numbers.indexOf("\n") + 1 );
    }

}