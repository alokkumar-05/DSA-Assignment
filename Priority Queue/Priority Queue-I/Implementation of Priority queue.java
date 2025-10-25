import java.util.PriorityQueue;

/*
Problem Name: PriorityQueue Operations (Insert, Find, Delete Max)
Data Structure: PriorityQueue
*/

 class PriorityQueueHelper {

    public static void insert(PriorityQueue<Integer> q, int k) {
        q.add(k);
    }

    public static boolean find(PriorityQueue<Integer> q, int k) {
        return q.contains(k);
    }

    public static int delete(PriorityQueue<Integer> q) {
        if (!q.isEmpty()) {
            return q.poll();
        }
        return -1;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // max-heap

        insert(pq, 10);
        insert(pq, 5);
        insert(pq, 20);

        System.out.println("Find 10? " + find(pq, 10)); // true
        System.out.println("Delete max: " + delete(pq)); // 20
        System.out.println("Delete max: " + delete(pq)); // 10
    }
}

/*
---------------------------------
Logic:
1. insert() -> q.add(k)
2. find()   -> q.contains(k)
3. delete() -> q.poll()
---------------------------------
Complexity:
- Insert: O(log n), Find: O(n), Delete Max: O(log n)
*/
