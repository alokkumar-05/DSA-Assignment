
class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

 class Solution {

    // Function to count total words stored in Trie
    public int wordCount(TrieNode root) {
        if (root == null) return 0;

        int count = 0;
        if (root.isEndOfWord) count++;

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += wordCount(root.children[i]);
            }
        }
        return count;
    }
}

/*
----------------------------------------
Logic Summary:
1. Traverse each Trie node recursively.
2. Increment count whenever isEndOfWord == true.
3. Return the total number of words.
----------------------------------------
Complexity:
Time: O(N * L)
Space: O(L)
----------------------------------------
*/
