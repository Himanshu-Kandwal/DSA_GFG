/*
https://www.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

Given a string s, return the length of the longest palindromic subsequence.

A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements.

A palindromic sequence is a sequence that reads the same forward and backward.

Examples:

Input: s = "bbabcbcab"
Output: 7
Explanation: Subsequence "babcbab" is the longest subsequence which is also a palindrome.
Input: s = "abcd"
Output: 1
Explanation: "a", "b", "c" and "d" are palindromic and all have a length 1.
Input: s = "agbdba"
Output: 5
Explanation: The longest palindromic subsequence is "abdba", which has a length of 5. The characters in this subsequence are taken from the original string "agbdba", and they maintain the order of the string while forming a palindrome.
Constraints:
1 ≤ s.size() ≤ 1000
The string contains only lowercase letters.

 */
package DynamicProgramming;

public class LongestPalindromicSubsequence {

    public int longestPalinSubseq(String s) {
        String s1=s;
        String s2 = new StringBuilder(s).reverse().toString();
        return lcs(s1,s2); //reverse one string and pass original and reversed string to get longest common subsequence. that would be longest common palindromic subsequence.
    }

    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1]; // DP table

        // Base Case: If any string is empty, LCS = 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        // Fill the DP table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // Characters match, take diagonal value + 1
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Characters don't match, take max of excluding one character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m]; // LCS of entire strings
    }
}
