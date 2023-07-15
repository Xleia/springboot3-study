package com.example.boot;

import com.example.boot.entity.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Boot302DemoApplication {

    public static void main(String[] args) {
        var ioc = SpringApplication.run(Boot302DemoApplication.class, args);

//        String[] names = ioc.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
//
//        String[] forType = ioc.getBeanNamesForType(FastsqlException.class);
//        for (String s : forType) {
//            System.out.println(s);
//        }

//        for (String s : ioc.getBeanNamesForType(Cat.class)) {
//            System.out.println("cat: " + s);
//        }
//
//        for (String s : ioc.getBeanNamesForType(Dog.class)) {
//            System.out.println("dog: " + s);
//        }
//
//        for (String s : ioc.getBeanNamesForType(User.class)) {
//            System.out.println("user: " + s);
//        }
//
//        Pig pig = ioc.getBean(Pig.class);
//        System.out.println(pig.getId());
//        System.out.println(pig.getName());
//        System.out.println(pig.getAge());

        Person bean = ioc.getBean(Person.class);
        System.out.println("person: " + bean);

    }

}
