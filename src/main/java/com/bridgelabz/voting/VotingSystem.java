package com.bridgelabz.voting;

import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> voteOrderMap = new LinkedHashMap<>();
    private Map<String, Integer> sortedVoteMap = new TreeMap<>();

    // Cast a vote dynamically
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
        sortedVoteMap.put(candidate, sortedVoteMap.getOrDefault(candidate, 0) + 1);
    }

    // Display votes in HashMap order
    public void displayVotesHashMap() {
        System.out.println("\nVotes in HashMap (No specific order):");
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Display votes in LinkedHashMap order
    public void displayVotesLinkedHashMap() {
        System.out.println("\nVotes in LinkedHashMap (Vote casting order):");
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Display votes in TreeMap order
    public void displayVotesTreeMap() {
        System.out.println("\nVotes in TreeMap (Sorted by candidate name):");
        for (Map.Entry<String, Integer> entry : sortedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Display election winner
    public void displayWinner() {
        if (voteMap.isEmpty()) {
            System.out.println("\nNo votes cast yet.");
            return;
        }
        String winner = Collections.max(voteMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        int maxVotes = voteMap.get(winner);
        System.out.println("\n🏆 Winner: " + winner + " with " + maxVotes + " votes!");
    }
}
