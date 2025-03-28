package com.bridgelabz.setinterface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubsetCheck {
    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        if (subset == null || superset == null) {
            throw new IllegalArgumentException("Sets cannot be null");
        }

        return superset.containsAll(subset); // Checks if all elements of subset exist in the superset
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of elements in Set1 (subset):");
            int n1 = scanner.nextInt();
            Set<Integer> subset = new HashSet<>();
            System.out.println("Enter elements of Set1:");
            for (int i = 0; i < n1; i++) {
                subset.add(scanner.nextInt());
            }

            System.out.println("Enter the number of elements in Set2 (superset):");
            int n2 = scanner.nextInt();
            Set<Integer> superset = new HashSet<>();
            System.out.println("Enter elements of Set2:");
            for (int i = 0; i < n2; i++) {
                superset.add(scanner.nextInt());
            }

            // Check if Set1 is a subset of Set2
            System.out.println("Set1 (Subset): " + subset);
            System.out.println("Set2 (Superset): " + superset);
            boolean result = isSubset(subset, superset);
            System.out.println("Is Set1 a subset of Set2? " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

