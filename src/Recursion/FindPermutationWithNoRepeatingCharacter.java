/*

https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1

Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.

Examples:

Input: s = "ABC"
Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
Explanation: Given string ABC has 6 unique permutations.
Input: s = "ABSG"
Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
Explanation: Given string ABSG has 24 unique permutations.
Input: s = "AAA"
Output: ["AAA"]
Explanation: No other unique permutations can be formed as all the characters are same.
Constraints:
1 <= s.size() <= 9
s contains only Uppercase english alphabets

 */
package Recursion;

import java.util.ArrayList;
import java.util.HashSet;

public class FindPermutationWithNoRepeatingCharacter {
    public static void main(String[] args) {
        String str = "ABC";

        System.out.println(new FindPermutationWithNoRepeatingCharacter().permutation(str).toString());

    }

    ArrayList<String> permutation(String str){
       String curr="";
       boolean[] visited = new boolean[str.length()];
        ArrayList<String> list = new ArrayList<String>();

        helper(str, curr,list, visited);
        HashSet<String> uniquePermutations = new HashSet<>(list);

        return new ArrayList<>(uniquePermutations);
    }

    void helper(String str, String curr, ArrayList<String> list, boolean[] visited){
        if(curr.length()==str.length()){
            list.add(curr); //adding curr permutation to answer list as we have added all chars
        }

        //iterating for all chars
        for(int i=0;i<str.length();i++){

            if(!visited[i]){ //if not visited only then we will add this to curr permutation
                visited[i]=true; //marking it as visited
                helper(str,curr+str.charAt(i),list,visited);
                visited[i] = false; //for backtracking marking it as unvisited
            }

        }
    }
}
