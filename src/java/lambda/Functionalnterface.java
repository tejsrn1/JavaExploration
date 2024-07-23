package aa_learning.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Functionalnterface {

    public void predicates() {

        Predicate<String> predicateDefination = str1 -> str1.contains("Tejpal");

        var res = predicateDefination.test("TejpalAtodaria"); // true
        var res2 = predicateDefination.test("sdfsdfjlsd"); // false

        var neagatePredicate = predicateDefination.negate();// returns predicate which presents logical negation NOT evaluation


        // Usage
        var names = Arrays.asList("Peter", "Martin", "Tejpal");

        names.stream().filter(predicateDefination).forEach(System.out::println);// prints only for which predicates returns true i.e Tejpal will be only printed.

        names.stream().filter(neagatePredicate).forEach(System.out::println);// prints only for which predicates returns false All will be only printed except Tejpal.

        // Usage with AND condition and OR condition

        Predicate<Integer> p1Def = number -> (number % 2 == 0);
        Predicate<Integer> p2Def = number -> (number > 10);

        var cod = p1Def.and(p2Def).test(10); // false as it is not > 10 despite can divide by 0.


        Predicate<String> p3 = name -> name.startsWith("P");
        Predicate<String> p4 = name -> !name.endsWith("p");

        names.stream().filter(p3.and(p4)).forEach(System.out::println); // prints all which start with P but not ending with p.

        names.stream().filter(p3.or(p4)).forEach(System.out::println); // prints all which EITHER start with P OR  ending with p.
    }


    public void functions() {
        // Its a SAM Single abstract method
        //  takes one argument of a type T and produces a result of type R
        Function<String, Integer> funcDef1 = s1 -> s1.length();

        //usage

        funcDef1.apply("Tejpal");

        //OR

        var list = Arrays.asList("Te", "pe", "ja");
        var listofLen = list.stream().map(funcDef1).collect(Collectors.toList());
        //collects lenght of all passed string collection and create list of lenghts.

    }

    public void suppliers() {

        // Takes NO arg and just produce results.
        Supplier<Double> supDef1 = () -> Math.random();
        var res1 = supDef1.get(); // has only one method get ( ) to retrieve results.

        //Primitive type  support also provided if required.
        DoubleSupplier supDef2 = Math::random;
        var res2 = supDef2.getAsDouble(); //


        // usage
        var optionaldata = Optional.empty();

        System.out.println(optionaldata.orElseGet(supDef1)); // print data if present in optional else get it from supplier.


    }

    public void consumers() {

        // accept one arg but nothing to return
        //consumes the input supplied to it.
        //two methods are there , accept(T) of type T
        // andThen() method is for composition.

        Consumer<String> consumerDef1 = t -> System.out.println(t);
        consumerDef1.accept("Tejpal"); // print accepted string.

        // Usage
        var cities = Stream.of("Sydney", "Dhaka", "New York", "London");
        cities.forEach(consumerDef1); // print each supplied or accepted cities based on consumer definition.


        //special usage for compsition

        var citiesasList = Arrays.asList("Sydney", "Dhaka", "New York", "London");

        Consumer<List<String>> uppercaseListDef = lt -> {
            // code that converts each item of list ot uppercase
        };

        Consumer<List<String>> printlistDef = lt -> {
            // code that prints each item of list ot uppercase
            lt.stream().forEach(System.out::println);
        };

        uppercaseListDef.andThen(printlistDef).accept(citiesasList); //convert first to uppercase and then print each city.

    }


}

