package com.bridgelabz.listinterface;

import java.util.LinkedList;
import java.util.Scanner;

public class NthElementFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || n <= 0) {
            throw new IllegalArgumentException("Invalid input: List cannot be null and N must be greater than 0");
        }

        try {
            int fastIndex = n;
            int slowIndex = 0;

            // Check if `n` is larger than the size of the list
            if (fastIndex > list.size()) {
                throw new IllegalArgumentException("N is larger than the size of the list");
            }

            // Move fast to the nth index
            while (fastIndex < list.size()) {
                slowIndex++;
                fastIndex++;
            }

            // Slow points to the nth element from the end
            return list.get(slowIndex);
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            LinkedList<String> list = new LinkedList<>();
            System.out.println("Enter the number of elements in the list:");
            int nElements = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the elements:");
            for (int i = 0; i < nElements; i++) {
                list.add(scanner.nextLine());
            }

            System.out.println("Enter the position N to find the Nth element from the end:");
            int n = scanner.nextInt();

            // Find and display the Nth element from the end
            String result = findNthFromEnd(list, n);
            if (result != null) {
                System.out.println("The " + n + "th element from the end is: " + result);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

