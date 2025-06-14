/*
https://leetcode.com/problems/find-k-closest-elements/submissions/1539656129/
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b


Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3

Output: [1,2,3,4]

Example 2:

Input: arr = [1,1,2,3,4,5], k = 4, x = -1

Output: [1,1,2,3]



Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104

 */
package PriorityQueue;

import java.util.*;

public class KClosestElements {

    //Heap based solution takes extra space
    class SolutionHeap {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new ElementComparator(x));

            // adding elements to priority queue keeping the size of queue upto K only
            for (int element : arr) {
                pq.add(element);
                if (pq.size() > k)
                    pq.remove();
            }

            List<Integer> list = new ArrayList<>();

            while (!pq.isEmpty()) {
                list.add(pq.remove());
            }

//sorting list as asked in
            Collections.sort(list);
            return list;
        }
    }
// comparator helps priority queue keep closest element at the bottom and
// farthest element at the top for easy removing

    class ElementComparator implements Comparator<Integer> {
        int x;

        public ElementComparator(int x) {
            this.x = x;
        }

        public int compare(Integer a, Integer b) {
            int diff1 = Math.abs(a - x);
            int diff2 = Math.abs(b - x);
            if (diff1 != diff2)
                return Integer.compare(diff2, diff1);

            // if diff is same, then compare number itself
            return Integer.compare(b, a);
        }
    }

    //two pointers+sliding window without extra space of heap

    class SolutionTwoPointerSliding {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int start = 0;
            int end = arr.length - 1;

            while (end - start >= k) { //run while as long as there are still k elements left

                int diffStart = Math.abs(arr[start] - x);
                int diffEnd = Math.abs(arr[end] - x);

                if (diffStart > diffEnd) { // if diffStart is greater means we need to shrink from start to go close to X
                    start++;
                } else { // otherwise shrink from end
                    end--;
                }
            }

            //ans list
            List<Integer> list = new ArrayList<>();

            //copy elements from start to end which are closest to k, and already in sorted order since array itself is sorted
            while (start <= end)
                list.add(arr[start++]);

            return list;
        }
    }
}
