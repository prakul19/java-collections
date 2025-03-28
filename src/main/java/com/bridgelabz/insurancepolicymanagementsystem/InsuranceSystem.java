package com.bridgelabz.insurancepolicymanagementsystem;

import java.time.LocalDate;

public class InsuranceSystem {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        manager.addPolicy(new InsurancePolicy("P101", "prakul", LocalDate.now().plusDays(10), "Health", 5000));
        manager.addPolicy(new InsurancePolicy("P102", "parth", LocalDate.now().plusDays(45), "Auto", 3000));
        manager.addPolicy(new InsurancePolicy("P103", "parag", LocalDate.now().plusDays(5), "Home", 7000));
        manager.addPolicy(new InsurancePolicy("P104", "shreya", LocalDate.now().plusDays(25), "Auto", 2500));
        manager.addPolicy(new InsurancePolicy("P105", "prakirti", LocalDate.now().plusDays(70), "Health", 6000));

        // Duplicate policy
        manager.addPolicy(new InsurancePolicy("P101", "prakul", LocalDate.now().plusDays(10), "Health", 5000));

        // Display policies
        manager.displayAllPolicies();
        manager.displayExpiringSoon();
        manager.displayByCoverageType("Auto");
        manager.displayDuplicatePolicies();

        // Performance test
        manager.comparePerformance();
    }
}
