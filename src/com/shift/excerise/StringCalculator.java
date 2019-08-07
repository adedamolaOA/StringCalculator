package com.shift.excerise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private static int add(String numbers) throws NegativeNumberException {
        if(!numbers.trim().isEmpty()) {
            String delimiter = getDelimiter(numbers.trim());
            String delimiterSeparatedNumbers = geDelimiterSeparatedNumbers(numbers.trim());
            List<Integer> numberList = Arrays.asList(delimiterSeparatedNumbers.split("([" + delimiter + "]+)"))
                    .stream()
                    .map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> negatives = numberList.stream().filter(number -> number < 0).collect(Collectors.toList());
            if (!negatives.isEmpty()) {
                throw new NegativeNumberException(String.format("Negatives not allowed, caused by %s", negatives.toString()));
            }
            return numberList.stream()
                    .filter(number -> number <= 1000)
                    .mapToInt(Integer::intValue)
                    .sum();
        }
        return 0;
    }

    private static String getDelimiter(String numbers) {
        return numbers.startsWith(("//")) ? numbers.substring((numbers.indexOf("//") + 2), numbers.indexOf("\n") + 1) : ",|\n";
    }

    private static String geDelimiterSeparatedNumbers(String numbers){
        return numbers.startsWith(("//")) ? numbers.split("\n")[1] : numbers;
    }

    private static String getFormattedInput(String currentInput, BufferedReader bufferedReader) throws Exception {
        StringBuilder inputBuilder = new StringBuilder();
        if (currentInput.startsWith("//") || currentInput.length() < 5) {
            inputBuilder.append(currentInput).append(currentInput.startsWith("//") ? "\n" : "").append(bufferedReader.readLine());
        } else {
            inputBuilder.append(currentInput);
        }
        return inputBuilder.toString();
    }

    public static void main(String[] argv) throws Exception {
        System.out.println("Enter String Numbers: (enter 'q' to quit)");
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStream);
        String input;
        while(!(input = bufferedReader.readLine()).equalsIgnoreCase("Q")){
            System.out.println(input.isEmpty() ? 0 : add(getFormattedInput(input, bufferedReader)));
        }
        inputStream.close();
    }
}
