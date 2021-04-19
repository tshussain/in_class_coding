package com.jac.in_class_coding.inclassexamples;

public class InClassExamples {

    // Quick example of yield in different switch statement forms
    public static void switchExample() {
        int age = 15;

        String ageGroup;

        // yield with old form switch
        ageGroup = switch (age) {
            case 15: yield "Teenager";
            default: yield "Adult";
        };
        System.out.println(ageGroup);

        // yield with arrow form of switch
        ageGroup = switch (age) {
            case 15 -> { yield "Teenager";}
            default -> { yield "Adult"; }
        };

        System.out.println(ageGroup);
    }

}
