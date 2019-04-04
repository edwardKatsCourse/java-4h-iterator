package com.company.iterator_example_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("banana");
        list.add("pineapple");
        list.add("apple");
        list.add("cherry");

        //-----------------------------------
        for (String fruit : list) { //.iterator()
            //list.remove(fruit); //list.remove()
        }

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String currentFruit = iterator.next();
            System.out.println(currentFruit);
            iterator.remove();
        }

        System.out.println(list);
    }
}
