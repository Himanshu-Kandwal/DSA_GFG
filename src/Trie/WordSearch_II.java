package Trie;

import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/word-search-ii/description/
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []

 */
public class WordSearch_II {
    class Solution {

        public List<String> findWords(char[][] board, String[] words) {

            List<String> res = new ArrayList<>();

            // Build Trie from the word list
            TrieNode root = buildTrie(words);

            // Try starting DFS from every cell in the board
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, i, j, root, res); // DFS from cell (i,j)
                }
            }

            return res;
        }

        // DFS to explore the board for valid words in Trie
        public void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {

            char c = board[i][j];

            // Base case: out of bounds, visited, or path not in Trie
            if (c == '#' || node.next[c - 'a'] == null) return;

            node = node.next[c - 'a']; // move to the next TrieNode

            // If current node marks the end of a word, add to result
            if (node.word != null) {
                res.add(node.word);   // Add found word
                node.word = null;     // Avoid duplicates by marking word as used
            }

            // Mark cell visited by modifying the board
            board[i][j] = '#';

            // Explore in all four directions
            if (i > 0) dfs(board, i - 1, j, node, res);              // Up
            if (j > 0) dfs(board, i, j - 1, node, res);              // Left
            if (i < board.length - 1) dfs(board, i + 1, j, node, res);  // Down
            if (j < board[0].length - 1) dfs(board, i, j + 1, node, res); // Right

            board[i][j] = c; // Restore character (backtrack)
        }

        // Builds Trie from array of words
        public TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode();

            for (String word : words) {
                TrieNode curr = root;

                for (char c : word.toCharArray()) {
                    int idx = c - 'a';
                    if (curr.next[idx] == null)
                        curr.next[idx] = new TrieNode(); // create child if not exists
                    curr = curr.next[idx]; // move to the child node
                }

                curr.word = word; // store full word at leaf node
            }

            return root;
        }
    }

    // TrieNode with 26 children and optional full word at leaf
    class TrieNode {
        TrieNode[] next = new TrieNode[26]; // children for 'a' to 'z'
        String word; // holds word at leaf node (if any)
    }

}
