
import java.util.*;

class TrieNode {
    char content;
    boolean isEnd;
    int count;
    LinkedList<TrieNode> childList;

    public TrieNode(char c) {
        content = c;
        isEnd = false;
        count = 0;
        childList = new LinkedList<>();
    }

    public TrieNode subNode(char c) {
        for (TrieNode each : childList)
            if (each.content == c)
                return each;
        return null;
    }
}

class Solution {
    public static void deleteKey(TrieNode root, char[] key) {
        deleteHelper(root, key, 0);
    }

    private static boolean deleteHelper(TrieNode current, char[] key, int index) {
        if (current == null) return false;

        if (index == key.length) {
            if (!current.isEnd) return false;
            current.isEnd = false;
            current.count--;
            return current.childList.isEmpty();
        }

        char ch = key[index];
        TrieNode child = current.subNode(ch);

        if (child == null) return false;

        boolean shouldDeleteChild = deleteHelper(child, key, index + 1);

        if (shouldDeleteChild) {
            current.childList.remove(child);
        }

        current.count--;
        return current.childList.isEmpty() && !current.isEnd;
    }
}

/*
----------------------------------------
Logic Summary:
1. Traverse Trie according to key.
2. Unmark isEnd at last node.
3. Recursively backtrack — remove unused nodes.
4. Shared prefixes remain untouched.
----------------------------------------
Complexity:
Time: O(L)
Space: O(L)
----------------------------------------
*/

