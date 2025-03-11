package DynamicProgramming;
/*
There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Your task is to count the number of ways, the person can reach the top (order does matter).

Examples:

Input: n = 1
Output: 1
Explanation: There is only one way to climb 1 stair.
Input: n = 2
Output: 2
Explanation: There are 2 ways to reach 2th stair: {1, 1} and {2}.
Input: n = 4
Output: 5
Explanation: There are five ways to reach 4th stair: {1, 1, 1, 1}, {1, 1, 2}, {2, 1, 1}, {1, 2, 1} and {2, 2}.
Constraints:
1 ≤ n ≤ 44


 */
public class WaysToReachNthStair {

    class Solution {
        int countWays(int n) {
            //return helperRec(n);

            // int memo[] = new int[n+1];
            // Arrays.fill(memo,-1);
            // return helperRecMemo(n,memo);

            return helperDPSpaceOptimized(n);
        }

        int helperRec(int n) {
            if (n == 0) return 1; //we reached destination

            int step1 = 0;
            //can take #1 step
            if (n - 1 >= 0) {
                step1 = helperRec(n - 1); // take 1 step and add 1 for current step
            }

            int step2 = 0;
            //can take #2 step
            if (n - 2 >= 0) {
                step2 = helperRec(n - 2); //take 2 step and add 1 for curr step
            }

            return step1 + step2; //we are asked total steps
        }

        int helperDP(int n) {
            if (n == 0) return 0;

            int DP[] = new int[n + 1];
            DP[0] = 1;

            for (int i = 1; i <= n; i++) {
                int step1 = 0;
                //can take #1 step
                if (i - 1 >= 0) {
                    step1 = DP[i - 1]; // take 1 step and add 1 for current step
                }

                int step2 = 0;
                //can take #2 step
                if (i - 2 >= 0) {
                    step2 = DP[i - 2]; //take 2 step and add 1 for curr step
                }

                DP[i] = step1 + step2;

            }


            return DP[n]; //we are asked total steps
        }

        int helperDPSpaceOptimized(int n) {
            if (n == 0) return 0;


            int prev2 = 0;
            int prev1 = 1;
            int curr = 0;

            for (int i = 1; i <= n; i++) {
                int step1 = 0;
                //can take #1 step
                if (i - 1 >= 0) {
                    step1 = prev1; // take 1 step and add 1 for current step
                }

                int step2 = 0;
                //can take #2 step
                if (i - 2 >= 0) {
                    step2 = prev2; //take 2 step and add 1 for curr step
                }

                curr = prev1 + prev2;

                prev2 = prev1;
                prev1 = curr;

            }


            return curr; //we are asked total steps
        }

    }
}
