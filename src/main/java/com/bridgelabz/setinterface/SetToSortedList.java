package com.bridgelabz.setinterface;

import java.util.*;

public class SetToSortedList {
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        if (set == null) {
            throw new IllegalArgumentException("Input set cannot be null");
        }
        // Convert the set to a list
        List<Integer> sortedList = new ArrayList<>(set);

        Collections.sort(sortedList);
        // return the sorted list
        return sortedList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of elements in the HashSet:");
            int n = scanner.nextInt();

            Set<Integer> hashSet = new HashSet<>();
            System.out.println("Enter the elements of the HashSet:");
            for (int i = 0; i < n; i++) {
                hashSet.add(scanner.nextInt());
            }

            // Convert and display the sorted list
            List<Integer> sortedList = convertToSortedList(hashSet);
            System.out.println("Original HashSet: " + hashSet);
            System.out.println("Sorted List: " + sortedList);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

