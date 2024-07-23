package aa_learning.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class do_streams {

    // stream means sequence of elements from a source like list or map etc. and
    // stream maintains the same ordering of the elements as the ordering in the stream source
    // Intermediate operations on stream will only return a Stream back.
    // Terminate or aggregate operation will return result.


    public void do1() {

        //creating stream
        Stream<Integer> stream1 = Stream.of(1, 3, 4, 5, 6, 3);
        Stream<String> stream2 = Stream.of(new String[]{"a", "b"});
        stream1.forEach(p -> System.out.println(p));


        var doublelist = new ArrayList<Double>();
        Stream<Double> stream3 = doublelist.stream();


        Stream<Double> randomNoStream = Stream.generate(() -> Math.random());
        randomNoStream.limit(100).forEach(System.out::println);


        IntStream stream = "123903_abcodoe".chars();
        Stream<String> stream4 = Stream.of("A$B$C".split("$"));
    }


    public void do2() {

        // collects stream

        var list = new ArrayList<Integer>();
        var newlist =
                list.stream().filter(i -> i % 2 == 0)
                        .collect(Collectors.toList());


        var newObjectArray = list.stream().filter(p -> p / 2 == 0)
                .toArray();

        var newIntegerArray = list.stream().filter(p -> p / 2 == 0)
                .toArray(Integer[]::new);


        var newListAsLinkedList = list.stream().filter(i -> i % 2 == 0)
                .collect(Collectors.toCollection(LinkedList::new)); // collecting as  Linkedlist


        var listofString = new ArrayList<String>();
        // k,v pair will be stored.
        var collectAsHashmap = listofString.stream().collect(Collectors.toMap(p1 -> p1, p2 -> p2.length()));
        var collectAsHashmap2 = listofString.stream().collect(Collectors.toMap(Function.identity(), p2 -> p2.length()));

        // k,v pair as list by group of length of movie word.
        var grpyBy = listofString.stream().collect(Collectors.groupingBy(d -> d.length(), toList()));

        //K ,v pair as true/false if movie word length is above 2 letter.
        var partyBy = listofString.stream().collect(Collectors.partitioningBy(s -> s.length() > 2));

        var movieList = new ArrayList<String>();
        var joinedres = movieList.stream().collect(Collectors.joining("-")); // joined by  - e..g A-B-C

    }

    public void do3() {
        var listStr = new ArrayList<String>();
        listStr.add("Amitabh");
        listStr.add("Shekhar");
        listStr.add("Aman");
        listStr.add("Rahul");
        listStr.add("Shahrukh");
        listStr.add("Salman");


        //Intermediate operations.
        //return the stream itself so you can chain multiple methods calls in a row

        listStr.stream().
                filter(s -> s.startsWith("A"))
                .forEach(System.out::println); // print item start wiht A


        listStr.stream().
                filter(s -> s.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println); // map transform to another type here it cover to uppper case


        listStr.stream().sorted(). // sorted first.
                filter(s -> s.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println); // map transform to another type here it cover to uppper case

        var sorting1 = listStr.stream().
                sorted(Comparator.comparing(v -> v.length())) // set comparator on sorted.
                .collect(Collectors.toList());

        var sorting2 = listStr.stream().
                sorted(Comparator.comparing(String::length).reversed()) // set comparator on sorted then reverse the sorting.
                .collect(Collectors.toList());

    }

    public void do4() {

        var listStr = new ArrayList<String>();
        listStr.add("Amitabh");
        listStr.add("Shekhar");
        listStr.add("Aman");
        listStr.add("Rahul");
        listStr.add("Shahrukh");
        listStr.add("Salman");


        // Terminal or aggregate operation
        // return results not stream back

        listStr.stream().forEach(System.out::println);
        var a = listStr.stream().
                map(String::toLowerCase).
                collect(Collectors.toList()); // create new list of lower case itmes.

        //Once a matching value is found, no more elements will be processed in the stream
        var b = listStr.stream().anyMatch(s -> s.startsWith("S"));

        var c = listStr.stream().allMatch(s -> s.startsWith("S"));
        var d = listStr.stream().noneMatch(s -> s.startsWith("S"));
        var e = listStr.stream()
                .filter(s -> s.startsWith("A"))
                .findFirst();
        var e1 = e.get(); // Amitabh

        var ct = listStr.stream().
                filter(sd -> sd.startsWith("A")).count();


        var reduction = listStr.stream().
                reduce((s1, s2) -> s1 + "&" + s2); //create string from list e.g. Amitabh&Shekhar&Aman etc...

    }

    public void do5() {

        var list = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }

        //Using multiple threads in parallel cores,
        // all we have to call parallelStream() method instead of stream() method.
        var parallelStream = list.parallelStream();

        var evenNumbersArr = parallelStream.filter(i -> i % 2 == 0)
                .toArray(Integer[]::new);

        System.out.print(evenNumbersArr);

    }

    public void do6() {

        var list1 = Arrays.asList(1, 2, 3);
        var list2 = Arrays.asList(4, 5, 6);
        var list3 = Arrays.asList(7, 8, 9);

        var listOfList = Arrays.asList(list1, list2, list3);


        //flatMap() = Flattening + map()

        var listOfIntegerviaFlatMap =
                listOfList.stream()
                        .flatMap(i -> i.stream())
                        //flatMap() is an intermediate operation and return a new Stream.
                        //a new Stream is consisting of the results of replacing each element
                        // of the given stream with the contents of a
                        // mapped stream produced by applying the provided mapping function to each element.
                        .collect(Collectors.toList()); // 1,2,3,4,5,6 ...


        var distinctItems = list1.stream().distinct().collect(Collectors.toList());

    }

    public void do7() {

        //special maps
        var a = Stream.of("a1", "a2", "a3");
        a.map(s -> s.substring(1)).
                mapToInt(Integer::parseInt) // special helper map for INT, DOUBLE , Object etc. mapToObj, maptoInt etc.
                .max().ifPresent(System.out::println);//3


        //stream reusing :not allowed As soon as you call any terminal operation the stream is closed:.
        var stream =
                Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);    // ok
        stream.noneMatch(s -> true);   // exception


        // stream reusing: To overcome this limitation we have to
        // create a new stream chain for every terminal operation we want to execute

        Supplier<Stream> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> s.startsWith("a"));

        //Each call to get() constructs a new stream on which we are save to call the desired terminal operation
        var newStream = streamSupplier.get();
        newStream.anyMatch(s -> true);// ok

        var newStream2 = streamSupplier.get();
        newStream2.noneMatch(s -> true);// ok


    }


}