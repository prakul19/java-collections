package com.bridgelabz.insurancepolicymanagementsystem2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class InsurancePolicyManager {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private Map<String, InsurancePolicy> orderedPolicyMap = new LinkedHashMap<>();
    private Map<LocalDate, InsurancePolicy> sortedPolicyMap = new TreeMap<>();

    // Add a new policy
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedPolicyMap.put(policy.getExpiryDate(), policy);
    }

    // Retrieve policy by number
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // Retrieve all policies expiring in the next 30 days
    public List<InsurancePolicy> getExpiringPolicies() {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Map.Entry<LocalDate, InsurancePolicy> entry : sortedPolicyMap.entrySet()) {
            if (ChronoUnit.DAYS.between(today, entry.getKey()) <= 30) {
                expiringPolicies.add(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    // Retrieve all policies for a specific policyholder
    public List<InsurancePolicy> getPoliciesByHolder(String policyholderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        sortedPolicyMap.entrySet().removeIf(entry -> entry.getKey().isBefore(today));
        policyMap.entrySet().removeIf(entry -> entry.getValue().getExpiryDate().isBefore(today));
        orderedPolicyMap.entrySet().removeIf(entry -> entry.getValue().getExpiryDate().isBefore(today));
    }

    // Display all policies
    public void displayAllPolicies() {
        System.out.println("\n All Policies ");
        for (InsurancePolicy policy : orderedPolicyMap.values()) {
            System.out.println(policy);
        }
    }
}

