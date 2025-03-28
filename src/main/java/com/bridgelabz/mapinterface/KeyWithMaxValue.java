package com.bridgelabz.mapinterface;

import java.util.*;

public class KeyWithMaxValue {
    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("The map cannot be null or empty");
        }
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the number of key-value pairs:");
            int n = scanner.nextInt();
            scanner.nextLine();

            Map<String, Integer> inputMap = new HashMap<>();
            System.out.println("Enter the key-value pairs (key:value):");
            for (int i = 0; i < n; i++) {
                String[] pair = scanner.nextLine().split(":");
                String key = pair[0];
                Integer value = Integer.parseInt(pair[1]);
                inputMap.put(key, value);
            }

            // Find the key with the maximum value
            String maxKey = findKeyWithMaxValue(inputMap);
            System.out.println("Key with the maximum value: " + maxKey);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

