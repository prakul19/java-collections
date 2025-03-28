package com.bridgelabz.listinterface;
import java.util.*;

public class FrequencyCounter {
    public static Map<String, Integer> findFrequency(List<String> elements) {
        if (elements == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }

        Map<String, Integer> frequencyMap = new HashMap<>();
        try {
            for (String element : elements) {
                frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
            }
        } catch (Exception e) {
            System.err.println("Error occurred while calculating frequency: " + e.getMessage());
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the number of strings:");
            int n = scanner.nextInt();
            scanner.nextLine();

            List<String> elements = new ArrayList<>();
            System.out.println("Enter the strings:");
            for (int i = 0; i < n; i++) {
                elements.add(scanner.nextLine());
            }

            // Calculate and display the frequency
            Map<String, Integer> frequencyMap = findFrequency(elements);
            System.out.println("Frequency of elements:");
            System.out.println(frequencyMap);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

