package String;

import java.util.ArrayList;
import java.util.Arrays;

public class KMP_PatternSearch {
    public static void main(String[] args) {
        String pattern = "aababb";
        String text = "aacbccacaababbaacbccacaababb";
        int[] lps = constructLPS(pattern);
        ArrayList<Integer> beginningIndexOfPatternMatchFoundAt = findPatternInText(text,pattern, lps);
        System.out.println(Arrays.toString(lps));
        System.out.println(beginningIndexOfPatternMatchFoundAt);
    }

    private static ArrayList<Integer> findPatternInText(String text, String pattern, int[] lps) {
        ArrayList<Integer> patternFoundAt = new ArrayList<>();
        int textLength = text.length();
        int patternLength = pattern.length();

        int texIdx=0;
        int patIdx=0;

        while (texIdx<textLength){
           if(text.charAt(texIdx) == pattern.charAt(patIdx)){
               //if chars match move both index further
               patIdx++;
               texIdx++;

               //complete pattern match found
               if(patIdx==patternLength){
                   patternFoundAt.add(texIdx-patIdx);
                   patIdx = lps[patIdx-1]; //go to previous index which matched
               }
           }else { //if chars don't match
               if(patIdx!=0){ //there was some matched chars hence we are not at zero in patIdx
                   patIdx = lps[patIdx-1]; //use previous value without moving textIdx
               }else { //patIdx at zero means we can't move to previous hence just move textIdx only
                   texIdx++;
               }
           }
        }

        return patternFoundAt;
    }

    private static int[] constructLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int j = 0; //length of prefix-suffix at ith position
        int i = 1; //index to iterate pattern from 2nd char to end
        while (i < pattern.length()) {
            //if match
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                //no prefix-suffix found yet i.e we are beginning, so we put lps[i]=0
                if (j == 0) {
                    lps[i] = 0;
                    i++;
                } else { //since j is not at 0, we have some prefix-suffix length in the array, so use just previous lps value calculated previously
                    j = lps[j - 1];
                }
            }
        }
        return lps;
    }
}
