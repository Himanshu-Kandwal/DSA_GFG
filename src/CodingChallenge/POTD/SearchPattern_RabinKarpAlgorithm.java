package CodingChallenge.POTD;

import java.util.ArrayList;

/*

https://www.geeksforgeeks.org/problems/search-pattern-rabin-karp-algorithm--141631/1

Given two strings, one is a text string and other is a pattern string. The task is to print the indexes of all the Occurences of pattern string in the text string. For printing, Starting Index of a string should be taken as 1. The strings will only contain lowercase English alphabets ('a' to 'z').

Example 1:

Input:
text = "birthdayboy"
pattern = "birth"
Output:
[1]
Explanation:
The string "birth" occurs at index 1 in text.
Example 2:

Input:
text = "geeksforgeeks"
pattern = "geek"
Output:
[1, 9]
Explanation:
The string "geek" occurs twice in text, one starts are index 1 and the other at index 9.
Your Task:
You don't need to read input or print anything. Your task is to complete the function search() which takes the string text and the string pattern as input and returns an array denoting the start indices (1-based) of substring pattern in the string text.

Expected Time Complexity: O(|text| + |pattern|).
Expected Auxiliary Space: O(1).

Constraints:
1<=|text|<=5*105
1<=|pattern|<=|text|

 */
public class SearchPattern_RabinKarpAlgorithm {
    public static void main(String[] args) {

        String text = "geeksforgeeks";
        String pattern = "geek";
        System.out.println(new SearchPattern_RabinKarpAlgorithm().new Solution().search(pattern, text));
    }

    class Solution {

        ArrayList<Integer> search(String pattern, String text) {
            ArrayList<Integer> arrayList = new ArrayList<>();


            return arrayList;
        }
    }
}
