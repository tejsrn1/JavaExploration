package javaExpo;

public class Regularclass {

    public void do1() {

        //usage
        GenericClass<String> genericClass1 = new GenericClass<>("Tejpal");
        genericClass1.getData();// gets Tejpal

        GenericClass<Integer> genericClass2 = new GenericClass<>(4);
        genericClass2.getData(); // get 4


        genericClass1.genericMethods("Passingdata");
        genericClass1.genericMethods("Passingdata");
        genericClass1.genericMethods(24.32);
        genericClass1.genericMethods(39);
        genericClass1.genericMethods(true); // defined T as method level and it can be different then class level.

        //usage

        BoundedGenericClass<Integer> boundedGenericClass = new BoundedGenericClass<>();

        // will not work as it only accepts type extending Number.
        //BoundedGenericClass<String> boundedGenericClass2 = new BoundedGenericClass<String>();
    }


}
