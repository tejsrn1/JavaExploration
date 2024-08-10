# Java Programming Guide

Welcome to this comprehensive guide on the Java programming language. This document is designed to provide a clear and accessible overview of essential Java concepts and features. Here’s what you’ll find:

## Key Concepts

- **Access Modifiers**
  - Understand how access and non-access modifiers control the visibility and attributes of classes, methods, and variables.
  - Explore access levels: `public`, `protected`, `default`, and `private`.
  - Learn about non-access modifiers like `abstract`, `static`, `final`, and `synchronized`.

- **Core Features of Java**
  - **Object-Oriented Programming (OOP)**: Java’s approach to creating reusable and modular code.
  - **Type Safety**: Ensuring complete type checks at compile-time.
  - **Automatic Memory Management**: Managed by Java’s garbage collector.

- **Data Types and Methods**
  - **Primitive Types**: Numeric, character, and Boolean types.
  - **Reference Types**: Variables that store the address of an object.
  - **String and StringBuilder**: Handling immutable and mutable strings, respectively.
  - **Encapsulation and Methods**: Keeping internal states hidden and method usage.

- **Advanced Concepts**
  - **Inheritance**: Sharing and extending functionality through classes.
  - **Abstract Classes**: Defining common interfaces and enforcing implementation in subclasses.
  - **Interfaces**: Implementing contracts across classes, enabling multiple inheritance.

- **Additional Topics**
  - **Reference Variables and Casting**: Using base or interface types, and treating variables as different types.
  - **`this` and `super` Keywords**: Referring to the current instance and superclass.

- **Polymorphism**
  - Allows objects to take on multiple forms, enhancing flexibility and code reuse.


## Java Fundamentals

### Access Modifiers
Access modifiers control the visibility of classes, methods, and variables.

- **Public**: Accessible within the same package and from other packages.
- **Protected**: Accessible within the same package and from other packages, but only via inheritance.
- **Default**: Accessible only within the same package.
- **Private**: Accessible only within the class itself.

### Non-Access Modifiers
Non-access modifiers provide additional information about the properties of classes, methods, and variables.

- **abstract**: Declares a class or method that cannot be instantiated or used on its own.
- **static**: Indicates that the member belongs to the class, rather than instances of the class.
- **final**: Prevents the class from being extended, the method from being overridden, or the variable from being reassigned.
- **synchronized**: Ensures that a method is accessed by only one thread at a time.
- **native**: Indicates that the method is implemented in native code using languages like C or C++.
- **strictfp**: Ensures consistent floating-point calculations across platforms.
- **transient**: Prevents a variable from being serialized.
- **volatile**: Ensures that the value of a variable is always read from the main memory, making it thread-safe.

### Key Features of Java
Java offers several distinctive features that make it a powerful and versatile programming language.

- **Bytecode**: Compiled Java code executed by the JVM, enabling platform independence.
- **Object-Oriented Programming (OOP)**: Promotes reusable and modular code.
- **Encapsulation**: Hides the internal state and behavior of an object, exposing only what is necessary.
- **Inheritance**: Allows classes to inherit common characteristics and behaviors.
- **Polymorphism**: Enables objects to take on multiple forms, often via method overriding.
- **Type Safety**: Ensures complete type checks at compile-time.
- **Automatic Memory Management**: Managed by Java’s garbage collector.
- **Multithreading and Concurrency**: Facilitates the development of high-performance, responsive applications.
- **Security**: Offers robust APIs for cryptography and public key infrastructure.

### Data Types
Java has two categories of data types: primitive types and reference types.

- **Primitive Types**: Include numeric types (signed integers, floating-point), character types (char), and Boolean types.
- **Reference Types**: Variables that store the address of an object, not the object itself.

### Methods and Encapsulation
Methods and encapsulation are fundamental concepts in Java.

- **Scope of Variables**: Determined by where the variable is declared.
- **Object Life Cycle**: Managed by Java, which handles object creation and garbage collection.
- **Overloaded Methods or Constructors**: Methods that differ by the number, type, or position of parameters.
- **Encapsulation**: Keeps a class’s internal state hidden from the outside world.

### String Class, StringBuilder Class, and Comparing Objects
String and StringBuilder are essential classes in Java, and object comparison is a frequent operation.

- **String**: Immutable; once created, it cannot be modified.
- **StringBuilder**: Mutable; allows modifications after creation.
- **Comparing Custom Objects**: Requires overriding the `equals()` method to define what constitutes equality.

