package Greedy;

import java.util.Arrays;

/*

https://leetcode.com/problems/candy/submissions/1751363132/
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104


 */
public class DistributeCandies {

    class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;

            // Step 1: Give each child 1 candy to start with
            int[] candies = new int[n];
            Arrays.fill(candies, 1);

            // Step 2: Left → Right pass
            // If a child has a higher rating than the previous one,
            // give them more candies than the previous child.
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
            }

            // Step 3: Right → Left pass
            // If a child has a higher rating than the next one,
            // make sure they have more candies than that next child.
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                }
            }

            // Step 4: Sum all candies to get the minimum required total
            int total = 0;
            for (int c : candies) {
                total += c;
            }

            return total;
        }
    }

}
