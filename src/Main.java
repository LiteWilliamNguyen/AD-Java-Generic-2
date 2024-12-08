import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(1);
        integers.add(2);
        SortUtility.sort(integers);
        System.out.println(integers); // Output: [1, 2, 3]

        ArrayList<String> strings = new ArrayList<>();
        strings.add("B");
        strings.add("A");
        strings.add("C");
        SortUtility.sort(strings);
        System.out.println(strings); // Output: [A, B, C]

        //Part 2: Using Generic in Collection
        ArrayList<Integer> integerCollection = new ArrayList<>();
        integers.add(3);
        integers.add(1);
        integers.add(2);
        SortUtility.sort(integerCollection);
        System.out.println(integerCollection); // Output: [1, 2, 3]

        ArrayList<String> stringCollection = new ArrayList<>();
        strings.add("B");
        strings.add("A");
        strings.add("C");
        SortUtility.sort(stringCollection);
        System.out.println(stringCollection); // Output: [A, B, C]
    }
}
//Multi-Type Generic Pair
//
//Implement a generic Pair<K, V> class where K represents the key type and V represents the value type.
//Include methods to get and set the key and value, as well as a toString() method to print the key-value pair.
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" + "key=" + key + ", value=" + value + '}';
    }
}

//Generic Stack
//
//Develop a generic Stack<T> class that allows pushing and popping elements of any type.
//Implement methods for push, pop, and checking if the stack is empty.
class Stack<T> {
    private ArrayList<T> elements;

    public Stack() {
        this.elements = new ArrayList<>();
    }

    public void push(T element) {
        elements.add(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow: No elements to pop.");
        }
        return elements.remove(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}

//Part 2
//Using Generics in Collections
//Generic Sort Utility
//
//Write a static generic method sort in a utility class that sorts an ArrayList<T> where T extends Comparable<T>.
//Demonstrate the usage of this method by sorting lists of various comparable types, such as Integer, String, and a custom class that implements Comparable.
class SortUtility {
    public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
        Collections.sort(list);
    }
}

//Part 3: Complex Generic Scenarios
//Generic Cache Implementation
//Design and implement a Cache<T> class that can store instances of type T. The cache should have methods to add items, retrieve items by key, and clear the cache.
//Utilize bounded wildcards to implement a method addAll that can add all items from one cache to another, provided they are of compatible types.
class Cache<T> {
    private Map<String, T> cache;

    public Cache() {
        this.cache = new HashMap<>();
    }

    public void add(String key, T value) {
        cache.put(key, value);
    }

    public T get(String key) {
        return cache.get(key);
    }

    public void clear() {
        cache.clear();
    }

    public void addAll(Cache<? extends T> other) {
        for (Map.Entry<String, ? extends T> entry : other.cache.entrySet()) {
            this.cache.put(entry.getKey(), entry.getValue());
        }
    }
}