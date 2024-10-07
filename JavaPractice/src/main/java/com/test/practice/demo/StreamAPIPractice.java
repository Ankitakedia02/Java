package com.test.practice.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamAPIPractice {

    public void testMethod() {


        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 50000));
        employees.add(new Employee("Jane", 75000));
        employees.add(new Employee("Mary", 60000));
        employees.add(new Employee("Bob", 60000));



        double res = employees.stream().
                sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1).map(Employee::getSalary).findFirst().orElse(0.0);

        List<String> employeList = employees.stream()
                .filter(e -> e.getSalary() == res)
                .map(Employee::getName)
                .toList();


        System.out.println(employeList);

        String s = " - ";
        Optional<Double> con = employees.stream().map(Employee::getSalary)
                .reduce( Double:: sum);

        System.out.println(con);

        Optional<Employee> s1 = employees.stream()
                .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2 );

        System.out.println(s1);

        String s2 = employees.stream().map(Employee::getName)
                .reduce("", (a, b) -> a + " " +  b + ", ").stripTrailing();
        System.out.println(s2);

    }
}
