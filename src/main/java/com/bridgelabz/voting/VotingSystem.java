package com.bridgelabz.voting;

import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>(); // Candidate -> Votes
    private Map<String, Integer> voteOrderMap = new LinkedHashMap<>(); // Maintain vote order
    private Map<String, Integer> sortedVoteMap = new TreeMap<>(); // Sorted order

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
        sortedVoteMap.put(candidate, sortedVoteMap.getOrDefault(candidate, 0) + 1);
    }

    public void displayResults() {
        System.out.println("\nVotes in HashMap (No specific order):");
        voteMap.forEach((key, value) -> System.out.println(key + " -> " + value + " votes"));

        System.out.println("\nVotes in LinkedHashMap (Vote casting order):");
        voteOrderMap.forEach((key, value) -> System.out.println(key + " -> " + value + " votes"));

        System.out.println("\nVotes in TreeMap (Sorted order):");
        sortedVoteMap.forEach((key, value) -> System.out.println(key + " -> " + value + " votes"));

        if (!voteMap.isEmpty()) {
            String winner = Collections.max(voteMap.entrySet(), Map.Entry.comparingByValue()).getKey();
            System.out.println("\n Winner: " + winner + " with " + voteMap.get(winner) + " votes!");
        } else {
            System.out.println("\nNo votes cast yet.");
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to the Voting System!");
        System.out.println("Enter candidate names to vote. Type 'exit' to finish voting.\n");

        while (true) {
            System.out.print("Enter candidate name: ");
            String candidate = scanner.nextLine().trim();

            if (candidate.equalsIgnoreCase("exit")) {
                break;
            }

            votingSystem.castVote(candidate);
            System.out.println("Vote recorded for " + candidate + "!");
        }
        scanner.close();
        votingSystem.displayResults();
    }
}
