/**
 *  It provides methods to read numbers from a file, filter even and odd numbers, and a main method
 * to execute the processing and display the results.

 *
 * @author : Percy Ratheko
 *
 * @version 1.8
 */


package com.bcit.comp601assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Numbers {

    private static final int NOTHING;
    private static final int THE_DIVISOR;

    static {
        NOTHING = 0;
        THE_DIVISOR = 2;
    }


    /**
     * Reads numbers from the file specified by "numbers.txt".
     *
     * @return A list of integers read from the file.
     */

    private static List<Integer> readNumbersFromFile()
    {

        final List<Integer> numbers ;
        numbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("numbers.txt")))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                numbers.addAll(Arrays.stream(line.split("\\s+"))
                        .map(Integer::parseInt)
                        .toList());
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return numbers;
    }


    /**
     * Filters even numbers from the list.
     *
     * @param numbers The list of numbers to be filtered.
     * @return : returns a list of even numbers.
     */
    private static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % THE_DIVISOR == NOTHING)
                .collect(Collectors.toList());
    }

    /**
     * Filters odd numbers from the  list.
     *
     * @param numbers The list of numbers to be filtered.
     * @return : returns a list of odd numbers.
     */
    private static List<Integer> filterOddNumbers(List<Integer> numbers)
    {
        return numbers.stream()
                .filter(num -> num % THE_DIVISOR != NOTHING)
                .collect(Collectors.toList());
    }

    /**
     * The main method to start the program,
     * read numbers from the file, filter even numbers and odd numbers,
     * and print the results.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args)
    {
        // Step 1: Read numbers from the file
        List<Integer> numbers = readNumbersFromFile();

        // Step 2: Filter even and odd numbers
        List<Integer> evenNumbers = filterEvenNumbers(numbers);
        List<Integer> oddNumbers = filterOddNumbers(numbers);

        // Step 3: Prints the results
        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Odd Numbers: " + oddNumbers);
    }
}