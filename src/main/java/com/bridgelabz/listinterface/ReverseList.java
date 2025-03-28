package com.bridgelabz.listinterface;
import java.util.*;

public class ReverseList {
    // Method to reverse a given list
    public static <T> List<T> reverseList(List<T> inputList) {
        if (inputList == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }

        List<T> reversedList = new ArrayList<>();
        try {
            for (int i = inputList.size() - 1; i >= 0; i--) {
                reversedList.add(inputList.get(i));
            }
        } catch (Exception e) {
            System.err.println("Error occurred while reversing the list: " + e.getMessage());
        }
        return reversedList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of elements for the ArrayList:");
            int n = scanner.nextInt();
            List<Integer> arrayList = new ArrayList<>();
            System.out.println("Enter " + n + " elements for the ArrayList:");
            for (int i = 0; i < n; i++) {
                arrayList.add(scanner.nextInt());
            }

            // Display original and reversed ArrayList
            System.out.println("Original ArrayList: " + arrayList);
            System.out.println("Reversed ArrayList: " + reverseList(arrayList));

            System.out.println("Enter the number of elements for the LinkedList:");
            int m = scanner.nextInt();
            List<Integer> linkedList = new LinkedList<>();
            System.out.println("Enter " + m + " elements for the LinkedList:");
            for (int i = 0; i < m; i++) {
                linkedList.add(scanner.nextInt());
            }

            // Display original and reversed LinkedList
            System.out.println("Original LinkedList: " + linkedList);
            System.out.println("Reversed LinkedList: " + reverseList(linkedList));
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

