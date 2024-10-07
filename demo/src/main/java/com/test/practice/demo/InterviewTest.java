package com.test.practice.demo;

import java.util.*;
import java.util.stream.IntStream;

public class InterviewTest {

    public void testMethod(){
        String[] arr = {"d","b","c","b","c","a"};
        int k =2;

        Map<String, Long> frequency = new LinkedHashMap<>();

        IntStream.range(0, arr.length)
                .mapToObj(a -> arr[a])
                .forEach(s -> frequency.put(s, frequency.getOrDefault(s, 0L) + 1));

        String finalString = frequency.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry :: getKey)
                .skip(k-1)
                .findFirst()
                .orElse("");
        System.out.println(finalString);
    }

    public void test2() {

        Integer[] nums = {1,1,2,2,2,3};

        Map<Integer, Long> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0L) + 1);
        }

        List<Integer> list  = new ArrayList<>(Arrays.asList(nums));
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = map.get(o1).compareTo(map.get(o2));
                if(a !=0){
                    return a;
                }
                return o2.compareTo(o1);
            }
        });

        Integer[] sortedArray = list.toArray(list.toArray(new Integer[0]));
        System.out.println(Arrays.toString(sortedArray));
    }


    public void nonRepeatingCharacter(){
        String s = "ankitna";

        Map<Character, Integer> frequency = new LinkedHashMap<>();
        for(Character c : s.toCharArray()){
            frequency.put(c, frequency.getOrDefault(c, 0) +1);
        }

        Character c = frequency.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println(c);

//        for(Character c : s.toCharArray()){
//            if (frequency.get(c) ==1){
//                System.out.println(c);
//                break;
//            }
//        }

    }

    public void maxAverageScore(){
        String[][] input = {
                {"Bobby", "87"},
                {"Charles", "100"},
                {"Eric", "64"},
                {"Charles", "22"}
        };

        Map<String, int[]> totalScoreMap = new HashMap<>();
        for(String[] arr : input){
            int score = Integer.parseInt(arr[1]);
            String name = arr[0];
            totalScoreMap.putIfAbsent(name, new int[2]); //{name, [totalScore, count of occurence]}
            totalScoreMap.get(name)[0] += score;
            totalScoreMap.get(name)[1] +=1;
        }
        for(Map.Entry<String, int[]> map: totalScoreMap.entrySet()){
            System.out.println(Arrays.toString(map.getValue()));
        }


        double maxAverage = Double.MIN_VALUE;
        for(int[] values : totalScoreMap.values()){
            int score = values[0];
            int count = values[1];
            double average = (double) score /count;
            if(average > maxAverage){
                maxAverage = average;
            }
        }
        System.out.println(maxAverage);
    }

    public void mostFrequentIpAddress(){
        String[] logs = {
                "192.168.1.1",
                "192.168.1.2",
                "192.168.1.1",
                "192.168.1.1",
                "192.168.1.3",
                "192.168.1.1",
                "192.168.1.2",
                "192.168.1.2",
        };

        Map<String, Integer> ipCount = new HashMap<>();
        for(String ip : logs){
            ipCount.put(ip, ipCount.getOrDefault(ip, 0) +1);
        }
        String mostFreqIp = ipCount.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getKey();


//        Integer maxOccur = Integer.MIN_VALUE;
//
//
//
//        for(Map.Entry<String, Integer> entry: ipCount.entrySet()){
//            if(entry.getValue() > maxOccur){
//                maxOccur = entry.getValue();
//                mostFreqIp = entry.getKey();
//            }
//        }
        System.out.println(mostFreqIp + " : " + mostFreqIp);
    }


  //  Write a program or function that takes two integers as input, performs the
  //  division, and returns the result as a string. If the result has repeating
  //  decimals, enclose the repeating part within brackets in the string
  //  representation.

    public String divisionFormat(){
        long num = 50;
        long den = 22;

        StringBuilder builder = new StringBuilder();

        builder.append(num/den);
        long rem = num % den;

        if(rem == 0){
            return builder.toString();
        }

        builder.append(".");

        Map<Long, Integer> remMap = new HashMap<>();
        while (rem != 0) {
            if (remMap.containsKey(rem)) {
                int start = remMap.get(rem);
                String nonRepeat = builder.substring(0, start);
                String repeat = builder.substring(start);
                return nonRepeat + "(" + repeat + ")";
            }
            remMap.put(rem, builder.length());
            rem *= 10;
            builder.append(rem / den);
            rem %= den;
        }
        return builder.toString();
    }



}
