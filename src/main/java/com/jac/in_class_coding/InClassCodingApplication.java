package com.jac.in_class_coding;

import com.jac.in_class_coding.inclassexamples.PolymorphismExample;
import com.jac.in_class_coding.inclassexamples.VisibilityModifiers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InClassCodingApplication implements ApplicationContextAware {
    public static ApplicationContext ctx;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        ctx = applicationContext;
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    public static void main(String[] args) {
        SpringApplication.run(InClassCodingApplication.class, args);

        ConsoleView view = new ConsoleView();
        CustomerDatabase customerDatabase = new HibernateDatabase();
//        CustomerDatabase customerDatabase = new ListBasedDatabase();

        MyController controller = new MyController();
        controller.configure(view, customerDatabase);
//
//        VisibilityModifiers vm = new VisibilityModifiers();
//        vm.addEmployee();
//
//        PolymorphismExample pe = new PolymorphismExample();
//        pe.tryOutPoly();

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
