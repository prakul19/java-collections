package com.bridgelabz.listinterface;

import java.util.*;

public class RotateElements {
    public static <T> List<T> rotateList(List<T> inputList, int positions) {
        if (inputList == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }
        if (positions < 0) {
            throw new IllegalArgumentException("Number of positions cannot be negative");
        }

        List<T> rotatedList = new ArrayList<>();
        try {
            int size = inputList.size();
            positions = positions % size; // Handle cases where positions > size
            for (int i = positions; i < size; i++) {
                rotatedList.add(inputList.get(i));
            }
            for (int i = 0; i < positions; i++) {
                rotatedList.add(inputList.get(i));
            }
        } catch (Exception e) {
            System.err.println("Error occurred during rotation: " + e.getMessage());
        }
        return rotatedList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the number of elements in the list:");
            int n = scanner.nextInt();
            scanner.nextLine();

            List<Integer> inputList = new ArrayList<>();
            System.out.println("Enter the elements:");
            for (int i = 0; i < n; i++) {
                inputList.add(scanner.nextInt());
            }

            // Take rotation positions as input
            System.out.println("Enter the number of positions to rotate:");
            int positions = scanner.nextInt();

            // Rotate and display the list
            System.out.println("Original List: " + inputList);
            System.out.println("Rotated List: " + rotateList(inputList, positions));
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

