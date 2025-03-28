package com.bridgelabz.insurancepolicymanagementsystem;

import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManager {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    // Add policy to all sets
    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Display all policies
    public void displayAllPolicies() {
        System.out.println("\n--- All Unique Policies (HashSet) ---");
        for (InsurancePolicy policy : hashSetPolicies) {
            System.out.println(policy);
        }
    }

    // Retrieve policies expiring within 30 days
    public void displayExpiringSoon() {
        System.out.println("\n--- Policies Expiring Soon (Next 30 Days) ---");
        LocalDate today = LocalDate.now();
        LocalDate thresholdDate = today.plusDays(30);
        for (InsurancePolicy policy : treeSetPolicies) {
            if (policy.getExpiryDate().isBefore(thresholdDate)) {
                System.out.println(policy);
            }
        }
    }

    // Retrieve policies by coverage type
    public void displayByCoverageType(String type) {
        System.out.println("\n--- Policies with Coverage Type: " + type + " ---");
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }

    // Identify duplicate policies by policy number
    public void displayDuplicatePolicies() {
        System.out.println("\n--- Duplicate Policies ---");
        Map<String, Integer> countMap = new HashMap<>();
        for (InsurancePolicy policy : hashSetPolicies) {
            countMap.put(policy.getPolicyNumber(), countMap.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Duplicate Policy Number: " + entry.getKey());
            }
        }
    }

    // Performance test
    public void comparePerformance() {
        System.out.println("\n--- Performance Comparison ---");

        List<InsurancePolicy> testPolicies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            testPolicies.add(new InsurancePolicy("P" + i, "Holder " + i, LocalDate.now().plusDays(i), "Auto", 1000 + i));
        }
        long start, end;
        start = System.nanoTime();
        testPolicies.forEach(hashSetPolicies::add);
        end = System.nanoTime();
        System.out.println("HashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        testPolicies.forEach(linkedHashSetPolicies::add);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        testPolicies.forEach(treeSetPolicies::add);
        end = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (end - start) + " ns");
    }
}

