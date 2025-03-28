package com.bridgelabz.mapinterface;

import java.util.*;

public class MapInverter {
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> inputMap) {
        if (inputMap == null) {
            throw new IllegalArgumentException("Input map cannot be null");
        }

        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : inputMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            // If the value already exists in the inverted map, add the key to its list
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return invertedMap;
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

            // Invert the map
            Map<Integer, List<String>> invertedMap = invertMap(inputMap);

            // Display the inverted map
            System.out.println("Inverted Map: " + invertedMap);
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
