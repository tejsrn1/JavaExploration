package aa_learning.java.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class lambda {

    public void do1() {
        var list = new ArrayList<String>();
        list.add("a");
        list.add("c");
        list.add("b");

        //Regular way
        Collections.sort(list, new Comparator<String>() {
            //Interface Comparator<T> i.e. Anonoumus class
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        //Lambda way 1
        Collections.sort(list, (String o1, String o2) -> {
            return o2.compareTo(o1);
        });

        //Lambda way 2
        Collections.sort(list, (o1, o2) -> {
            return o2.compareTo(o1);
        });

        //Lambda way 3
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));

        // Method reference way.
        Collections.sort(list, String::compareTo);
    }


}