### Inheritance
Inheritance allows classes to share and extend functionality.

- **Why Use Inheritance?**: To group common characteristics and behaviors, and to make code extensible and maintainable.
- **What Can Be Inherited?**: Derived classes can inherit public and protected members, but not private members or constructors.

### Abstract Class
An abstract class provides a base for other classes without being instantiated itself.

- **Why Use an Abstract Class?**: To define a common interface for derived classes, group common properties and behaviors, and enforce implementation in subclasses.

### Interface
Interfaces define a contract that implementing classes must follow.

- **Why Use an Interface?**: To share behaviors across unrelated classes, enable multiple inheritance in Java, and keep code modular and extensible.
- **Interface Rules**: Method implementation must be public. Derived classes cannot change the return type of an overriding method. A class can implement multiple interfaces, provided there’s no ambiguity.

### Reference Variables and Object Types
Reference variables can point to an object of its type, its base class type, or an implemented interface type.

- **Why Use Base or Interface Variable Types?**: When you’re only concerned with behaviors related to the base class or interface.

### Casting
Casting allows you to treat a variable as a different type, provided there’s an IS-A relationship.

- **Why Use Casting?**: To access all members of a class object using a variable of its base class or interface type.

### `this` & `super`
- **this**: Refers to the current instance of a class.
- **super**: Refers to the superclass and can be used to access inherited properties or call superclass constructors.

### Polymorphism
Polymorphism allows objects to take many forms, typically implemented via inheritance and method overriding.

### Binding of Variables
Binding refers to the time at which a variable’s method or property is associated with an object. Java supports both compile-time and runtime binding.

### Lambda Expressions
Lambda expressions, introduced in Java 8, provide a concise way to represent one-method interfaces (functional interfaces). They are widely used in collections for iteration, filtering, and extraction.

```java
ArrayList<String> list = new ArrayList<>();
list.add("a");
list.add("c");
list.add("b");

// Lambda usage for sorting
Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
```

### Predicate and Function
Predicates and Functions are functional interfaces that represent boolean-valued functions and one-argument functions, respectively.

```java
// Predicate example
Predicate<String> predicate = (s) -> s.length() > 0;
predicate.test("foo"); // true

// Function example
Function<String, Integer> toInteger = Integer::valueOf;
Integer result = toInteger.apply("323");
```

### Suppliers and Consumers
Suppliers produce a result without accepting any arguments, while Consumers perform operations on a single input argument.

```java
Supplier<Person> personSupplier = Person::new;
personSupplier.get();

Consumer<Person> personConsumer = (p) -> System.out.println(p.firstName);
personConsumer.accept(new Person("TestName"));
```

### Cohesion, Coupling, and Composition

- **Cohesion**: Refers to how closely related the responsibilities of a class are. High cohesion is preferred.
- **Coupling**: Refers to how classes interact with each other. Loose coupling is preferred.
- **Composition**: Using existing classes within new classes rather than inheritance.

```java
class Engine { /* code */ }
class Wheel { /* code */ }

class Car {
    Engine engine; // Composition
    Wheel[] wheels = new Wheel[4]; // Composition
}
```

### Enumeration (Enum)
Enums define a set of named constants, which are type-safe and can have behavior attached.

```java
public enum Season {
    WINTER, SPRING, SUMMER, FALL
}
```

### Threading in Java
Threads allow for concurrent execution, maximizing CPU usage.

- **What is a Thread?**: Threads are lightweight processes within an application, sharing resources but maintaining their own execution stacks.

- **How to Create a Thread**: You can create a thread by either extending the `Thread` class or implementing the `Runnable` interface.

```java
// Extending Thread class
public class Sing extends Thread {
    public void run() { /* Execution code */ }
}

// Implementing Runnable interface
public class Sing implements Runnable {
    public void run() { /* Execution code */ }
}
```

- **Thread Lifecycle**: A thread goes through various states: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, and TERMINATED.

### Shared Data Protection
Shared data in threads must be protected to avoid conflicts. This can be done using synchronized methods, locks, and immutable objects.

### Deadlock, Starvation, and Livelock
- **Deadlock**: Occurs when two or more threads are blocked forever, each waiting on the other.
- **Starvation**: Happens when a thread is perpetually denied access to resources.
- **Livelock**: Threads keep responding to each other, preventing progress.

### Happens-Before Relationship
This relationship defines the order of operations in concurrent programming to ensure visibility of changes.

