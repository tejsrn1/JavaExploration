package javaExpo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaFunc {

    /**
     * This method demonstrates the use of the sort method in Java.
     * It sorts a list of strings in various ways: using an anonymous class, lambda expressions, and a method reference.
     */
    public void do1() {
        var list = new ArrayList<String>();
        list.add("a");
        list.add("c");
        list.add("b");

        // Regular way: using an anonymous class.
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        // Lambda way 1: using a lambda expression with explicit types.
        Collections.sort(list, (String o1, String o2) -> {
            return o2.compareTo(o1);
        });

        // Lambda way 2: using a lambda expression with inferred types.
        Collections.sort(list, (o1, o2) -> {
            return o2.compareTo(o1);
        });

        // Lambda way 3: using a lambda expression with an expression body.
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));

        // Method reference way: using a method reference to the compareTo method of the String class.
        Collections.sort(list, String::compareTo);
    }

}

