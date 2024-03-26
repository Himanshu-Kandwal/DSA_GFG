package CodingChallenge.POTD;

import java.util.Arrays;

/*

link https://www.geeksforgeeks.org/problems/distinct-occurrences/1

Given two strings s and t of length n and m respectively. Find the count of distinct occurrences of t in s as a sub-sequence modulo 109 + 7.

Example 1:

Input:
s = "banana" , t = "ban"
Output:
3
Explanation:
There are 3 sub-sequences:[ban], [ba n], [b an].
Example 2:

Input:
s = "geeksforgeeks" , t = "ge"
Output:
6
Explanation:
There are 6 sub-sequences:[ge], [ge], [g e], [g e] [g e] and [g e].
Your Task:
You don't need to read input or print anything.Your task is to complete the function subsequenceCount() which takes two strings as argument s and t and returns the count of the sub-sequences modulo 109 + 7.

Expected Time Complexity: O(n*m).
Expected Auxiliary Space: O(n*m).

Constraints:
1 ≤ n,m ≤ 1000


 */
public class DistinctOccurrences {

    public static void main(String[] args) {
        //String s = "banana", t = "ban";
        String s = "geeksforgeeks", t = "ge";
        System.out.println(new DistinctOccurrences().new Solution().subsequenceCount(s, t));
    }

    class Solution {
        int memoDp[][];
        long mod=1000000000+7;

        int subsequenceCount(String s, String t) {
            memoDp = new int[s.length()][t.length()]; //init memo array

            for(int[] row:memoDp)
                Arrays.fill(row,-1); //filling 2d memo array by -1

            return helperOpt(s, t, 0, 0);
        }

        int helper(String s, String t, int sIdx, int tIdx) { //unoptimized
            int a = 0, b = 0;
            if (tIdx == t.length()) return 1;
            if (sIdx == s.length()) return 0;

            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                a = helper(s, t, sIdx + 1, tIdx + 1);
            }

            b = helper(s, t, sIdx + 1, tIdx);
            return a + b;
        }

        int helperOpt(String s, String t, int sIdx, int tIdx) { //with memoization
            int a = 0, b = 0;
            if (tIdx == t.length()) return 1;
            if (sIdx == s.length()) return 0;
            if (memoDp[sIdx][tIdx] != -1) return memoDp[sIdx][tIdx];

            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                a = helperOpt(s, t, sIdx + 1, tIdx + 1);
            }

            b = helperOpt(s, t, sIdx + 1, tIdx);

            memoDp[sIdx][tIdx]= (int)((a+b)%mod); //saving ans

            return memoDp[sIdx][tIdx]; //returning ans which we saved
        }
    }

}
