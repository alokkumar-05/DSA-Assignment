
import java.util.*;

/*
Problem Name: Design HashMap
Problem Number: LeetCode 706
Problem Link: https://leetcode.com/problems/design-hashmap/
*/

 class MyHashMap {

    // Node class for storing key-value pairs
    private static class Node {
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000; // total buckets
    private List<Node>[] map;

    // Constructor
    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    // Hash function for indexing
    private int hash(int key) {
        return key % SIZE;
    }

    // Insert or update a key-value pair
    public void put(int key, int value) {
        int idx = hash(key);
        if (map[idx] == null) map[idx] = new LinkedList<>();

        // Update if key exists
        for (Node node : map[idx]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }

        // Add new entry
        map[idx].add(new Node(key, value));
    }

    // Retrieve value by key
    public int get(int key) {
        int idx = hash(key);
        if (map[idx] == null) return -1;

        for (Node node : map[idx]) {
            if (node.key == key) return node.value;
        }
        return -1;
    }

    // Remove key-value pair
    public void remove(int key) {
        int idx = hash(key);
        if (map[idx] == null) return;

        Iterator<Node> it = map[idx].iterator();
        while (it.hasNext()) {
            Node node = it.next();
            if (node.key == key) {
                it.remove();
                return;
            }
        }
    }
}

/*
----------------------------------------
Logic Summary:
1. Uses modulo hashing (key % SIZE)
2. Handles collisions using LinkedLists
3. Supports CRUD operations:
   - put(): Insert or update
   - get(): Retrieve value
   - remove(): Delete entry
----------------------------------------
Complexity:
Time: O(1) average
Space: O(n)
----------------------------------------
*/
