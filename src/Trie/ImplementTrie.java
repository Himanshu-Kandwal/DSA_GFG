package Trie;

/*

https://leetcode.com/problems/implement-trie-prefix-tree/

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie.Trie class:

Trie.Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


Example 1:

Input
["Trie.Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie.Trie trie = new Trie.Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True


Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.

 */
public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("agent");
        trie.insert("ball");
        trie.insert("ballpoint");

        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("appl"));

    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode(); // Initialize root node
    }

    // Inserts a word into the trie
    public void insert(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            int currIdx = word.charAt(i) - 'a'; // Map character to index (0–25)
            if (temp.children[currIdx] == null) {
                temp.children[currIdx] = new TrieNode(); // Create node if not exists
            }
            temp = temp.children[currIdx]; // Move to the child node
        }
        temp.isEOW = true; // Mark end of word
    }

    // Returns true if the word exists in the trie
    public boolean search(String word) {
        TrieNode last = searchPrefix(word);
        return last != null && last.isEOW;
    }

    // Returns true if any word in the trie starts with the given prefix
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    // Traverses the trie to the end of the given prefix; returns node if found
    private TrieNode searchPrefix(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            int currIdx = prefix.charAt(i) - 'a';
            if (temp.children[currIdx] == null) {
                return null; // Path breaks — prefix not found
            }
            temp = temp.children[currIdx]; // Move deeper
        }
        return temp; // Return node at end of prefix
    }
}

// Trie.Trie node with 26 children (a–z) and a flag to mark end of word
class TrieNode {
    TrieNode[] children;
    boolean isEOW = false;

    public TrieNode() {
        children = new TrieNode[26];
    }
}

