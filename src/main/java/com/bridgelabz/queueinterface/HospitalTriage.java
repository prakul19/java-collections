package com.bridgelabz.queueinterface;

import java.util.*;

// Patient class to store patient details
class Patient {
    private String name;
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // PriorityQueue with a custom comparator
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(Comparator.comparingInt(Patient::getSeverity).reversed());

        try {
            System.out.println("Enter the number of patients:");
            int n = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < n; i++) {
                System.out.println("Enter the name of patient " + (i + 1) + ":");
                String name = scanner.nextLine();

                System.out.println("Enter the severity of patient " + (i + 1) + " (higher number = more severe):");
                int severity = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                triageQueue.add(new Patient(name, severity));
            }

            System.out.println("Order of treatment:");
            // Process patients
            while (!triageQueue.isEmpty()) {
                System.out.println(triageQueue.poll());
            }
        } catch (Exception e) {

            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

