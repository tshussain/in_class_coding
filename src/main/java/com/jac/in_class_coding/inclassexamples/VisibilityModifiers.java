package com.jac.in_class_coding.inclassexamples;

import java.util.List;

public class VisibilityModifiers {
    public void addEmployee() {
        Employee.addEmployee(); // Access a public static method using the CLASS name
        Employee employee = new Employee();
        employee.addEmployee(); // Also can access static method using the object name (but it has a "global" effect)
    }
}

class Employee {
    public static final int MAX_EMPLOYEES = 100; // No side-effects possible
    private static int numEmployees = 1;  // side-effects possible
    protected String name;
    private int employeeId;
    private List<String> commendations;

    public static void addEmployee() {
        if (numEmployees < MAX_EMPLOYEES) {
            numEmployees++;
        }
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public final void addCommendation(String commendation, Supervisor supervisor) {
        // Verify security rating to add commendation
    }
}

class Supervisor extends Employee {
    int securityRating;
}

class PartTimeEmployee extends Employee {
    int hoursPerWeek;

    @Override
    public String getName() {
        return "I'm parttime and my name is " + super.getName();
    }

    void printInfo() {
        System.out.println("Name" + name + "Employee ID" + getEmployeeId());
    }

    private void makeMyselfLookBetter() {
//        commendations.add("He's awesome - Joe the boss");
//        commendations.add("He got a great mark - Joe the boss");
    }
}

class FullTimeEmployee extends Employee {
    double overtimePayrate;
}


/*

PartTimeEmployee pte = new PartTimeEmployee();
// has a name, employeeId, hoursPerWeek.





 */