### Concurrency
Java provides a `java.util.concurrent` package that includes various classes like `BlockingQueue`, which is used for thread-safe operations.

## JDBC - Java Database Connectivity

### Overview

JDBC (Java Database Connectivity) is a standard Java API for connecting to databases. It allows Java applications to interact with various databases, including RDBMS, flat-file databases, and spreadsheets. JDBC provides a database-independent interface and is included in Java SE and Java EE.

### JDBC Components

- **JDBC Drivers**: 
  - **Type 4**: Pure Java driver.
  - **Type 3**: Java driver for database middleware.
  - **Type 2**: Native API driver.
  - **Type 1**: JDBC-ODBC bridge.
  - **Type 4** is most commonly used for its simplicity and performance.

- **Driver Registration**:
  - **Manual**: Using `Class.forName()`.
  - **Automatic**: JDBC 4.0 and later use the Service Provider Mechanism (SPM), which relies on `META-INF/Services` configuration files.

- **Core Interfaces**:
  - **`java.sql.Driver`**: Defines the driver interface. Implementations are registered with `DriverManager`.
  - **`java.sql.Connection`**: Represents a connection to a database. Used to create `Statement`, `PreparedStatement`, and `CallableStatement`.
  - **`java.sql.Statement`**: Executes static SQL queries. Includes `PreparedStatement` for precompiled queries and `CallableStatement` for stored procedures.
  - **`java.sql.ResultSet`**: Retrieves and processes the results of SQL queries. Can be read-only, updatable, or scrollable.

### Connecting to a Database

- **Connection Example**:
  ```java
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/feedback?user=sqluser&password=sqlpwd");
  ```

- **Exception Handling**:
  - `SQLException: No suitable driver found`
  - `SQLException: Access denied for user`

### CRUD Operations

- **Create Table**:
  ```java
  Connection con = getConnection();
  Statement st = con.createStatement();
  st.executeUpdate("CREATE TABLE...");
  ```

- **Insert Record**:
  ```java
  Statement st = con.createStatement();
  int ret = st.executeUpdate("INSERT INTO table...");
  ```

- **Update Record**:
  ```java
  Statement st = con.createStatement();
  int ret = st.executeUpdate("UPDATE table...");
  ```

- **Delete Record**:
  ```java
  Statement st = con.createStatement();
  int ret = st.executeUpdate("DELETE FROM table...");
  ```

- **Read Record**:
  ```java
  Statement st = con.createStatement();
  ResultSet rs = st.executeQuery("SELECT * FROM table...");
  while (rs.next()) {
      String title = rs.getString("title");
      int experience = rs.getInt("totalexperience");
  }
  ```

- **Transaction Management**:
  ```java
  Connection con = getConnection();
  con.setAutoCommit(false);
  Statement st = con.createStatement();
  st.executeUpdate("INSERT INTO table...");
  con.commit();
  // or con.rollback();
  ```

### Rowset Objects

- **Types**:
  - **Connected**: `JdbcRowSet` keeps an open connection.
  - **Disconnected**: `CachedRowSet` retrieves and updates data by reconnecting as needed.

- **Example**:
  ```java
  RowSetFactory factory = RowSetProvider.newFactory();
  JdbcRowSet jdbcRS = factory.createJdbcRowSet();
  jdbcRS.setUrl("jdbc:mysql://localhost/database");
  jdbcRS.setCommand("SELECT * FROM table");
  jdbcRS.execute();
  while (jdbcRS.next()) {
      // Process result
  }
  ```

## Java 9, 10, and 11 Features

### Java 9

- **Modules**: Introduced modularity to improve project organization and manage dependencies.

### Java 10

- **Local-Variable Type Inference**: Introduced `var` to infer types from initializer expressions.

### Java 11

- **LTS Release**: Java 11 is a Long-Term Support release.
- **Single-File Source Code Execution**: Allows running a Java file directly with `java` command without prior compilation.
- **String Enhancements**: New methods like `isBlank()`, `lines()`, `strip()`, `stripLeading()`, `stripTrailing()`, and `repeat(int)` for improved string manipulation.
- **Compact Strings**: Introduced to optimize memory usage for string storage.

### Stream API Improvements

- **`takeWhile()` Method**: Returns a stream consisting of elements satisfying a predicate until the predicate returns false.

### Factory Methods

- **Immutable Collections**: New factory methods for creating immutable instances of `List`, `Set`, `Map`, and `Map.Entry`.

### Oracle JDK vs Open JDK
