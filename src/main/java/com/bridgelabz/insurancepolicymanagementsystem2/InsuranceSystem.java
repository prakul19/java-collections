package com.bridgelabz.insurancepolicymanagementsystem2;

import java.time.LocalDate;

public class InsuranceSystem {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Adding sample policies
        manager.addPolicy(new InsurancePolicy("P101", "Prakul", LocalDate.of(2024, 5, 10), "Health", 1200.50));
        manager.addPolicy(new InsurancePolicy("P102", "Parth", LocalDate.of(2024, 4, 15), "Auto", 800.75));
        manager.addPolicy(new InsurancePolicy("P103", "Parag", LocalDate.of(2024, 6, 5), "Home", 950.00));
        manager.addPolicy(new InsurancePolicy("P104", "prakirti", LocalDate.of(2024, 3, 30), "Health", 1400.00)); // Expired
        manager.addPolicy(new InsurancePolicy("P105", "shreya", LocalDate.of(2024, 4, 28), "Auto", 1000.00));

        // Display all policies
        manager.displayAllPolicies();

        // Retrieve a policy by number
        System.out.println("\nRetrieving policy P102:");
        System.out.println(manager.getPolicyByNumber("P102"));

        // Retrieve policies expiring soon
        System.out.println("\nPolicies expiring in the next 30 days:");
        for (InsurancePolicy policy : manager.getExpiringPolicies()) {
            System.out.println(policy);
        }

        // Retrieve policies for a specific policyholder
        System.out.println("\nPolicies for prakul:");
        for (InsurancePolicy policy : manager.getPoliciesByHolder("prakul")) {
            System.out.println(policy);
        }

        // Remove expired policies
        System.out.println("\nRemoving expired policies");
        manager.removeExpiredPolicies();

        // Display policies after removal
        manager.displayAllPolicies();
    }
}

