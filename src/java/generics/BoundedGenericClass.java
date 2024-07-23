package aa_learning.java.generics;

public class BoundedGenericClass<T extends Number> {

    public void display() {
        System.out.println("This is a bounded type generics class.");
    }
}
