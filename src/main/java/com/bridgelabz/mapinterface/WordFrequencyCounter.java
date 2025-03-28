package com.bridgelabz.mapinterface;

import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the text:");
            String text = scanner.nextLine();

            // Calculate word frequencies
            Map<String, Integer> wordFrequency = countWordFrequency(text);

            // Display the word frequencies
            System.out.println("Word Frequencies: " + wordFrequency);
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> wordFrequency = new HashMap<>();

        // convert to lowercase and remove punctuation
        text = text.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");

        // Split the text into words
        String[] words = text.split("\\s+");

        // Count the frequency of each word
        for (String word : words) {
            if (!word.isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        return wordFrequency;
    }
}

