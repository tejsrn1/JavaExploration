package aa_learning.java.ds;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class do_ds {

    // Collection interface is the root interface of collection framework.
    // collection framework includes other sub interfaces like LIST, QUEUE , MAP AND SET , ITERATOR etc.
    // collection framework also includes classes that implements above interfaces e.g. Arraylist, LinkedList etc.

    public void do1() {
        // List collection interface
        // Arraylist, LinkedList, Vector and Stack are implementations.

        //Arraylist
        // implemented by resizable array.
        var arrayList = new ArrayList<>();
        arrayList.add("ABC");
        arrayList.add("PQR");

        arrayList.get(1);
        arrayList.set(2, "OOE");
        arrayList.remove(2);

        for (var item : arrayList) {
            System.out.println(item);
        }

        //vector z_old_dsalog.do_ds.ds synchronizes each individual operation i.e. automatically applies lock
        var vecotrList = new Vector<>();
        vecotrList.add("abc");


        //stack
        var stackList = new Stack<String>();
        stackList.push("1"); // add on top of stack.
        stackList.pop(); //remove
        stackList.peek(); //view only
        stackList.search("2");


        // Linkedlist as List
        // Implemnted by doubly linked list DS.
        // can not randomly access from index.
        var listLink = new LinkedList<Double>();
        listLink.add(32.33);
        listLink.add(392.232);

        listLink.get(2); // get it at index

        listLink.set(2, 34.22);

        listLink.remove(1);// remove from at index.

        // iterator
        var iterato = listLink.iterator();
        for (var i : listLink) {

        }

    }


    public void do2() {

        // Queue interface
        // other interface which extends main interface are Dequeue, BlockingQueue, BlockingDequeue
        // ArrayDequeue, LinkedList and PriorityQueue are implmenentation.

        // PQ : elements received are in sorted order but not stored as stored.
        //default is ascending.
        var prorityQ = new PriorityQueue<Integer>();

        var priorityQWithCustomComparator =  new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer i, Integer i2){
                return 0;
            }

        });


        prorityQ.add(4);
        prorityQ.add(2);
        var d = prorityQ.offer(1); // if Q is full it returns false

        prorityQ.peek();//view only
        prorityQ.poll();// return and remove elements.

        prorityQ.remove(3); // remove item at given index

        var iterateor = prorityQ.iterator();
        while (iterateor.hasNext()) {
            var i1 = iterateor.next(); // get the item
        }


        //Dequeue.
        // We can insert and remove elements from both end of Queue.
        // Note :  recommended to use Deque as a stack not acutal Stack class.


        // Does not support null addition.
        // Requires less storage
        // faster than linked list.
        var deQ1 = new ArrayDeque<>();

        deQ1.addFirst(1);
        //deQ1.addLast(4);
        deQ1.pollLast();
