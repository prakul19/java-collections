package com.bridgelabz.mapinterface;

import java.util.*;

public class MergeTwoMaps {
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            // If the key exists in map1, sum the values
            mergedMap.put(key, mergedMap.getOrDefault(key, 0) + value);
        }
        return mergedMap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the number of key-value pairs for Map1:");
            int n1 = scanner.nextInt();
            scanner.nextLine();
            Map<String, Integer> map1 = new HashMap<>();
            System.out.println("Enter the key-value pairs for Map1 (key:value):");
            for (int i = 0; i < n1; i++) {
                String[] pair = scanner.nextLine().split(":");
                String key = pair[0];
                Integer value = Integer.parseInt(pair[1]);
                map1.put(key, value);
            }

            // Input for Map2
            System.out.println("Enter the number of key-value pairs for Map2:");
            int n2 = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Map<String, Integer> map2 = new HashMap<>();
            System.out.println("Enter the key-value pairs for Map2 (key:value):");
            for (int i = 0; i < n2; i++) {
                String[] pair = scanner.nextLine().split(":");
                String key = pair[0];
                Integer value = Integer.parseInt(pair[1]);
                map2.put(key, value);
            }

            // Merge the maps
            Map<String, Integer> mergedMap = mergeMaps(map1, map2);

            // Display the merged map
            System.out.println("Merged Map: " + mergedMap);
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

