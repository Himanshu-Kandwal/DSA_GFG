package CodingChallenge.POTD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
https://www.geeksforgeeks.org/problems/power-set4302/1

Given a string s of length n, find all the possible subsequences of the string s in lexicographically-sorted order.

Example 1:

Input :
s = "abc"
Output:
a ab abc ac b bc c
Explanation :
There are a total 7 number of subsequences possible
for the given string, and they are mentioned above
in lexicographically sorted order.
Example 2:

Input:
s = "aa"
Output:
a a aa
Explanation :
There are a total 3 number of subsequences possible
for the given string, and they are mentioned above
in lexicographically sorted order.
Your Task:
You don't need to read input or print anything. Your task is to complete the function AllPossibleStrings() which takes a string s as the input parameter and returns a list of all possible subsequences (non-empty) that can be formed from s in lexicographically-sorted order.

Expected Time Complexity: O( n*2n  )
Expected Space Complexity: O( n * 2n )

Constraints:
1 <= n <= 16
s will constitute of lower case english alphabets


 */

//todo write more optimized
public class PowerSet {
    public static void main(String[] args) {
        System.out.println(new PowerSet().new Solution().AllPossibleStrings("abc"));
    }

    class Solution {
        public List<String> AllPossibleStrings(String s) {
            List<String> ans = Helper(s, 0);
            Collections.sort(ans);
            return ans;
        }

        //todo create subsequences without empty string
        public List<String> Helper(String str, int currIdx) { //subsequences with empty string
            List<String> list = new ArrayList<>();
            if (currIdx == str.length()) { //empty string is also subsequence of a string, if last index reached return empty string
                list.add("");
                return list;
            }

            List<String> ans = Helper(str, currIdx + 1); //bring answers of other indices
            List<String> ansWithCurrChar = new ArrayList<>();

            for (String item : ans) {
                ansWithCurrChar.add(str.charAt(currIdx) + "" + item); //adding prefix(curr char) in all subsequences we got
            }

            list.addAll(ans);// without curr char in prefix
            list.addAll(ansWithCurrChar); //with curr char as prefix
            return list;
        }
    }
}
