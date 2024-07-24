package javaExpo;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class BuiltInDS {


    /**
     * This method demonstrates the use of various List implementations in Java.
     * The List interface is part of the Java Collections Framework, which also includes interfaces like Queue, Map, Set, and Iterator.
     * Classes that implement these interfaces include ArrayList, LinkedList, Vector, and Stack.
     */
    public void do1() {
        // ArrayList is a resizable array implementation of the List interface.
        var arrayList = new ArrayList<>();
        arrayList.add("ABC");
        arrayList.add("PQR");

        // Retrieves the element at the specified position in this list.
        arrayList.get(1);
        // Replaces the element at the specified position in this list with the specified element.
        arrayList.set(2, "OOE");
        // Removes the element at the specified position in this list.
        arrayList.remove(2);

        // Enhanced for loop for iterating over the ArrayList.
        for (var item : arrayList) {
            System.out.println(item);
        }

        // Vector is a synchronized implementation of the List interface.
        var vectorList = new Vector<>();
        vectorList.add("abc");

        // Stack is a Last-In-First-Out(LIFO) data structure which represents a stack of objects.
        var stackList = new Stack<String>();
        // Pushes an item onto the top of this stack.
        stackList.push("1");
        // Removes the object at the top of this stack and returns that object as the value of this function.
        stackList.pop();
        // Looks at the object at the top of this stack without removing it from the stack.
        stackList.peek();
        // Returns the 1-based position where an object is on this stack.
        stackList.search("2");

        // LinkedList is a doubly-linked list implementation of the List and Deque interfaces.
        var listLink = new LinkedList<Double>();
        listLink.add(32.33);
        listLink.add(392.232);

        // Retrieves the element at the specified position in this list.
        listLink.get(2);
        // Replaces the element at the specified position in this list with the specified element.
        listLink.set(2, 34.22);
        // Removes the element at the specified position in this list.
        listLink.remove(1);

        // Returns an iterator over the elements in this list in proper sequence.
        var iterator = listLink.iterator();
        for (var i : listLink) {

        }
    }

    /**
     * This method demonstrates the use of various Queue implementations in Java.
     * The Queue interface is part of the Java Collections Framework, which also includes interfaces like List, Map, Set, and Iterator.
     * Classes that implement these interfaces include PriorityQueue, ArrayDeque, LinkedList, and others.
     */
    public void do2() {
        // PriorityQueue is an unbounded queue based on a priority heap and the elements of the priority queue are ordered by default in natural order.
        var priorityQ = new PriorityQueue<Integer>();

        var priorityQWithCustomComparator = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer i, Integer i2) {
                return 0;
            }
        });

        // Inserts the specified element into this priority queue.
        priorityQ.add(4);
        priorityQ.add(2);
        // Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
        var d = priorityQ.offer(1);
        // Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
        priorityQ.peek();
        // Retrieves and removes the head of this queue, or returns null if this queue is empty.
        priorityQ.poll();
        // Removes a single instance of the specified element from this queue, if it is present.
        priorityQ.remove(3);

        // Returns an iterator over the elements in this queue.
        var iterator = priorityQ.iterator();
        while (iterator.hasNext()) {
            var i1 = iterator.next();
        }

        // ArrayDeque is a resizable-array implementation of the Deque interface. Array deques have no capacity restrictions and they grow as necessary to support usage.
        var deQ1 = new ArrayDeque<>();

        // Inserts the specified element at the front of this deque.
        deQ1.addFirst(1);
        // Removes and returns the last element of this deque.
        deQ1.pollLast();
        // Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
        deQ1.peekFirst();
        // Inserts the specified element at the front of this deque unless it would violate capacity restrictions.
        deQ1.offerFirst(32);
        // Retrieves, but does not remove, the first element of this deque. This method differs from peekFirst only in that it throws an exception if this deque is empty.
        deQ1.getFirst();

        // Returns an iterator over the elements in this deque in proper sequence.
        var regularIterator = deQ1.iterator();
        // Returns an iterator over the elements in this deque in reverse sequential order.
        var reverseIterator = deQ1.descendingIterator();

        // LinkedList is a doubly-linked list implementation of the List and Deque interfaces.
        Queue<Integer> qLink1 = new LinkedList<Integer>();

        qLink1.add(2);
        qLink1.add(3);
        qLink1.offer(34);
        qLink1.peek();
        qLink1.poll();

        Deque<Integer> dqLink1 = new LinkedList<Integer>();

        dqLink1.add(1);
        dqLink1.addLast(3);
        dqLink1.removeLast();
        dqLink1.offerLast(5);

        for (Integer i : dqLink1) {
            System.out.println(i);
        }

        // ArrayBlockingQueue is a bounded blocking queue backed by an array. This queue orders elements FIFO (first-in-first-out).
        var arrBlockingQ = new ArrayBlockingQueue<String>(20);

        arrBlockingQ.add("a");
        arrBlockingQ.offer("2");
        arrBlockingQ.peek();
        arrBlockingQ.remove();
        arrBlockingQ.poll();
        arrBlockingQ.clear();
        arrBlockingQ.iterator();

        try {
            // Inserts the specified element into this queue, waiting if necessary for space to become available.
            arrBlockingQ.put("must add");
            // Retrieves and removes the head of this queue, waiting if necessary until an element becomes available.
            arrBlockingQ.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // LinkedBlockingQueue is an optionally-bounded blocking queue based on linked nodes. The capacity, if unspecified, is equal to Integer.MAX_VALUE.
        var linkedBlockingQ = new LinkedBlockingQueue<>();
        var linkedBlockingQWCapacity = new LinkedBlockingQueue<>(25);
        var linkedBlockingDeQ = new LinkedBlockingDeque<>();

        try {
            linkedBlockingDeQ.put("3");
            linkedBlockingQ.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method demonstrates the use of various Map implementations in Java.
     * The Map interface is part of the Java Collections Framework, which also includes interfaces like SortedMap and ConcurrentMap.
     * Classes that implement these interfaces include HashMap, EnumMap, LinkedHashMap, TreeMap, and others.
     */
    public void do3() {
        // HashMap is a hash table based implementation of the Map interface.
        // It allows null values and the null key.
        HashMap<String, Integer> hashMp = new HashMap<>();
        var hashMp2 = new HashMap<String, Integer>();

        // Associates the specified value with the specified key in this map.
        hashMp.put("Java", 8);
        hashMp.put("Python", 11);
        // If the specified key is not already associated with a value (or is mapped to null) associates it with the given value.
        hashMp.putIfAbsent("Java", 10);

        System.out.println(hashMp);

        // Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
        hashMp.get("Python");

        // Returns a Set view of the keys contained in this map.
        var keys = hashMp.keySet();
        // Returns a Collection view of the values contained in this map.
        var values = hashMp.values();
        // Returns a Set view of the mappings contained in this map.
        var pairs = hashMp.entrySet();

        // Removes the entry for the specified key only if it is currently mapped to the specified value.
        hashMp.remove("Java", 11);
        // Removes the mapping for the specified key from this map if present.
        hashMp.remove("Python");

        // Returns true if this map contains a mapping for the specified key.
        hashMp.containsKey("Python");
        // Returns true if this map maps one or more keys to the specified value.
        hashMp.containsValue(12);

        // Iterating through the keys and values of the HashMap.
        for (var key : hashMp.keySet()) {
        }
        for (var key : hashMp.values()) {
        }

        for (Map.Entry<String, Integer> pair : hashMp.entrySet()) {
            var a = pair.getKey();
            var b = pair.getValue();
        }

        // Creating a new HashMap with the same mappings as the specified Map.
        var othermap = new TreeMap<String, Integer>();
        var newMap = new HashMap<String, Integer>(othermap);

        // LinkedHashMap is a hash table and linked list implementation of the Map interface, with predictable iteration order.
        var linkedHashMp = new LinkedHashMap<String, String>();

        // WeakHashMap is an implementation of the Map interface that stores only weak references to its keys.
        var weakHash = new WeakHashMap<>();
    }

    /**
     * This method demonstrates the use of various SortedMap and ConcurrentMap implementations in Java.
     * The SortedMap and ConcurrentMap interfaces are part of the Java Collections Framework.
     * Classes that implement these interfaces include TreeMap and ConcurrentHashMap.
     */
    public void do4() {
        // TreeMap is a Red-Black tree based NavigableMap implementation.
        var treeMap = new TreeMap<>();
        var treeMap1 = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return 0;
            }
        });

        // ConcurrentHashMap is a hash table based implementation of the ConcurrentMap interface.
        // This class provides a concurrent version of the java.util.Hashtable class.
        var concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.putIfAbsent(4, "abc");

        concurrentMap.forEach(3, (k, v) -> System.out.println(k));

        concurrentMap.search(3, (k, v) -> {
            return v.equals(3) ? k : null;
        });
    }

    /**
     * This method demonstrates the use of various Set implementations in Java.
     * The Set interface is part of the Java Collections Framework, which also includes interfaces like SortedSet and NavigableSet.
     * Classes that implement these interfaces include HashSet, LinkedHashSet, and TreeSet.
     */
    public void do5() {
        // HashSet is a hash table based implementation of the Set interface.
        // It makes no guarantees as to the iteration order of the set; in particular, it does not guarantee that the order will remain constant over time.
        var setHash = new HashSet<String>(8, 0.75F);
        setHash.add("tejpal");
        setHash.add("5");
        setHash.remove("5");

        var iterator = setHash.iterator();
        while (iterator.hasNext()) {
            var d = iterator.next();
        }

        // LinkedHashSet is a hash table and linked list implementation of the Set interface, with predictable iteration order.
        var linkedHashSet = new LinkedHashSet<Integer>();

        // TreeSet is a NavigableSet implementation based on a TreeMap.
        // The elements are ordered using their natural ordering, or by a Comparator provided at set creation time, depending on which constructor is used.
        var sortedSet = new TreeSet<String>();

        var sortedSetWithComparator = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        sortedSet.headSet("10");
        sortedSet.tailSet("34");
        sortedSet.subSet("10", "35");
    }
}
