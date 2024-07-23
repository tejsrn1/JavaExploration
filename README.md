# JavaExploration

# Comprehensive Guide to Java 

##  Access Modifiers
Access modifiers control the visibility of classes, methods, and variables.

1. **Public**: Allows access within the same package and from other packages.
2. **Protected**: Allows access within the same package and from other packages, but only via inheritance.
3. **Default**: Allows access only within the same package. No access from outside the package.
4. **Private**: Allows access only within the class itself. No access from other members of the same package or from other packages.

##  Non-Access Modifiers
Non-access modifiers provide additional information about the properties of classes, methods, and variables.

- **abstract**
- **static**: Related to the class, not any object.
- **final**: A class marked as final can't be extended by another class. A final variable can't be reassigned a value.
- **synchronized**: Ensures a method can't be accessed by multiple threads concurrently. Applies only to methods, not classes or variables.
- **native**: Calls and makes use of libraries written in other languages like C#.
- **strictfp**: Ensures that calculations using floating-point numbers are identical across all platforms.
- **transient**: A transient variable is not serialized when an object is serialized.
- **volatile**: A volatile variable's value can be safely modified by another thread.

##  Key Features of Java
Java has several distinctive features that make it a powerful and versatile programming language.

1. **Bytecode**: Java code is compiled into bytecode by the Java compiler and then executed by the JVM (Java Virtual Machine). The JVM, installed on different platform OS, converts bytecode into machine-specific instructions for actual execution. This is why the JVM is machine-dependent and might differ from OS to OS.
2. **Object-Oriented Programming (OOP)**
3. **Abstraction**
4. **Encapsulation**: Encapsulation allows you to hide the state and behavior of an object.
5. **Inheritance**
6. **Polymorphism**: Allows objects to take on many forms.
7. **Type Safety**: Complete type checks.
8. **Automatic Memory Management**: Managed by garbage collectors.
9. **Multithreading and Concurrency**
10. **Security**: Java defines APIs for cryptography and public key infrastructure.

##  Data Types
Java has two categories of data types: primitive types and reference types.

1. **Primitive Types**: Numeric (Signed - Integers like byte, short, int, long, Floating-point like float, double : Unsigned - Character like char) and Boolean.
2. **Reference Types**: A reference variable points to the address of a location in Heap memory where the object referenced by that variable is stored.

##  Methods and Encapsulation
Methods and encapsulation are fundamental concepts in Java.

1. **Scope of Variables**: The scope of a variable depends on the location of its declaration.
2. **Object Life Cycle**: Java manages the memory for allocating objects and reclaiming the memory occupied by unused objects.
3. **Overloaded Methods or Constructors**: A method can be overloaded if it changes in the number of parameters, type of parameters, and position of parameters that are accepted.
4. **Encapsulation**: A well-encapsulated class does not expose its internal parts to the outside.

##  String Class, StringBuilder Class, and Comparing Objects
String and StringBuilder are two important classes in Java, and comparing objects is a common operation.

1. **String**: Strings in Java are immutable. Once created, they cannot be modified.
2. **StringBuilder**: StringBuilder is mutable.
3. **Comparing Custom Objects**: Java provides a method called equals() that needs to be overridden by a custom class to define what can be called a comparison.

#  Inheritance: e.g., Manager extends Employee

Inheritance allows classes to inherit common characteristics and behaviors, making code more extensible and easier to modify.

- **Why use inheritance?**
    - To group common characteristics and behaviors.
    - To make code extensible. For example, a method that takes a base class can later use subclasses to get the work done.
    - Once a base class method is tested, it can be used everywhere.
- **What can be inherited?**
    - A derived class can inherit Default, Public, and Protected members of the base class.
    - Private members, default access members (if both derived and base are in different packages), and constructors of the base class cannot be inherited. However, a derived class can call the constructor of the base class.

#  Abstract Class

An abstract class groups the common properties and behaviors of derived classes without allowing itself to be instantiated, forcing derived classes to have their own implementation.

- **Why use an abstract class?**
    - If a base class is only for categorization and has no real implementation.
    - An abstract class groups the common properties and behaviors of derived classes.
    - It's not required for an abstract class to define abstract methods, but if they do, derived classes must implement them.

#  Interface: e.g., Interviewer implements ITrainable

An interface defines a set of behaviors and constants, letting the implementation be handled by the class that implements the interface.

- **Why use an interface?**
    - To allow multiple related or unrelated objects to share behaviors.
    - To make an application manageable and extensible.
    - To enable multiple inheritance.
    - Java 8+ allows declaring default and static methods that don't require the implementing class to implement.

# Rules for Interfaces

- You must implement a method of an interface using the explicit access modifier public.
- A derived class cannot change the return type of an overriding method (both abstract and default).
- A class can implement multiple interfaces as long as there's no confusion for the derived class as to which method from which interface it's implementing.
- For default methods, if a class implements two interfaces that have the same default methods, the derived class must override it.
- For static methods, let the interface define their own signature of the static method, and let the derived class implement those multiple interfaces. Since static methods belong to the interface only, there's no confusion.

# Interface Extends Another Interface

- For abstract methods, there's no confusion since the method has no implementation, and the derived class will implement it.
- For default methods, if an interface extends another interface, it can have a default method with the same name. However, the class still will not compile unless it also overrides the default method.
- For static methods, remember that static belongs to the interface only, so it will compile in multiple interface cases too.
# . Reference Variables and Object Types

A class object can be referred to using a variable of its own type, its base class type, or its implemented interface type.

- **Why use base or Interface variable type?**
    - When you are only concerned about the behavior of a class related to either its base class or implemented interface.
- **Tips**: A base class object cannot be referred to using a variable of its derived class.

#  Casting

Casting forces a variable to behave as a variable of another type. It's possible if a class shares an IS-A relationship with its inherited class.

- **Why use casting?**
    - When you need to access all members of a class object by using a variable of type its base class or interface.

#  this & super

- "this" always refers to an object of its own type.
- "super" can be used to refer to base class members when there is a conflict in property or to call a base class constructor.

#  Polymorphism

Polymorphism, meaning many forms, is implemented by inheritance concepts in the context of classes and interfaces, and by overriding concepts in the context of methods.

#  Binding of Variables

When a variable of another (compatible) type is used to refer to a class, it will bind at compile time, in contrast to when using a variable of its own type.

#  Lambda Expressions

Lambda expressions are a new and important feature of Java which was included in Java 8. They provide a clear and concise way to represent one method interface using an expression.

```java
ArrayList<String> list = new ArrayList<>();
list.add("a");
list.add("c");
list.add("b");

// Regular way
Collections.sort(list, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
});

// Lambda way
Collections.sort(list, (o1, o2) -> o2.compareTo(o1));

