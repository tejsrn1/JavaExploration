package javaExpo;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    /**
     * This method demonstrates the creation of streams in Java.
     * A stream is a sequence of elements from a source like a list or map etc.
     * The stream maintains the same ordering of the elements as the ordering in the stream source.
     */
    public void do1() {
        // Creating streams.
        Stream<Integer> stream1 = Stream.of(1, 3, 4, 5, 6, 3);
        Stream<String> stream2 = Stream.of("a", "b");
        stream1.forEach(System.out::println);

        var doubleList = new ArrayList<Double>();
        Stream<Double> stream3 = doubleList.stream();

        Stream<Double> randomNoStream = Stream.generate(Math::random);
        randomNoStream.limit(100).forEach(System.out::println);

        IntStream stream = "123903_abcodoe".chars();
        Stream<String> stream4 = Stream.of("A$B$C".split("\\$"));
    }

    /**
     * This method demonstrates the collection of streams in Java.
     * The collect operation is a terminal operation that transforms the elements of the stream into a different data structure.
     */
    public void do2() {
        // Collecting streams.
        var list = new ArrayList<Integer>();
        var newList = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());

        var newObjectArray = list.stream().filter(p -> p / 2 == 0).toArray();

        var newIntegerArray = list.stream().filter(p -> p / 2 == 0).toArray(Integer[]::new);

        var newListAsLinkedList = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toCollection(LinkedList::new));

        var listOfString = new ArrayList<String>();
        var collectAsHashmap = listOfString.stream().collect(Collectors.toMap(Function.identity(), String::length));

        var groupBy = listOfString.stream().collect(Collectors.groupingBy(String::length, Collectors.toList()));

        var partitionBy = listOfString.stream().collect(Collectors.partitioningBy(s -> s.length() > 2));

        var movieList = new ArrayList<String>();
        var joinedRes = movieList.stream().collect(Collectors.joining("-"));
    }

    /**
     * This method demonstrates the use of intermediate operations on streams in Java.
     * Intermediate operations return the stream itself so you can chain multiple method calls in a row.
     */
    public void do3() {
        var listStr = new ArrayList<String>();
        listStr.add("Amitabh");
        listStr.add("Shekhar");
        listStr.add("Aman");
        listStr.add("Rahul");
        listStr.add("Shahrukh");
        listStr.add("Salman");

        listStr.stream().filter(s -> s.startsWith("A")).forEach(System.out::println);

        listStr.stream().filter(s -> s.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);

        listStr.stream().sorted().filter(s -> s.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);

        var sorting1 = listStr.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());

        var sorting2 = listStr.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
    }

    /**
     * This method demonstrates the use of terminal operations on streams in Java.
     * Terminal operations return a result of a certain type and not a stream.
     */
    public void do4() {
        var listStr = new ArrayList<String>();
        listStr.add("Amitabh");
        listStr.add("Shekhar");
        listStr.add("Aman");
        listStr.add("Rahul");
        listStr.add("Shahrukh");
        listStr.add("Salman");

        listStr.stream().forEach(System.out::println);
        var a = listStr.stream().map(String::toLowerCase).collect(Collectors.toList());

        var b = listStr.stream().anyMatch(s -> s.startsWith("S"));

        var c = listStr.stream().allMatch(s -> s.startsWith("S"));
        var d = listStr.stream().noneMatch(s -> s.startsWith("S"));
        var e = listStr.stream().filter(s -> s.startsWith("A")).findFirst();
        var e1 = e.get();

        var ct = listStr.stream().filter(sd -> sd.startsWith("A")).count();

        var reduction = listStr.stream().reduce((s1, s2) -> s1 + "&" + s2);
    }

    /**
     * This method demonstrates the use of parallel streams in Java.
     * Parallel streams divide the provided task into many and run them in different threads, utilizing multiple cores of the computer.
     */
    public void do5() {
        var list = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }

        var parallelStream = list.parallelStream();

        var evenNumbersArr = parallelStream.filter(i -> i % 2 == 0).toArray(Integer[]::new);

        System.out.print(Arrays.toString(evenNumbersArr));
    }

    /**
     * This method demonstrates the use of the flatMap operation on streams in Java.
     * The flatMap operation lets you replace each value of a stream with another stream and then concatenates all the generated streams into a single stream.
     */
    public void do6() {
        var list1 = Arrays.asList(1, 2, 3);
        var list2 = Arrays.asList(4, 5, 6);
        var list3 = Arrays.asList(7, 8, 9);

        var listOfList = Arrays.asList(list1, list2, list3);

        var listOfIntegerViaFlatMap = listOfList.stream().flatMap(List::stream).collect(Collectors.toList());

        var distinctItems = list1.stream().distinct().collect(Collectors.toList());
    }

    /**
     * This method demonstrates the use of special map operations on streams in Java.
     * These operations are used for transformations and are available for specific types like IntStream, DoubleStream, and LongStream.
     */
    public void do7() {
        var a = Stream.of("a1", "a2", "a3");
        a.map(s -> s.substring(1)).mapToInt(Integer::parseInt).max().ifPresent(System.out::println);

        var stream = Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);

        Supplier<Stream<String>> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));

        var newStream = streamSupplier.get();
        newStream.anyMatch(s -> true);

        var newStream2 = streamSupplier.get();
        newStream2.noneMatch(s -> true);
    }


}