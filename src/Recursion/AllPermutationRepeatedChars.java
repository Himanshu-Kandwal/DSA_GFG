package Recursion;

/*
WAP to return all permutation(with Repetition) of a string, total N^N permutation possible

for str= "abc",
 [aaa, aab, aac, aba, abb, abc, aca, acb, acc, baa, bab, bac, bba, bbb, bbc, bca, bcb, bcc, caa, cab, cac, cba, cbb, cbc, cca, ccb, ccc]
*/

import java.util.ArrayList;
import java.util.List;

public class AllPermutationRepeatedChars {
    public static void main(String[] args) {
        String str = "abc";

        System.out.println(getAllPermuationWithRepetition(str, 0));
    }

    private static List<String> getAllPermuationWithRepetition(String str, int curr) { //curr variable on which char we are at.
        List<String> pList = new ArrayList<>();

        if (curr == str.length() - 1) { // curr is pointing last index, only 1 element is in str remained
            for (int idx = 0; idx < str.length(); idx++) { //adding all chars of string to all permutation (right most char in permutation)
                pList.add(str.charAt(idx) + "");
            }
            return pList;
        }

        pList = getAllPermuationWithRepetition(str, curr + 1); //get permutation from curr+1 char

        List<String> ansList = new ArrayList<>();

        for (int idx = 0; idx < str.length(); idx++) { //adding all chars of string to all permutation we got from curr+1 character
            for (String item : pList) {
                ansList.add(str.charAt(idx) + item);
            }
        }
        return ansList;
    }
}
