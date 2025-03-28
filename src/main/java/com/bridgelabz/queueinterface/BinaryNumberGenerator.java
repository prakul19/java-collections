package com.bridgelabz.queueinterface;

import java.util.*;

public class BinaryNumberGenerator {
    // Method to generate binary numbers
    public static void generateBinaryNumbers(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be greater than 0");
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        System.out.println("Binary Numbers:");
        for (int i = 0; i < n; i++) {
            String binary = queue.remove();
            System.out.print(binary + " ");
            queue.add(binary + "0");
            queue.add(binary + "1");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the value of N (number of binary numbers to generate):");
            int n = scanner.nextInt();

            // Generate and display binary numbers
            generateBinaryNumbers(n);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

