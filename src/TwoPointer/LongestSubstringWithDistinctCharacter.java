/*
https://www.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1
Given a string s, find the length of the longest substring with all distinct characters.

Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest substring with all distinct characters.
Input: s = "aaa"
Output: 1
Explanation: "a" is the longest substring with all distinct characters.
Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring with all distinct characters is "abcdef", which has a length of 6.
Constraints:
1<= s.size()<=3*104
All the characters are in lowercase.
 */
package TwoPointer;

public class LongestSubstringWithDistinctCharacter {

    class Solution {

        public int longestUniqueSubstr(String s) {
            boolean[] visited = new boolean[256]; // Assume ASCII characters
            int maxLength = 0;
            int start = 0;

            for (int end = 0; end < s.length(); end++) {
                while (visited[s.charAt(end)]) {
                    visited[s.charAt(start)] = false; // Mark the start character as not visited
                    start++; // Move the start pointer forward
                }
                visited[s.charAt(end)] = true; // Mark the current character as visited
                maxLength = Math.max(maxLength, end - start + 1); // Update max length
            }

            return maxLength;
        }
    }
}
