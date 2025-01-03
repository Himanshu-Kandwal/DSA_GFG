/*

https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/

You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, and an integer k. You should apply the following operation exactly k times:

Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
Notice that you can apply the operation on the same pile more than once.

Return the minimum possible total number of stones remaining after applying the k operations.

floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).

Example 1:

Input: piles = [5,4,9], k = 2
Output: 12
Explanation: Steps of a possible scenario are:
- Apply the operation on pile 2. The resulting piles are [5,4,5].
- Apply the operation on pile 0. The resulting piles are [3,4,5].
The total number of stones in [3,4,5] is 12.
Example 2:

Input: piles = [4,3,6,7], k = 3
Output: 12
Explanation: Steps of a possible scenario are:
- Apply the operation on pile 2. The resulting piles are [4,3,3,7].
- Apply the operation on pile 3. The resulting piles are [4,3,3,4].
- Apply the operation on pile 0. The resulting piles are [2,3,3,4].
The total number of stones in [2,3,3,4] is 12.


Constraints:

1 <= piles.length <= 105
1 <= piles[i] <= 104
1 <= k <= 105


 */
package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTotal {
    public static void main(String[] args) {
        int[] piles = {1, 5, 9, 10, 24, 1, 5};
        int k = 9;

        Solution obj = new RemoveStonesToMinimizeTotal().new Solution();
        System.out.println(obj.minStoneSum(piles, k));
    }

    class Solution {

        public int minStoneSum(int[] piles, int k) {

            PriorityQueue<Integer> maxKPiles = new PriorityQueue<>(Collections.reverseOrder());

            // summming all piles , also adding all piles in priority queue
            int sumPiles = 0; //representing total piles
            for (int currPile : piles) {
                maxKPiles.add(currPile); // add curr pile
                sumPiles += currPile;
            }

            while (k-- > 0) {
                int currPile = maxKPiles.poll();
                int halfOfPile = currPile / 2;
                sumPiles -= halfOfPile; //subtract it from total sum, as we have taken it out from all piles
                maxKPiles.add(currPile - halfOfPile); //add remaining to back for future piles computation
            }

            return sumPiles;
        }

    }
}
