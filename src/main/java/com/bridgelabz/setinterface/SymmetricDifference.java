package com.bridgelabz.setinterface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SymmetricDifference {
    public static <T> Set<T> findSymmetricDifference(Set<T> set1, Set<T> set2) {
        if (set1 == null || set2 == null) {
            throw new IllegalArgumentException("Sets cannot be null");
        }

        Set<T> symmetricDifference = new HashSet<>(set1);
        symmetricDifference.addAll(set2); // Union of both sets
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // Intersection of both sets
        symmetricDifference.removeAll(intersection); // Remove intersection elements from union
        return symmetricDifference;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the number of elements in Set1:");
            int n1 = scanner.nextInt();
            Set<Integer> set1 = new HashSet<>();
            System.out.println("Enter elements of Set1:");
            for (int i = 0; i < n1; i++) {
                set1.add(scanner.nextInt());
            }

            System.out.println("Enter the number of elements in Set2:");
            int n2 = scanner.nextInt();
            Set<Integer> set2 = new HashSet<>();
            System.out.println("Enter elements of Set2:");
            for (int i = 0; i < n2; i++) {
                set2.add(scanner.nextInt());
            }

            // Calculate and display symmetric difference
            System.out.println("Set1: " + set1);
            System.out.println("Set2: " + set2);
            System.out.println("Symmetric Difference: " + findSymmetricDifference(set1, set2));
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