//        deQ1.pollFirst();
        deQ1.peekFirst();
        deQ1.offerFirst(32);
        deQ1.getFirst();

        var regularIteratpr = deQ1.iterator(); // A - B - C
        var reverseIterator = deQ1.descendingIterator();  // C- B - A


        // LinkedList as Queue and Dequeue.
        // allow null to insert.
        // requires more storages as both next and prev ref needs to maintian.
        // slower than Arraydequeue

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


        // Blocking Queue interface :: A thread safe collection. allows each thread to complete its operation while other thread will wait.
        // Usage :
        // -- It allows any operation to wait until it can be successfully performed
        // -- e.g. take() delete operation on empty Q will wait un till Q contains some element to delete.
        // -- e.g. put() will insert element and if Q is full it will wait till Q has space.
        // java.util.concurrent.BlockingQueue package.
        // ArrayBlockingQueue and LinkedBlockingQueue are implementations.


        // Array blocking Q
        // uses arrays as internal storage.
        // thread safe
        var arrBlockingQ = new ArrayBlockingQueue<String>(20);


        arrBlockingQ.add("a"); // add without blocking.
        arrBlockingQ.offer("2"); //add without blocking.
        arrBlockingQ.peek(); // view wo blocking
        arrBlockingQ.remove();// wo blocking
        arrBlockingQ.poll();// wo blocking
        arrBlockingQ.clear();// wo blocking
        arrBlockingQ.iterator();

        try {
            arrBlockingQ.put("must add"); //  wait till elements added.
            arrBlockingQ.take();//return and remove an element and waits till happens.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Linked Q and DeQ.
        // no need for initial capacity required and default is 2 ^31-1.

        var linkedBlockingQ = new LinkedBlockingQueue<>();
        var linkedBlockingQWCapacity = new LinkedBlockingQueue<>(25);
        var linkedBlockingDeQ = new LinkedBlockingDeque<>();

        // other methods are same as regular Q.except put and take are blocking

        try {
            linkedBlockingDeQ.put("3");
            linkedBlockingQ.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void do3() {

        // Map k- v pair Interface
        // contains keys, values and pair as diff sets for us to access.
        // NO duplicate KEY
        // Sub interfaces are SortedMap, Concurrent Map etc.
        // HashMap,EnumMap,LikedHashMap, Tree Map are implementations.
        //java.util.Map package


        // HashMap
        //java.util.HashMap package
        // default created with 16 capacity and 0.75 load factor
        // 16 entries
        // 0.75 == hash table is filled by 75%, the entries are moved to a new hash table double the size of the original hash table

        HashMap<String, Integer> hashMp = new HashMap<>();
        var hashMp2 = new HashMap<String, Integer>();

        hashMp.put("Java", 8); // add
        hashMp.put("Python", 11);// add
        hashMp.putIfAbsent("Java", 10);
        System.out.println(hashMp); //{Java=8, Python=11}


        hashMp.get("Python"); // get value of given key.

        var keys = hashMp.keySet(); //[Java, Python]
        var values = hashMp.values();//[8,11]
        var pairs = hashMp.entrySet(); // Java=8 , Python = 11

        hashMp.remove("Java", 11);// updates values.
        hashMp.remove("Python"); // removes entry

        hashMp.containsKey("Python"); // key exits or not.
        hashMp.containsValue(12); // values exits or not.

        // Iterate thr key

        for (var key : hashMp.keySet()) {
        }
        for (var key : hashMp.values()) {
        }

        for (Map.Entry<String, Integer> pair : hashMp.entrySet()) {
            var a = pair.getKey();
            var b = pair.getValue();
        }

        // Map from another map

        var othermap = new TreeMap<String, Integer>();
        var newMap = new HashMap<String, Integer>(othermap);


        //LinkedList Hashmap
        // require more storage.
        // used doubly  linked list behind.
        // slower than HashMap
        var linkedHashMp = new LinkedHashMap<String, String>();


        // WeakHashmap
        // Keys of map are garbage collected if not ref any more.
        var weakHash = new WeakHashMap<>();


        //
    }

    public void do4() {

        // SortedMap is sub interface of Map
        // TreeMap is implementation.
        // Regular Map method works but apart from it
        // comparator() ,firstKey(), lastKey() ,
        // headMap(Key) : all keys < given key,
        // tailMap(key) :all key > given key
        //subMap(key1, key2) : all keys between Key1 and Key2

        //Navigable Map is subinterface of SortedMap
        // TreeMap is the implementatin.
        // some of the methods of SortedMap (headMap(), tailMap(), and subMap() ) are defined differently in NavigableMap

        var treeMap = new TreeMap<>();
        var treeMap1 = new TreeMap<Integer,Integer>(new Comparator<Integer>() {
            public  int compare(Integer i1, Integer i2){
                return 0;
            }
        });


        //Concurrent Map is sub interface of Map.
        //ConcurrentHashMap is impmementation.
        //java.util.concurrent.ConcurrentMap
        // Thread safe map i.e. synchronized map
        //allows multithread to access entires concurrently.
        //default 16 thread allows concurrently as hashmap divided in 16 segments.
        // multiple threads can access the map at once without affecting the consistency of entries in a map.

        var concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.putIfAbsent(4, "abc");

        concurrentMap.forEach(3, (k, v) -> System.out.println(k));
        //specifies that after how many elements operations in a map are executed in parallel

        concurrentMap.search(3, (k, v) -> {
            return v.equals(3) ? k : null;
        });
    }

    public void do5() {

        // set interface.
        // sortedSet and Navigableset are sub interfaces.
        // hashset, LinkedHashset , TreeSet are implmentation.
        //java.util.Set
        // NO Duplicate allowed.


        //HashSet

        var setHash = new HashSet<String>(8, 0.75F);
        setHash.add("tejpal");
        setHash.add("5");
        setHash.remove("5");


        var iterator = setHash.iterator();
        //hasNext() returns true if there exists an element
        while (iterator.hasNext()) {
            var d = iterator.next();
            //next() returns the next element of the collection

        }


        // LinkedHashSet
        // Elements of LinkedHashset are stored in hash tables similar to HashSet
        // LinkedHashset maintains insertion order
        // require more storage due to doubly linked list used
        // slower than hasshet.
        // java.util.LinkedHashSet


        var linkedHashSet = new LinkedHashSet<Integer>();


        //SortedSet interface.
        // TreeSet implements it.
        // stores sorted non duplicate items.


        var sortedSet = new TreeSet<String>();

        var sortedSetWithComparator = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        sortedSet.headSet("10");//returns all the elements of the set before the specified element

        sortedSet.tailSet("34");//returns all the elements of the set after the specified element including the specified element

        sortedSet.subSet("10", "35"); //  returns all the elements between the element1 and element2 including element1

    }
}
