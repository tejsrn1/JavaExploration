
# Java Exploration

This comprehensive guide provides an in-depth exploration of Java programming language. It covers essential concepts such as access and non-access modifiers, which control the visibility and provide additional information about classes, methods, and variables. The guide delves into key features of Java, including its object-oriented programming, type safety, and automatic memory management. It explains data types, methods, encapsulation, and the use of String and StringBuilder classes. The guide also elucidates advanced concepts like inheritance, abstract classes, and interfaces. It further discusses reference variables, object types, casting, and the use of 'this' and 'super'. Lastly, it introduces polymorphism, a fundamental concept in Java that allows objects to take on many forms. This guide serves as an invaluable resource for anyone looking to master Java programming.


## Access Modifiers
Access modifiers control the visibility of classes, methods, and variables.
- **Public**: Allows access within the same package and from other packages.
- **Protected**: Allows access within the same package and from other packages, but only via inheritance.
- **Default**: Allows access only within the same package. No access from outside the package.
- **Private**: Allows access only within the class itself. No access from other members of the same package or from other packages.

## Non-Access Modifiers
Non-access modifiers provide additional information about the properties of classes, methods, and variables.
- **abstract**
- **static**: Related to the class, not any object.
- **final**: A class marked as final can't be extended by another class. A final variable can't be reassigned a value.
- **synchronized**: Ensures a method can't be accessed by multiple threads concurrently. Applies only to methods, not classes or variables.
- **native**: Calls and makes use of libraries written in other languages like C#.
- **strictfp**: Ensures that calculations using floating-point numbers are identical across all platforms.
- **transient**: A transient variable is not serialized when an object is serialized.
- **volatile**: A volatile variable's value can be safely modified by another thread.

## Key Features of Java
Java has several distinctive features that make it a powerful and versatile programming language.
- **Bytecode**: Java code is compiled into bytecode by the Java compiler and then executed by the JVM (Java Virtual Machine). The JVM, installed on different platform OS, converts bytecode into machine-specific instructions for actual execution. This is why the JVM is machine-dependent and might differ from OS to OS.
- **Object-Oriented Programming (OOP)**
- **Abstraction**
- **Encapsulation**: Encapsulation allows you to hide the state and behavior of an object.
- **Inheritance**
- **Polymorphism**: Allows objects to take on many forms.
- **Type Safety**: Complete type checks.
- **Automatic Memory Management**: Managed by garbage collectors.
- **Multithreading and Concurrency**
- **Security**: Java defines APIs for cryptography and public key infrastructure.

## Data Types
Java has two categories of data types: primitive types and reference types.
- **Primitive Types**: Numeric (Signed - Integers like byte, short, int, long, Floating-point like float, double : Unsigned - Character like char) and Boolean.
- **Reference Types**: A reference variable points to the address of a location in Heap memory where the object referenced by that variable is stored.

## Methods and Encapsulation
Methods and encapsulation are fundamental concepts in Java.
- **Scope of Variables**: The scope of a variable depends on the location of its declaration.
- **Object Life Cycle**: Java manages the memory for allocating objects and reclaiming the memory occupied by unused objects.
- **Overloaded Methods or Constructors**: A method can be overloaded if it changes in the number of parameters, type of parameters, and position of parameters that are accepted.
- **Encapsulation**: A well-encapsulated class does not expose its internal parts to the outside.

## String Class, StringBuilder Class, and Comparing Objects
String and StringBuilder are two important classes in Java, and comparing objects is a common operation.
- **String**: Strings in Java are immutable. Once created, they cannot be modified.
- **StringBuilder**: StringBuilder is mutable.
- **Comparing Custom Objects**: Java provides a method called equals() that needs to be overridden by a custom class to define what can be called a comparison.

## Inheritance
Inheritance allows classes to inherit common characteristics and behaviors, making code more extensible and easier to modify.
- **Why use inheritance?**
    - To group common characteristics and behaviors.
    - To make code extensible. For example, a method that takes a base class can later use subclasses to get the work done.
    - Once a base class method is tested, it can be used everywhere.
- **What can be inherited?**
    - A derived class can inherit Default, Public, and Protected members of the base class.
    - Private members, default access members (if both derived and base are in different packages), and constructors of the base class cannot be inherited. However, a derived class can call the constructor of the base class.

