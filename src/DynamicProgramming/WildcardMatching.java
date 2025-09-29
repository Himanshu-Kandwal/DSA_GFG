package DynamicProgramming;

/*

https://leetcode.com/problems/wildcard-matching/

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).



Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.


Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.

 */


public class WildcardMatching {
    class Solution {
        public boolean isMatch(String s, String p) {
            //memo code
            // int[][] memo = new int[s.length() + 1][p.length() + 1];
            // for (int[] row : memo)
            //     Arrays.fill(row, -1);
            // return rec(s, p, 0, 0, memo);

            //DP code
            return dp(s, p);
        }

        public boolean rec(String s, String p, int sIdx, int pIdx, int[][] memo) {
            if (memo[sIdx][pIdx] != -1)
                return memo[sIdx][pIdx] == 1; //already computed return that,

            boolean ans;

            if (pIdx == p.length()) { //pattern exhausted
                ans = sIdx == s.length(); //if string is also exhausted then true otherwise false
            } else if (sIdx == s.length()) { //string exhausted
                int idx = pIdx;
                while (idx < p.length() && p.charAt(idx) == '*')
                    idx++; //then all pattern chars remained must be *
                ans = idx == p.length();
            } else if (p.charAt(pIdx) == '?') { //if pattern has "?""
                ans = rec(s, p, sIdx + 1, pIdx + 1, memo); //compute for remainiing string and pattern,
            } else if (p.charAt(pIdx) == '*') { //if wildcard *
                ans = rec(s, p, sIdx, pIdx + 1, memo) || rec(s, p, sIdx + 1, pIdx, memo); //either pattern or string index moves, 1) * means chars of some strings, 2) * represent empty
            } else if (s.charAt(sIdx) == p.charAt(pIdx)) { //both char of pat and str match
                ans = rec(s, p, sIdx + 1, pIdx + 1, memo); //fetch for remaining
            } else {
                ans = false; //chars dont match so false
            }

            memo[sIdx][pIdx] = ans ? 1 : 0; //fill memo storage 1 or 0 for true false
            return ans;
        }

        //Tabulation
        public boolean dp(String s, String p) { //tabulation

            int M = s.length();
            int N = p.length();

            boolean dp[][] = new boolean[M + 1][N + 1];// string top to bottom. pattern left to right

            //empty string i.e exhausted both = true
            dp[0][0] = true;

            //filling first row i.e string empty
            for (int i = 1; i <= N; i++) {
                if (p.charAt(i - 1) == '*') { // if string "" and pattern is *
                    dp[0][i] = dp[0][i - 1]; //take answer of previous i.e same string with pattern except curr char
                } //else by default 0 = false
            }

            //filling first col, pattern empty string has char is not required
            //skipped that

            // fill remaining table
            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {

                    //if ? exists OR both chars match then it takes answer of previous diagonal i.e whatever we got for prev string except curr chars

                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                        dp[i][j] = dp[i - 1][j - 1];

                        //if * in pattern's curr char
                    else if (p.charAt(j - 1) == '*')
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];

                    // else its 0, not necassary as dp itself has by default 0 value

                }
            }

            //return true false based on last cell value
            return dp[M][N];
        }

    }
}
