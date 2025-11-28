

/*
Problem Name: Implement Trie (Prefix Tree)
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/implement-trie-prefix-tree/
*/

class TrieNode {
    TrieNode[] children = new TrieNode[26]; // supports lowercase letters a–z
    boolean isEnd = false; // marks end of a valid word
}

 class Trie {

    private final TrieNode root;

    // Step 1: Initialize Trie
    public Trie() {
        root = new TrieNode();
    }

    // Step 2: Insert word into Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEnd = true;
    }

    // Step 3: Search exact word
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return node.isEnd;
    }

    // Step 4: Check if any word starts with given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return true;
    }

    // Step 5: Example test
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }
}

/*
----------------------------------------
Logic Summary:
1. Each node stores 26 children for letters 'a'–'z'.
2. insert(): builds Trie nodes letter by letter.
3. search(): checks full word existence.
4. startsWith(): checks prefix presence.
----------------------------------------
Complexity:
Time: O(L)
Space: O(L)
----------------------------------------
*/
