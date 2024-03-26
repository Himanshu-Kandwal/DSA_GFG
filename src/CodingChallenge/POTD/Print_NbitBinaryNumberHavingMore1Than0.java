package CodingChallenge.POTD;

import java.util.ArrayList;
import java.util.HashSet;

/*
https://www.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1

Print N-bit binary numbers having more 1s than 0s

MediumAccuracy: 56.08%Submissions: 39K+Points: 4

Given a positive integer n. Your task is to generate a string list of all n-bit binary numbers where, for any prefix of the number, there are more or an equal number of 1's than 0's. The numbers should be sorted in decreasing order of magnitude.

Example 1:

Input:
n = 2
Output:
"11, 10"
Explanation: Valid numbers are those where each prefix has more 1s than 0s:
11: all its prefixes (1 and 11) have more 1s than 0s.
10: all its prefixes (1 and 10) have more 1s than 0s.
So, the output is "11, 10".
Example 2:

Input:
n = 3
Output:
"111, 110, 101"
Explanation: Valid numbers are those where each prefix has more 1s than 0s.
111: all its prefixes (1, 11, and 111) have more 1s than 0s.
110: all its prefixes (1, 11, and 110) have more 1s than 0s.
101: all its prefixes (1, 10, and 101) have more 1s than 0s.
So, the output is "111, 110, 101".
User Task:
Your task is to complete the function NBitBinary() which takes a single number as input n and returns the list of strings in decreasing order. You need not take any input or print anything.

Expected Time Complexity: O(|2n|)
Expected Auxiliary Space: O(2n)

Constraints:
1 <= n <= 15


 */
public class Print_NbitBinaryNumberHavingMore1Than0 {

    public static void main(String[] args) {

        int n = 4;
        Solution obj = new Print_NbitBinaryNumberHavingMore1Than0().new Solution();
        System.out.println(obj.NBitBinary(n));

    }

    class Solution {

        ArrayList<String> NBitBinary(int N) {
            StringBuilder sb = new StringBuilder();
            return helper(new HashSet<>(), N, "", 0, 0);
        }

        //todo currect ans but TLE error
        ArrayList<String> helper(HashSet<String> list, int N, String curr, int zeroCount, int oneCount) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (curr.length() > N) return new ArrayList<>();
            if (zeroCount > oneCount) return new ArrayList<>();
            if (curr.length() == N && zeroCount <= oneCount) {
                if (!list.contains(curr)) { //checking if it already computed
                    arrayList.add(curr); //if no then addidng to answer
                    list.add(curr); //and saving in hashset to check for duplicate in future
                }
            }

            ArrayList<String> oneList = helper(list, N, curr + "1", zeroCount, oneCount + 1);
            ArrayList<String> zeroList = helper(list, N, curr + "0", zeroCount + 1, oneCount);

            arrayList.addAll(oneList);
            arrayList.addAll(zeroList);
            return arrayList;
        }

    }
}
