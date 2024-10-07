package com.test.practice.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @PostMapping("/receivePerson")
    public String receivePerson(@RequestBody Person person) {
        System.out.println("Received person: " + person.toString());
        return "Person received successfully!";
    }

    @GetMapping("/sendPerson")
    public Person sendPerson() {
        return new Person("John Doe", 30, "This is a secret!");
    }
}
