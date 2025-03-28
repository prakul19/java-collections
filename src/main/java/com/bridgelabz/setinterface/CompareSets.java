package com.bridgelabz.setinterface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CompareSets {
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        if (set1 == null || set2 == null) {
            throw new IllegalArgumentException("Sets cannot be null");
        }
        return set1.equals(set2); // Checks if both sets are equal
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            System.out.println("Enter the number of elements in Set1:");
            int n1 = scanner.nextInt();
            System.out.println("Enter elements of Set1:");
            for (int i = 0; i < n1; i++) {
                set1.add(scanner.nextInt());
            }

            System.out.println("Enter the number of elements in Set2:");
            int n2 = scanner.nextInt();
            System.out.println("Enter elements of Set2:");
            for (int i = 0; i < n2; i++) {
                set2.add(scanner.nextInt());
            }

            // Compare sets and display the result
            System.out.println("Set1: " + set1);
            System.out.println("Set2: " + set2);
            boolean areEqual = areSetsEqual(set1, set2);
            System.out.println("Are the two sets equal? " + areEqual);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

