package com.bridgelabz.mapinterface;

import java.util.*;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupByProperty {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        for (Employee employee : employees) {
            // Group employees by department
            departmentMap.computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>()).add(employee);
        }

        return departmentMap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of employees:");
            int n = scanner.nextInt();
            scanner.nextLine();

            List<Employee> employees = new ArrayList<>();
            System.out.println("Enter employee details in the format: name,department");
            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(",");
                String name = input[0].trim();
                String department = input[1].trim();
                employees.add(new Employee(name, department));
            }

            // Group employees by department
            Map<String, List<Employee>> groupedEmployees = groupByDepartment(employees);

            // Display the grouped employees
            for (Map.Entry<String, List<Employee>> entry : groupedEmployees.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
