package com.jac.in_class_coding.inclassexamples;

/* Who can do what */

/** Fields vs methods
 *  Partial implementation vs none
 *  Single vs "Multiple inheritance"
 */
public class AbstractVsInterface {
    void myMethod() {
//    MyAbstractClass myAbstractClass = new MyAbstractClass();
        Person person = new Person();
        person.updateContact();

        otherMethod(person);
        otherMethod2(person);
    }

    private void otherMethod2(MyInterface implementationOfMyInterface) {
        implementationOfMyInterface.printContact();
    }

    private void otherMethod(MyAbstractClass implementationOfAbstractClass) {
        implementationOfAbstractClass.updateContact();
    }
}


abstract class MyAbstractClass {
    protected String name;
    protected int phoneNumber;

    public abstract void updateContact();

    /* Code efficiency (only written once), plus Common look-and-feel */
    public void printContact() {
        System.out.println("Name" + name + " PH: " + phoneNumber);
    }
}

abstract interface MyInterface {
    public void updateContact();

    /* No guarantee of common look-and-feel because each implementing class may do it differently. */
    public void printContact();
}

/* Person isA MyAbstractClass
   Person isA MyInterface
 */
class Person extends MyAbstractClass implements MyInterface {

    @Override
    public void updateContact() {
        // get name from User
        name = System.console().readLine();
    }
}
