package com.test.practice.demo;


import java.util.HashMap;

//@RestController
//@RequestMapping("questions")
public class CapitalizeDuplicates {

  //  @GetMapping("allQuestions")
    public void printCaptilizedString(){
       String s = "abacdec";

        HashMap<Character, Integer> map = new HashMap<>();
        int count = 1;
        for(int i =0; i <s.length() ; i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), count);
            }
        }
        StringBuilder newS = new StringBuilder();
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)) {
                if (map.get(c) > 1) {
                    newS.append(String.valueOf(c).toUpperCase());
                } else{
                    newS.append(c);
                }
            }
        }
        System.out.print(newS);


    }
}
