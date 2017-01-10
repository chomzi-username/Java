package com.goralczyk.Convert;

public class Person {
    private String name;
    private int age;
    private static int count;
    
    public static int getCount(){
        return count;
    }

    public Person() {
        count++;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

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
    
    @Override
    public String toString(){
        return "Person [name="+name+", age="+age+"]";
    }
    
}