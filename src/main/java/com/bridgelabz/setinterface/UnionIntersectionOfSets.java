package com.bridgelabz.setinterface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnionIntersectionOfSets {

    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2); // Add all elements from set2 to set1
        return unionSet;
    }

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2); // Retain only common elements
        return intersectionSet;
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

            // Compute union and intersection
            System.out.println("Set1: " + set1);
            System.out.println("Set2: " + set2);
            System.out.println("Union: " + union(set1, set2));
            System.out.println("Intersection: " + intersection(set1, set2));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

