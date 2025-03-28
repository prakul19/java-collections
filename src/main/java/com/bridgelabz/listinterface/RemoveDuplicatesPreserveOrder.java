package com.bridgelabz.listinterface;

import java.util.*;

public class RemoveDuplicatesPreserveOrder {
    public static <T> List<T> removeDuplicates(List<T> inputList) {
        if (inputList == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }

        List<T> resultList = new ArrayList<>();
        Set<T> seenElements = new HashSet<>();

        try {
            for (T element : inputList) {
                if (!seenElements.contains(element)) {
                    resultList.add(element); // Add element to result if not seen
                    seenElements.add(element);
                }
            }
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        }

        return resultList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of elements in the list:");
            int n = scanner.nextInt();
            scanner.nextLine();

            List<String> inputList = new ArrayList<>();
            System.out.println("Enter the elements:");
            for (int i = 0; i < n; i++) {
                inputList.add(scanner.nextLine());
            }

            // Remove duplicates and display result
            List<String> resultList = removeDuplicates(inputList);
            System.out.println("Original List: " + inputList);
            System.out.println("List After Removing Duplicates: " + resultList);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
