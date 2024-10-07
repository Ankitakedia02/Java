package com.test.practice.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {

    public void testMethod(){

        List<String> names = Arrays.asList(
                "Akash",
                "Aakash",
                "Aaakash",
                "Ali",
                "Jack"
        );

        List<String> sorted = names.stream().sorted(Comparator.naturalOrder()).toList();

        System.out.println(sorted);

    }
}
