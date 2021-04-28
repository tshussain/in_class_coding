package com.jac.in_class_coding.inclassexamples;

import java.util.ArrayList;
import java.util.List;

public class QuizPracticalReview {

}

abstract class FoodItem {
    protected int grams;
    abstract double computeCalories();
}

class Dairy extends FoodItem {
    public Dairy(int grams) {
        this.grams = grams;
    }
    @Override
    double computeCalories() {
        return grams /100.0 * 42.0;
    }
}






class myController {
    List<FoodItem> allFoodConsumed;
    // method that enter data
    //  switch
    //      case 1 -> allFoodConsumed.add(new Dairy(gramsEntered));

    public double computeAllCaloriesConsumed() {
        double totalConsumed = 0.0;
        for (FoodItem foodItem: allFoodConsumed) {
            totalConsumed += foodItem.computeCalories();
        }
        return totalConsumed;
    }
}


abstract class FoodItem2 {
    protected int grams;
    protected double caloriesPerGram;

    public double computeCalories() {
        return grams /100.0 * caloriesPerGram;
    }
}

class Dairy2 extends FoodItem2 {
    public Dairy2(int grams) {
        this.grams = grams;
        this.caloriesPerGram = 42;
    }
}



class FoodConsumed {
    private int grams;
    private double caloriesPerGram;
    private String group;

    public FoodConsumed(int grams, double caloriesPerGram, String group) {
        this.grams = grams;
        this.caloriesPerGram = caloriesPerGram;
        this.group = group;
    }
}


class MyController2 {

    //  switch
    //  case 1 -> allFoodConsumed.add(new FoodConsumed(gramsEntered, 42, "Dairy");

}

class MyController3 {

    //  switch
    //  case 1 -> FoodItem foodItem = new Dairy(gramsEntered);
    //            allFoodConsumed.add(new FoodConsumed(gramsEntered, foodItem.getCalories(), "Dairy");

}

class MyController4 {
    List<Integer> caloriesConsumed = new ArrayList<>();


    //  switch
    //  case 1 -> FoodItem foodItem = new Dairy(gramsEntered);
    //            caloriesConsumed.add(foodItem.getCalories());



}


abstract class FoodItem3 {
    protected int grams;

    /* Use an abstract method for code-reuse purposes
        Use the getter so this abstract class doesn't need to have
        access to private information.
     */
    public double computeCalories() {
        return grams /100.0 * getCaloriesPerGram();
    }

    abstract protected double getCaloriesPerGram();
}

class Dairy3 extends FoodItem3 {
    private double caloriesPerGram;

    public Dairy3(int grams) {
        this.grams = grams;
        this.caloriesPerGram = 42;
    }

    @Override
    protected double getCaloriesPerGram() {
        return caloriesPerGram;
    }
}





