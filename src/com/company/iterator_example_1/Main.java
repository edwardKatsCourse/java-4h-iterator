package com.company.iterator_example_1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> vegetables = new ArrayList<>();
        vegetables.add("onion");
        vegetables.add("cucumber");
        vegetables.add("tomato");
        vegetables.add("cabbage");

        //onion, cucumber, tomato, cabbage
        //cursor, move left, right

        //for each
        for (String vegetable : vegetables) {
        }


        Person person = new Person();
        for (Person p : person) {
            System.out.println(p.toString());
        }

        //syntax sugar

//        Person p1 = new Person();
//        Person p2 = new Person();
//        Person p3 = p1 + p2;

//        StringBuilder sb1 = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//        StringBuilder sb3 = sb1 + sb2;



        String s1 = new String("a");
        String s2 = new String("b");

        String s3 = s1 + s2; //syntax sugar -> "magic"


    }
}



class Person implements Iterable<Person> {

    private int placeInQueue;

    public Person() {
    }

    public Person(int placeInQueue) {
        this.placeInQueue = placeInQueue;
    }

    @Override
    public String toString() {
        return "This person in place " + placeInQueue + " in queue";
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator();
    }
}

class PersonIterator implements Iterator<Person> {

    private int callsCount = 0;
    private int maxCallsCount = 10;

    @Override
    public boolean hasNext() {
        System.out.println("hasNext() called");

        //0 == 10
        return callsCount <= maxCallsCount;
    }

    @Override
    public Person next() {
        System.out.println("next() called");

        callsCount++;
        return new Person(callsCount);
    }
}


