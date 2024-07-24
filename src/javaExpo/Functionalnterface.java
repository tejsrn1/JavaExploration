package javaExpo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Functionalnterface {

    /**
     * This method demonstrates the use of the Predicate functional interface in Java.
     * Predicates are boolean-valued functions of one argument.
     */
    public void predicates() {
        // Predicate definition: checks if a string contains "Tejpal".
        Predicate<String> predicateDefinition = str -> str.contains("Tejpal");

        // Test the predicate with different inputs.
        var res = predicateDefinition.test("TejpalAtodaria"); // true
        var res2 = predicateDefinition.test("sdfsdfjlsd"); // false

        // Negate the predicate: returns a predicate that represents the logical negation of this predicate.
        var negatePredicate = predicateDefinition.negate();

        // Usage of the predicate with a list of names.
        var names = Arrays.asList("Peter", "Martin", "Tejpal");

        // Print only the names for which the predicate returns true.
        names.stream().filter(predicateDefinition).forEach(System.out::println);

        // Print only the names for which the predicate returns false.
        names.stream().filter(negatePredicate).forEach(System.out::println);

        // Usage of the predicate with AND and OR conditions.
        Predicate<Integer> p1Def = number -> (number % 2 == 0);
        Predicate<Integer> p2Def = number -> (number > 10);

        // Test the AND condition: false as 10 is not > 10 despite being divisible by 2.
        var cod = p1Def.and(p2Def).test(10);

        Predicate<String> p3 = name -> name.startsWith("P");
        Predicate<String> p4 = name -> !name.endsWith("p");

        // Print all names which start with "P" but do not end with "p".
        names.stream().filter(p3.and(p4)).forEach(System.out::println);

        // Print all names which EITHER start with "P" OR do not end with "p".
        names.stream().filter(p3.or(p4)).forEach(System.out::println);
    }

    /**
     * This method demonstrates the use of the Function functional interface in Java.
     * Functions accept one argument and produce a result.
     */
    public void functions() {
        // Function definition: returns the length of a string.
        Function<String, Integer> funcDef1 = s -> s.length();

        // Apply the function to a string.
        funcDef1.apply("Tejpal");

        // Use the function with a list of strings.
        var list = Arrays.asList("Te", "pe", "ja");
        var listOfLen = list.stream().map(funcDef1).collect(Collectors.toList());
    }

    /**
     * This method demonstrates the use of the Supplier functional interface in Java.
     * Suppliers represent a supplier of results.
     */
    public void suppliers() {
        // Supplier definition: returns a random double.
        Supplier<Double> supDef1 = () -> Math.random();
        var res1 = supDef1.get();

        // Primitive type support is also provided if required.
        DoubleSupplier supDef2 = Math::random;
        var res2 = supDef2.getAsDouble();

        // Usage of the supplier with an Optional.
        var optionalData = Optional.empty();
        System.out.println(optionalData.orElseGet(supDef1));
    }

    /**
     * This method demonstrates the use of the Consumer functional interface in Java.
     * Consumers represent operations to be performed on a single input argument.
     */
    public void consumers() {
        // Consumer definition: prints a string.
        Consumer<String> consumerDef1 = null;
        consumerDef1.accept("Tejpal");

        // Usage of the consumer with a stream of cities.
        var cities = Stream.of("Sydney", "Dhaka", "New York", "London");
        cities.forEach(consumerDef1);

        // Special usage for composition.
        var citiesAsList = Arrays.asList("Sydney", "Dhaka", "New York", "London");

        Consumer<List<String>> uppercaseListDef = list -> {
            // Code that converts each item of the list to uppercase.
        };

        Consumer<List<String>> printListDef = list -> {
            // Code that prints each item of the list.
            list.stream().forEach(System.out::println);
        };

        // Convert the list to uppercase and then print each city.
        uppercaseListDef.andThen(printListDef).accept(citiesAsList);
    }

}