## Abstract Class
An abstract class groups the common properties and behaviors of derived classes without allowing itself to be instantiated, forcing derived classes to have their own implementation.
- **Why use an abstract class?**
    - If a base class is only for categorization and has no real implementation.
    - An abstract class groups the common properties and behaviors of derived classes.
    - It's not required for an abstract class to define abstract methods, but if they do, derived classes must implement them.

## Interface
An interface defines a set of behaviors and constants, letting the implementation be handled by the class that implements the interface.
- **Why use an interface?**
    - To allow multiple related or unrelated objects to share behaviors.
    - To make an application manageable and extensible.
    - To enable multiple inheritance.
    - Java 8+ allows declaring default and static methods that don't require the implementing class to implement.

## Rules for Interfaces
- You must implement a method of an interface using the explicit access modifier public.
- A derived class cannot change the return type of an overriding method (both abstract and default).
- A class can implement multiple interfaces as long as there's no confusion for the derived class as to which method from which interface it's implementing.
- For default methods, if a class implements two interfaces that have the same default methods, the derived class must override it.
- For static methods, let the interface define their own signature of the static method, and let the derived class implement those multiple interfaces. Since static methods belong to the interface only, there's no confusion.

## Interface Extends Another Interface
- For abstract methods, there's no confusion since the method has no implementation, and the derived class will implement it.
- For default methods, if an interface extends another interface, it can have a default method with the same name. However, the class still will not compile unless it also overrides the default method.
- For static methods, remember that static belongs to the interface only, so it will compile in multiple interface cases too.

## Reference Variables and Object Types
A class object can be referred to using a variable of its own type, its base class type, or its implemented interface type.
- **Why use base or Interface variable type?**
    - When you are only concerned about the behavior of a class related to either its base class or implemented interface.
- **Tips**: A base class object cannot be referred to using a variable of its derived class.

## Casting
Casting forces a variable to behave as a variable of another type. It's possible if a class shares an IS-A relationship with its inherited class.
- **Why use casting?**
    - When you need to access all members of a class object by using a variable of type its base class or interface.

## this & super
- "this" always refers to an object of its own type.
- "super" can be used to refer to base class members when there is a conflict in property or to call a base class constructor.

## Polymorphism
Polymorphism, meaning many forms, is implemented by inheritance concepts in the context of classes and interfaces, and by overriding concepts in the context of methods.

## Binding of Variable
When a variable of a compatible type is used to refer to a class, it will bind at compile time. In contrast, when using a variable of its own type, it will bind at runtime.

## Lambda Expressions
Lambda expressions are a new and important feature of Java which was included in Java 8. They provide a clear and concise way to represent one method interface using an expression. Lambda expressions also improve the Collection libraries making it easier to iterate through, filter, and extract data from a Collection.


ArrayList<String> list = new ArrayList<>();
list.add("a");
list.add("c");
list.add("b");

