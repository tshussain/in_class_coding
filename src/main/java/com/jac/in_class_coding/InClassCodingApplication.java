package com.jac.in_class_coding;

import com.jac.in_class_coding.inclassexamples.VisibilityModifiers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class InClassCodingApplication implements ApplicationContextAware {
    public static ApplicationContext ctx;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        ctx = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(InClassCodingApplication.class, args);

        ConsoleView view = new ConsoleView();
        CustomerDatabase customerDatabase = new HibernateDatabase();
//        CustomerDatabase customerDatabase = new ListBasedDatabase();

        MyController controller = new MyController();
        controller.configure(view, customerDatabase);

        VisibilityModifiers vm = new VisibilityModifiers();
        vm.addEmployee();

        boolean continueLoop = true;
        while (continueLoop) {
            continueLoop = controller.getAndDoNextAction();
        }
        System.out.println("Thanks.  Bye.");

        // Day 1 example
//        InClassExamples.switchExample();
//        InClassExamples.switchExample();

        // Examples of accessing the same object as itself or as the interface it implements
        // uncomment out these 3 lines to see what works and what doesn't
//        customerDatabase.myOtherMethod(); // Method doesn't exist in the interface, so compile error.
//        ListBasedDatabase lb = (ListBasedDatabase) customerDatabase;
//        lb.myOtherMethod();

    }

}
