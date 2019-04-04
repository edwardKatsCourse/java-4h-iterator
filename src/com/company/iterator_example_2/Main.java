package com.company.iterator_example_2;

import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();


        Person p1 = new Person("Anna");
        Person p2 = new Person("Dave");
        Person p3 = new Person("John");
        Person p4 = new Person("Tom");
        Person p5 = new Person("William");
        Person p6 = new Person("Zoya");

        queue.add(p1);
        queue.add(p2);
        queue.add(p3);
        queue.add(p4);
        queue.add(p5);
        queue.add(p6);

        System.out.println("Ascending iterator");
        for (Person person : queue) {
            System.out.println(person);
        }

        System.out.println();
        System.out.println("---------------");
        System.out.println();
        System.out.println("Descending iterator");
        queue.invertOrder();
        for (Person person : queue) {
            System.out.println(person);
        }

    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + this.name;
    }
}

class Queue implements Iterable<Person> {

    //ascending - 0..100 (a..z)
    //descending - 100..0 (z..a)

    private boolean isAscending; //false
    private Person [] people = new Person[0];

    public Queue() {
        this.isAscending = true;
    }

    public void add(Person person) {

        Person [] tempArray = Arrays.copyOf(people, people.length + 1);
        tempArray[tempArray.length -1] = person; //0 index

        people = tempArray;
    }

    public void invertOrder() {
        //true = !true (false)
        //false = !false (true)
        this.isAscending = !this.isAscending;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "people=" + Arrays.toString(people) +
                '}';
    }

    @Override
    public Iterator<Person> iterator() {
        return new QueueIterator(this.people, this.isAscending);
    }
}

class QueueIterator implements Iterator<Person> {
    //  0       1        2        3
    //onion, cucumber, tomato, cabbage
    //cursor, move left, right

    private int currentElement = 0; //current index

    private boolean isAscending;

    private Person [] people;

    public QueueIterator(Person[] people, boolean isAscending) {
        this.people = people;
        this.isAscending = isAscending;

        if (!isAscending) { //descending (100..0)
            currentElement = people.length - 1;
        }
    }

    @Override
    public boolean hasNext() {

        if (people == null) {
            return false;
        }

        if (isAscending) {
            return ascendingCheck();
        } else {
            return descendingCheck();
        }
    }

    private boolean ascendingCheck() {
        //people.length 5 (0,4)
        //       4         >        5 - 1 = 4
        if (currentElement > people.length - 1) {
            return false;
        }
        return true;
    }

    private boolean descendingCheck() {
        if (currentElement < 0) {
            return false;
        }

        return true;
    }

    @Override
    public Person next() {
        //4 -> 5
//        if (currentElement > people.length - 1) {
//            throw new RuntimeException("This is my error message");
//        }

        if (!hasNext()) {
            throw new RuntimeException("This is my error message");
        }

        Person personToReturn = people[currentElement];

        if (isAscending) {

            currentElement++; //cursor move ->
        } else {
            currentElement--; //cursor move <-
        }

        return personToReturn;
    }
}
