package Searching;

/*

https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/


A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.



Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
Example 2:

Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
Example 3:

Input: weights = [1,2,3,1,1], days = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1


Constraints:

1 <= days <= weights.length <= 5 * 104
1 <= weights[i] <= 500

*/

public class CapacityToShipPackagesWithin_D_Days {
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            return findCapacity(weights, days);
        }

        int findCapacity(int[] weights, int days)

        {

            int maxWeight = 0;
            int sumWeight = 0;

            for (int weight : weights) {
                maxWeight = Math.max(maxWeight, weight);
                sumWeight += weight;
            }

            int left = maxWeight;
            int right = sumWeight;

            while (left <= right) {

                //we will try mid of it , bring average
                int mid = left + (right - left) / 2;

                boolean isPossible = isShippingPossible(weights, mid, days);

                if (isPossible) { //go left -> small capacity
                    right = mid - 1;
                } else
                    left = mid + 1; //go right --> greater capacity

            }

            return left; //either left or right

        }

        boolean isShippingPossible(int weight[], int pickedCapacity, int days) {

            int currDays = 1;
            int totalWeight = 0;

            for (int i = 0; i < weight.length; i++) {

                if (totalWeight + weight[i] <= pickedCapacity) //of we can add curr weight and still be under capacity
                    totalWeight += weight[i]; //yes, then take it
                else {
                    totalWeight = weight[i]; //no, so total weight starts from curr weight
                    currDays++;
                }

                if(currDays > days) return false; //if its taking more days than given
            }

            if (currDays <= days) {
                return true;
            }
            return false;
        }
    }

/*


-----------------------------------

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5

total= 1+2+3+4+5+6+7+8+9+10=55
max weight = 10

capactity 10 to 55:

mid capacity (10+55)/2 = 32

pick capaceity 32:

day1 = 1,2,3,4,5,6,7 = 29 shipped
day2 = 8+9,10 = 27 shipped

with capacity 32, we shipped all, lets try less capacity

pick capacity from left half (10 to 32) = (10+32)/2=21:

day1 = 1,2,3,4,5,6 = 21 shipped
day2 = 7,8 shipped
day3 = 9, shipped
day4 = 10 shipped

in 4 days shipped all.

try less capccity:
pick capacity from left half (10 to 21) = (10+21)/2=15:


pick capacity 15:

day1 = 1,2,3,4,5 = 15 shipped
day2 = 6,7 = 13 shipped
day3 = 8 shipped
day4 = 9 shipped
day4 = 10 shipped

alls shipped in 5 days.

lets try less capacity:


pick capacity from left half (10 to 15) = (10+15)/2=12:

pick capacity 12:

day1 = 1,2,3,4 = 10 shipped
day2 = 5,6 = 11 shipped
day3 = 7 shipped
day4 = 8 shipped
day5 = 9 shipped

10 remained but days expired.


so we can't pick 12 capacity and we will stop at prev capacity i.e 15.

15 in asnwer.
*/
}
