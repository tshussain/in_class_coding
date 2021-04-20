package com.jac.in_class_coding.inclassexamples;

import java.util.ArrayList;
import java.util.List;

class Animal {
    void sound() {
        System.out.println("Make a sound");
    }
}

class Horse extends Animal {
    @Override
    void sound() {
        // One thousand other lines of code and then
        System.out.println("Neigh");
    }
    // New method available in this child class only
    void ride() {
        System.out.println("Ride");
    }

}

class Cat extends Animal {
    @Override
    void sound() {
        // three hundred other lines of code and then
        System.out.println("Meow");
    }
    // New method available in this child class only
    void scratch() {
        System.out.println("Scratch");
    }

}

class Siamese extends Cat {

}


public class PolymorphismExample {

    public void tryOutPoly() {
        Cat c = new Cat();
        c.sound();

        Horse h = new Horse();
        h.sound();

        Animal a1 = new Animal();

        Siamese s = new Siamese();

        Animal a2 = (Animal) h; // Paint "animal" on a horse.

        Horse h2 = (Horse) a1;  // forcing a downcast.  Dangerous.  Causes a run-time error in this case.

        Animal a3 = new Horse();  // implicit upcast
//        a3.ride();  // Fail - can't access method from lower-level class

        Horse h3 = (Horse) a3;  // forcing a downcast.  Still dangerous, but this one succeeds.
        h3.ride();


        Animal a4 = new Animal();
        Cat c4 = new Cat();
        Siamese s4 = new Siamese();

//        s4 = (Siamese) c4;  // Fails

        c4 = (Cat) s4;

        Animal a5 = new Siamese();
        Cat c5 = (Cat) a5;  // legal downcast








        /* Casting is converting from one type to another *forcibly*
        *   Only works if one or the other is a descendent type  (vs sibling, cousin, etc for example) */
        Animal a = (Animal) c;
//        Horse h = (Horse) c;  // Not possible since Horse and Cat are not in the same branch of the object tree
        Animal a6 = s;  // upcasting is implicit
        Animal a7 = (Siamese) s;  // upcasting is implicit

        Siamese s2 = (Siamese) a2;  // downcasting (from parent type to child type)

        a.sound();  // Polymorphism
//        a.scratch();  // fails, because of abstraction

        List<Animal> allAnimals = new ArrayList<>();
        allAnimals.add(c);
        allAnimals.add(h);
        allAnimals.add(new Animal());

        /* Because the elements of the list are actually objects of varying classes,
              the .sound() method does different things (potentially) each time through the list.
         */
        for (Animal animal : allAnimals) {
            animal.sound();
        }

        Animal pet1 = new Cat();
        pet1.sound();
    }

}