//Regular way
Collections.sort(list, new Comparator<String>() {
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


## Predicate and Function
Predicates are boolean-valued functions of one argument. The java.util.function.Predicate interface represents a simple predicate. Similarly, the java.util.function.Function interface represents a function that accepts one argument and produces a result.


//Predicates are boolean-valued functions of one argument
Predicate<String> predicate = (s) -> s.length() > 0;
predicate.test("foo");              // true
predicate.negate().test("foo");     // false

Predicate<String> predicate2 = String::isEmpty;
predicate.test("foo");              // false
predicate.negate().test("foo");     // true

//Functions accept one argument and produce a result
Function<String, Integer> toIntFun = (s) -> Integer.valueOf(s);
Integer resAsIntegerRegular = toIntFun.apply("432");

Function<String, Integer> toInteger = Integer::valueOf;
Integer resAsInteger = toInteger.apply("323");


## Suppliers and Consumers
Suppliers represent a function that supplies a value of some sorts. In other words, Suppliers don’t accept arguments but produce a result of a given generic type. On the other hand, Consumers represents operations to be performed on a single input argument.

Supplier<Person> personSupplier = Person::new;
personSupplier.get();

Consumer<Person> personConsumer = (p) -> System.out.println(p.firstName);
personConsumer.accept(new Person("TestName"));

## Cohesion, Coupling, and Composing
Cohesion: High cohesion means that a class is well focused and its responsibility is well defined. Low cohesion means that a class has no well-defined responsibility.
Coupling: Coupling refers to how one class knows about another class. If they only know through defined public members of each other, then they are loosely coupled. But if one class can modify another class’s internal private members, then it’s tightly coupled. For example, do not call directly private field but instead use its public getter and setter property.
Composing: Composing is how to use any existing class. It’s not through inheritance, but by composing it.


class Engine { /* code */ }
class Wheel { /* code */ }

class Car {
    Engine engine; // composing another class
    Wheel[] wheels = new Wheel[5];  // composing another class
}

##Enumeration
Enumeration (also known as Enum) is a predefined class in Java which is used to define a new data type. Enumerations extend the base class Enum.


public enum Season {
    WINTER, SPRING, SUMMER, FALL
}

## Thread
Threads in Java are a part of the Java language that allows concurrent execution of two or more parts of a program for maximum utilization of CPU.

### What is a Thread?
- The operating system implements multithreading by dividing and allotting processor time to run applications using multiple algorithms like round-robin, high priority first, etc.
- An application can execute single or multiple processes which might run multiple threads.
- The JVM runs as a single process which acts as a container with its own memory and runtime resources.
- The JVM process then creates multiple threads, also known as lightweight processes.
- These threads share JVM process-defined resources like memory, files since they belong to the process and threads are just like child processes of the process.
- But each child process, aka thread, still has its own things like working space, stack (to store method frames to store the state of method invocation which includes values of local variables, method parameters, method return values, exception handlers parameters, and intermediate values) and PC registers.

### How to Create a Thread?
There are two ways to create a thread in Java:
1. Extend the `Thread` class and override its `run()` method.
2. Implement the `Runnable` interface and override its `run()` method.


// Extending Thread class
public class Sing extends Thread {
    public void run() {
        // code here will execute when actual execution starts.
    }
}

public static void main(String args[]) {
    Thread sing = new Sing();
    sing.start();
}

// Implementing Runnable interface
public class Sing implements Runnable {
    @Override
    public void run() {
        // code here will execute when actual execution starts.
    }
}

public static void main(String args[]) {
    Thread sing = new Thread(new Sing()); // Instantiate thread by passing instance of Runnable to Thread constructor
    sing.start(); // start thread.
}

## Thread Lifecycle
A thread goes through various stages in its lifecycle. For example, a thread is born, started, runs, and then dies. The following diagram shows the complete life cycle of a thread.

Thread States:

NEW: A thread that has not yet started is in this state.
RUNNABLE (Running or Ready to run): A thread executing in the Java virtual machine is in this state.
BLOCKED: A thread that is blocked waiting for a monitor lock is in this state.
WAITING: A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
TIMED_WAITING: A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
TERMINATED: A thread that has exited is in this state.
A thread can be in one of the following states:

NEW: The thread is in new state if you create an instance of Thread class but before the invocation of start() method.
RUNNABLE: The thread is in runnable state after invocation of start() method, but the thread scheduler has not selected it to be the running thread.
RUNNING: The thread is in running state if the thread scheduler has selected it.
NON-RUNNABLE (Blocked): This is the state when the thread is still alive, but is currently not eligible to run.
TERMINATED: A thread is in terminated or dead state when its run() method exits.

## Shared Data Protection
Remember threads aka lightweight processes aka child processes share memory of the process. This creates a problem of how to protect shared data? We can protect shared data by only allowing one thread to access shared data at a given time, or using immutable classes, or using volatile variables.

What are the shared data?

Method area includes class info like all variables methods.
Static variables per class loader
Heap includes objects created. i.e for a class objects are created that allows to access class info like variables and methods.
What are NOT the shared data?

Java stack includes (when thread began method execution it creates method frames and adds to stack)
Method parameters
Method return values
Intermediate values
Local variables
Exception handler parameters
PC registers which contain the next executable instructions.
How to Protect?

Making Thread safe i.e. Making your applications thread safe means securing your shared data so that it stores correct data, even when it’s accessed by multiple threads. Here we are talking about safeguarding Shared DATA.
Object Lock and monitors:

Every object has its own lock and let’s say a method of that object called by 2 threads will be synchronized i.e. no concurrent allow for 2 threads in this case.
If two different objects then both have their own lock and they are not aware of each other i.e. thread 1 can call method A of object A and thread 2 can call method A of object B at the same time.
Every java object has a monitor which can be locked or unlocked by a thread at a given time only one thread. and that thread calls as monitor owner. A thread can release a lock on a monitor if

it has done its task
Here it’s done and unlock
it needs to wait for another operation to complete.
Here it enters in a pool of threads those are waiting to re-lock monitor. basically wait() or yield() make this happens.
waiting over when someone calls notify() or notifyAll() so that these threads can re-lock monitor.
Synchronized Method:

Both instance and static methods as synchronized methods.
This prevents multiple threads from modifying the shared data in a manner that leads to incorrect values
How? When a thread invokes this synchronized method it automatically locks

# Deadlock

Deadlock is a situation where a set of threads are blocked because each thread is holding a resource and waiting for another resource acquired by some other thread. Deadlock can occur when multiple threads need the same locks but obtain them in different order. If a thread holding locks on multiple objects invokes a blocking method, other threads that also need to lock these objects will be blocked.

# Starvation

Starvation describes a situation where a thread is unable to gain regular access to shared resources and is unable to make progress. This happens when shared resources are made unavailable for long periods by “greedy” threads. For example, suppose an object provides a synchronized method that often takes a long time to return. If one thread invokes this method frequently, other threads that also need frequent synchronized access to the same object will often be blocked.

# Livelock

A thread often acts in response to the action of another thread. If the other thread’s action is also a response to the action of another thread, then livelock may result. As with deadlock, livelocked threads are unable to make further progress. However, the threads are not blocked — they are simply too busy responding to each other to resume work. This is comparable to two people attempting to pass each other in a corridor: Alphonse moves to his left to let Gaston pass, while Gaston moves to his right to let Alphonse pass. Seeing that they are still blocking each other, Alphonse moves to his right, while Gaston moves to his left. They’re still blocking each other, so…

# Happens-Before Relationship

In concurrent programming, the happens-before relationship is a relation between the result of one operation and the start of another operation. If one operation happens before another, then the results of the first operation are visible to the second. For example:

- The start of a thread happens before any actions in the thread.
- The end of a thread happens before the join with that thread returns.
- An unlock on a monitor lock happens before any subsequent lock on the same monitor lock.
- A write to a volatile field happens before every subsequent read of that field.


## Concurrency:

- Concurrent collection classes (java.util.concurrent package includes)

    - BlockingQueue:
        - Safe to use when shared between multiple threads.
        - Implemented by ArrayBlockingQueue.
        - Works on the producer–consumer pattern, which is when a single thread or multiple threads produce elements and add them to a queue to be consumed by other threads.
        - Use Case: 
            - Multiple clients (producers) that send requests to a server and server responds to all request that it received.
            - Server can limit max # of request it can accept at a given point of time.
            - Request can be added to blocking Q which will block adding new request if it reaches its upper limit.
            - Similarly if no new request are available in Q server thread will block until request are made available ot it.
        - Example:
           
            BlockingQueue<Request> queue = new queue ...
            queue.put();
            

    - ConcurrentMap: 
        - Implemented by ConcurrentHashMap. (work like HashMap)
        - It defines methods to replace or remove a key-value pair if the key is present
        - Or add a value if the key is absent
        - Use Case:
            - HashMap is unsynchronised collection and not thread safe and if make synchronised then performance problem.
            - ConcurrentHashMap is the answer to improving the responsiveness of HashMap when it needs to be accessed concurrently by multiple threads.
            - HashMap with Synchronised is exclusively locking itself to be accessed by one thread.
            - ConcurrentHashMap concurrently allows multiple threads to read its values and limited threads to modify its values.
            - ConcurrentHashMap don’t throw a ConcurrentModificationException so no need to lock. and The iterator may still traverse only the elements that existed at the time of creation of the iterator and may not reflect new added item in collection.
            - BUT sizd() may not return correct value.
        - Example: 
           
            ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();
            map.containksKey("abc");
            map.put(1,"abc");
            map.replace(key,value);
            

    - ConcurrentNavigableMap: Support approximate matches and implemented by ConcurrentSkipListMap.

- Locks:
    - Recall synchronised method they do implicit locking that is not good so lets learn explicit locking for better or finer locking control. Good that if no explicit lock found then synchronised method will use implicit lock.
    - For explicit we use "LOCK" and this Lock objects support interruptible lock waits, nonblock- structured locks, multiple condition variables, lock polling, scalability benefits.
    - How to use?
        - Acquire Lock:
           
            Lock mylock = new REentrantLock(); //lock object
            mylock.lock(); // acquire lock and if not there then wait.
            mylock.unlock();//unlock it.
            
        - Acquire and release immediately.
            - Unlike waiting to acquire an implicit lock on objects Explicit lock with tryLock() which return immediately.
            - Example:
               
                if (loc1.lock.tryLock()) { // return true of acquired lock
                    if (loc2.lock.tryLock()) { // return true of acquired lock
                    //do work 
                    }
                }
                
        - Interruptible lock: 
            - There are locks can be interuppted or timed out by it self after certain time. 
            - Its not guaranteed that it will interrupt bcs it depends upon how the thread is executed waiting to acquire a lock or locked it or it has already completed the code.
            - Example: Interuptable
               
                Lock lock = new ReentrantLock();
                lock.lockInterruptibly(); //defined interuptable lock 
                //ready to catch InterruptedException in case of interuptted.
                threadObj.interrupt(); // trigger interupption.
                
        - Non blocked structured lock
            - When using intrinsic lock it can not be expand beyong mehtod or { } blocked statment.
            - Extrinsic locks can be acquired across methods
            - Example:
               
                class Bus {
                ReentrantLock lock = new ReentrantLock();
                method1(){
                    lock.tryLock();
                }
                method2(){
                if (lock.isHeldByCurrentThread() && locked)//pre conditions
                    lock.unlock();
                }
                
        - Read write locks:
            - Interface ReadWriteLock maintains a pair of associated locks, one for read-only operations and another for write-only operations.
            - Read lock can be acquired by multiple thread and write by only ONE.
            - ReentrantReadWriteLock: is implementation of Interface.
            - Example:
               
                ReadWriteLock myLock = new ReentrantReadWriteLock();
                myLock.writeLock().lock();
                myLock.readLock().lock();
                
        - Atomic variables:
            - java.util.concurrent.atomic package defines multiple classes that support atomic operations of read-compare/modify-write on single variables.
            - These operations might seem similar to the operations with volatile variables.
            - Example:
               
                AtomicInteger copiesSold = new AtomicInteger(0);
                copiesSold.incrementAndGet()
                copiesSold.decrementAndGet();
                

- Executors Framework:
    - Why?
        - Thread and Runnable Interface are ok for small app but not for heugh app that is why use Executors framework.
        - Executors framework enables decupling of task submission with task execution. What does it mean?
        - i.e. using Executors framework we can create task using Interface Runnable and Callable then this task are submitted to Executors to launch new Task.
        - ExecutorsService extendes Executors and add more methods on top of it to manage lifecycle of submitted task and executors.
        - ScheduledExecutorService extendes Executors and supports future or periodic execution of task.
    - TODO: remaining..

- Parallel fork/join framework:
    - What?
        - To take advantage of multi core processor.
        - Fork/join is best suited for task that are processor intesive, that can be divide in to smaller task, that can run parallel. 
        - Fork/join is not suited for task that block, need synchronisation or IO operation.
        - Fork/join works on principle of divide-conqure i.e divide task recursivly, operate on it and merge result back.
        - Fork/join i.e fork task in to subtask operate on it and merge i.e join result back.
        - Fork/join is NOT for small task.
    - ForkJoinPool is a concrete implementation of the fork/join framework.
    - It implements the ExecutorService interface
    - Like ExecutorService, fork/join framework maitains Queue where all task are added later each task assigned to framwork`s multiple worker thread.
    - BUT its still differnt than ExecutorService since its implemented on work-stealing algorithm.
    - Here when mutliple worker thread are working on assigned task and if any worker thread run out of ask it will steam it from another thread to avoid blocking waiting thread. 
        - How they do? 
            - They i.e worker thread have their own Queue using DeQueue which has their assigned task are there.
            - New task are pushed to worker thread Dequeue
            - Rather waiting for new task thread pop out taks from their Dequeue and work on it.
            - When thread runs out of all task from its Dequeue itwil steal from another thread Dequeue tail.
    - ForkJoinPool provides entry point
    - ForkKJoinClass is abstract for the task that runs in ForkJoinPool and our custom class should extend ForkKJoinClass.
    - There are two more abstract classes RecursiveTask and RecursiveAction which base class is ForkKJoinClass
    - RecursiveAction is only for computation and do not return result.
    - i.e we and either extend base class or either of two subclasses.


## JDBC - Java Database Connectivity
- Why JDBC?
    - There are multiple approaches and technologies to connect a Java application with a database, such as EJB entity beans, JPA, Java Database Object (JDO), and others. Hibernate is considered one of the best implementations of JPA as an ORM framework.
    - However, each of these has its advantages and disadvantages. In contrast, JDBC is simple, has been around since Java 1.1, and works with both Java SE and Java EE.
    - JDBC is an industry-standard, database-independent connection from Java applications to various types of databases, including RDBMS, flat-file databases, or spreadsheet databases.
    - The JDBC API defines multiple interfaces that must be implemented by the database vendors or a third party. These implementations are supplied as drivers.
    - As of Java 7, JDBC version 4.1 is included. JDBC classes are defined in the Java packages `java.sql` and `javax.sql`.
        - Initially, `javax` was used only for Java EE.
        - However, this changed with JDBC 3.
        - Now, both packages are part of JDBC in Java SE.
    - The JDBC API classes can connect to a database, run SQL against it, and process the results.

- JDBC Drivers:
    - The JDBC API includes two major sets of interfaces:
        - The JDBC API for application developers.
        - The lower-level JDBC driver API for writing drivers.
            - There are four types of drivers:
                - Type 4—Pure Java JDBC driver.
                - Type 3—Pure Java driver for database middleware.
                - Type 2—Native API, partly Java driver.
                - Type 1—JDBC-ODBC bridge.
        - Typically, you only need to connect with the Type 4 JDBC driver, which is the pure Java JDBC driver.

- `java.sql.Driver`:
    - The JDBC API defines multiple interfaces, and the implementation of these interfaces is bundled in a driver and made available to the Java application.
    - Java allows multiple drivers to exist and be registered.
    - These interfaces are defined in `java.sql.Driver`.
    - The class or driver which implements these interfaces is registered with DriverManager. When a Java application requests a connection, DriverManager searches for an appropriate driver from the list of registered drivers to connect to the database.
    - Although not recommended, registration and selection of a driver can be done manually by calling the method `forName()` from `java.lang.Class`.
        - For example, the `java.sql.driver` interface is implemented by the MySQL driver class as `com.mysql.jdbc.Driver`. This can be added as `Class.forName("com.mysql.jdbc.Driver")`.
    - It is the driver that converts JDBC application calls into database calls.

- `java.sql.Connection`:
    - Represents a connection.
    - Used to create the SQL Statement, PreparedStatement, and CallableStatement, which can be executed against database objects.
    - Used to initiate transactions.
    - Also used to get metadata for the database.

- `java.sql.Statement`:
    - Used to create and execute static SQL statements and retrieve their results.
    - Used to create, modify, delete tables or insert, retrieve, modify, and delete table data.
    - The result from the database is returned as a ResultSet or an int value showing the number of affected rows.
    - `java.sql.PreparedStatement` and `java.sql.CallableStatement` are used for precompiled statements and `java.sql.CallableStatement` is used for stored procedures.

- `java.sql.ResultSet`:
    - Retrieves the result for SQL select statements.
    - A ResultSet can be read-only, updatable, or scrollable.

- Connecting to a Database:
    - For the first time, a JDBC client gets a connection from the JDBC API (Driver Manager), which looks for registered drivers and provides a connection object.
    - From the second time onwards, a JDBC client uses a connection object to connect to the database.

    - How is the driver loaded?
        - Manually, as mentioned earlier.
        - Automatically, in JDBC 4.0 and later.
            - Registration and loading are done via the application classpath.
            - Who and how does this happen?
                - The Service Provider Mechanism (SPM) does this.
                - Using SPM, a JDBC driver implementation must include a configuration file named `Java.sql.Driver` within the `META-INF/Services` folder in the .jar file.
                - This file contains the full name of the class that the vendor implemented for the `java.sql.driver` interface.
                - For example, `com.mysql.jdbc.Driver` is the name of the MySQL driver.

    - What code should be written to connect?
        - When `getConnection()` is called, the DriverManager finds the appropriate drivers from its set of registered drivers, establishes a connection with a database, and returns a Connection object.
        - `public static Connection getConnection(String url)...`
            - URL 
                - `jdbc:subprotocol://<host>:<port>/<database_name>`
                - For example:
                    - `jdbc:mysql://localhost/feedback?user=sqluser&password=sqlpwd"`
                        The default port for MySQL is 3306.
                    - `jdbc:mysql://data.ejavaguru.com:3305/examDB`
                    - `jdbc:mysql://localhost:3305/mysql?connectTimeout=0`

    - Exceptions it throws:
        - `java.sql.SQLException: No suitable driver found`
        - `java.sql.SQLException: Access denied for user`

- CRUD Operations:
    - Create Table Code 

        java
        Connection con = getConnection(...);
        Statement st =  con.createStatement();
        st.executeUpdate("Create Table..."); //to execute a Data Definition Language (DDL)
        

    - Insert Record in Table

        java
        Statement st =  con.createStatement();
        int ret = st.executeUpdate ("INSERT INTO book..");
        

    - Update Record in Table    

        java
        Statement st =  con.createStatement();
        int ret = st.executeUpdate ("UPDATE book..");
        

    - Delete Record in Table    

        java
        Statement st =  con.createStatement();
        int ret = st.executeUpdate ("Delete from book..");
        

    - Read Record in Table    

        java
        Statement st =  con.createStatement();
        ResultSet res = st.executeQuery ("select * from book..");
        while (res.next()) {
            res.getString("title")// title is column name.
            res.getIntg("totalexperience")// totalexperience is column name.
        }
        

    - Transaction 

        java
        Connection con = getConnection(...);
        con.setAutoCommit(false); //START TRANSACTION BY CALLING 
        Statement st =  con.createStatement();
        int ret = st.executeUpdate ("INSERT INTO book..");
        int ret = st.executeUpdate ("Delete from book..");
        con.commit(); //commit to all db.
        //or..
        con.rollback(); //rolling back transaction.
        

- Rowset Object:
    - A ResultSet would do the work but it will not update the result if there is a change in the underlying data in the database.
    - A Rowset helps here by registering a listener with the Rowset object. Then any change made to the underlying data in the database is notified to this registered listener.
    - There are two types of Rowset objects    
        - Connected, `JdbcRowSet` is an implementation that keeps an open connection.
        - Disconnected, `CachedRowSet` is an implementation that connects to the database, gets the values, and disconnects. It keeps accepting updates and then later updates the database by reconnecting to it.

    - `javax.sql.rowset.RowSetFactory` has all interfaces.
    - Example code:

        java
        RowSetFactory rowSetFactory = RowSetProvider.newFactory(); 
        JdbcRowSet jdbcRS = rowSetFactory.createJdbcRowSet();
        jdbcRS.setUrl("dbc:mysq..);
        jdbcRS.setCommand("Select...);
        jdbcRS.execute();
        while (jdbcRS.next()) {
        //...same as Resultset...
        }

      
# Java 9, 10, and 11 Features

## Modules
Modules were introduced.

## CompletableFuture API
A new static method was introduced that submits a task to the default executor after the given delay.


## Reactive Streams API
Reactive Programming has become very popular in developing applications to get some beautiful benefits. Scala has this reactive streaming.

## Diamond Operator for Anonymous Inner Class
The diamond operator for anonymous inner classes has been removed.



## Optional Class Improvements
The `stream()` method was added to work on Optional objects lazily.


## Stream API Improvements
The `takeWhile()` method takes a predicate as an argument and returns a Stream of the subset of the given Stream values until that Predicate returns false for the first time.

      

## Factory Methods for Immutable List, Set, Map and Map.Entry
Java SE 8 and earlier versions had `Collections.unmodifiableList` or `Collections.unmodifiableSet` etc but now we have:


## Oracle JDK vs Open JDK
In order to be more developer-friendly, Oracle & Java community now promotes the OpenJDK binaries as primary JDK going forward.

## Local-Variable Type
Parsing a `var` statement, the compiler looks at the right-hand side of the declaration, aka initializer, and it infers the type from the right-hand side (RHS) expression.

## Java 11 / JDK
Java 11 is the second LTS release after Java 8. Since Java 11, Oracle JDK would no longer be free for commercial use.

## Running Java File with single command
No need to compile the java source file with `javac` tool first. You can directly run the file with `java` command and it implicitly compiles.

## String
Several new methods were introduced such as `isBlank()`, `lines()`, `strip()`, `stripLeading()`, `stripTrailing()`, and `repeat(int)`.

## Local Var
Now allowing below syntax for lambda.


## Compact Strings
Compact Strings were introduced.


