/*
https://leetcode.com/problems/longest-common-subsequence/description/

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.



Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.


Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.


 */
package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.longestCommonSubsequence("abc", "abc"));
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return memoRunner(text1,text2);
        return tabulation(text1, text2);
    }

    // runner function for memo algo
    int memoRunner(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return memo(text1, text2, text1.length() - 1, text2.length() - 1, dp);
    }

    // actual memoization function
    int memo(String str1, String str2, int idx1, int idx2, int[][] dp) {
        if (idx1 < 0 || idx2 < 0) {
            return 0; // index out of bound, string is empty so 0 is LCS
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        if (str1.charAt(idx1) == str2.charAt(idx2)) {
            dp[idx1][idx2] = 1 + memo(str1, str2, idx1 - 1, idx2 - 1, dp);
        } else
            dp[idx1][idx2] = Math.max(memo(str1, str2, idx1, idx2 - 1, dp),
                    memo(str1, str2, idx1 - 1, idx2, dp));

        return dp[idx1][idx2];
    }

    //tabulation T(len(str1)*len(str2)), S(len(str1)*len(str2))

    int tabulation(String str1, String str2) {
        int m = str1.length(); // last index row (length)
        int n = str2.length(); // last index column (length)

        int[][] dp = new int[m + 1][n + 1]; // create table with size (m+1) and (n+1)

        for (int i = 1; i <= m; i++) { // loop from 1 to m (for row)
            for (int j = 1; j <= n; j++) { // loop from 1 to n (for column)
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // match, increment from the diagonal
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // take max of left or top
                }
            }
        }

        return dp[m][n]; // return the last element, which contains the LCS length
    }

}
