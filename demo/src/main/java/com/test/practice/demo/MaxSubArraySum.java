package com.test.practice.demo;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxSubArraySum {


        public int uniqueChar(String s) {

            int n = s.length();

            for (int i = 0; i < n; i++) {
                boolean find = true;

                for (int j = 0; j < n; j++) {
                    if (i != j && s.charAt(i) == s.charAt(j)) {
                        find = false;
                        break;
                    }
                }
                if (find) {
                    return i;
                }

            }
            return -1;
        }

        public void uniQueCharacter (String s){

            Character ch = s.chars().mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i)))
                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap ::new, Collectors.counting()))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue() ==1)
                    .map(entry -> entry.getKey())
                    .findFirst().get();
            System.out.println(ch);

        }
}
