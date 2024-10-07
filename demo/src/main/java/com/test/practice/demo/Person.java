package com.test.practice.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    @JsonIgnore
    private String secret;

    public Person() {
    }

    public Person(String name, int age, String secret) {
        this.name = name;
        this.age = age;
        this.secret = secret;
    }

    // standard getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", secret='" + secret + '\'' +
                '}';
    }

}
