/*
Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.

Examples:

Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
Output:  [3, 4, 4, 3]
Explanation: Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3.
Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.
Input: arr[] = [4, 1, 1], k = 2
Output: [2, 1]
Explanation: Window 1 of size k = 2 is 4 1. Number of distinct elements in this window are 2.
Window 2 of size k = 2 is 1 1. Number of distinct elements in this window is 1.
Input: arr[] = [1, 1, 1, 1, 1], k = 3
Output: [1, 1, 1]
Constraints:
1 <= k <= arr.size() <= 105
1 <= arr[i] <= 105


 */
package TwoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementInEveryWindow {

    //T(N) S(N)
    /*
    we store frequency of first window in hashmap, and add size of hashmap(i.e count of distinct element) to ans list for first window
    and slide window rightward one by one,every time when we slide window we reduce leftmost(currIdx-K) element's frequency in hashmap (or remove element if it became zero)
    and add/increase currIdx's frequency in hashmap i.e remove old value from start and add new value from end to slide window as well as adding count of distinct element to anslist for every window.
    after iterating all windows return ans list
    */
    class Solution {

        ArrayList<Integer> countDistinct(int arr[], int k) {

            ArrayList<Integer> countList = new ArrayList<>();
            Map<Integer,Integer> freqMap = new HashMap<>();

            //adding nums->frequency for first window
            for(int i=0; i<k;i++){
                increaseFrequency(freqMap, arr[i]);
            }

            //adding distinct nums for first window
            countList.add(freqMap.size());

            for(int i=k;i<arr.length;i++){
                //add curr's freq to map
                increaseFrequency(freqMap,arr[i]);
                //remove left most item from the window to slide window towards right
                decreaseFrequency(freqMap,arr[i-k]);

                //add count of distinct element for curr window
                countList.add(freqMap.size());

            }

            return countList;

        }

        void increaseFrequency(Map<Integer,Integer> map, int num){
            int currFreq= map.getOrDefault(num,0);
            map.put(num,currFreq+1);
        }

        void decreaseFrequency(Map<Integer,Integer> map, int num){
            int currFreq= map.getOrDefault(num,0);
            if(currFreq==1){ // if their is only one freq and we are decreasing it then it should be removed
                map.remove(num);
            }else map.put(num,currFreq-1);
        }

    }
}
