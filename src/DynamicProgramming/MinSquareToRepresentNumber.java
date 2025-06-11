package DynamicProgramming;

/*

https://www.geeksforgeeks.org/problems/get-minimum-squares0538/1

Given a number n, find the minimum number of perfect squares (square of an integer) that sum up to n.

Examples:

Input: n = 100
Output: 1
Explanation: 10 * 10 = 100
Input: n = 6
Output: 3
Explanation = 1 * 1 + 1 * 1 + 2 * 2 = 6
Expected Time Complexity: O(n * sqrt(n))
Expected Space Complexity: O(n)

Constraints:
1 <= n <= 104

 */
class MinSquareToRepresentNumber {
    public int MinSquares(int n) {
        //return rec(n);

        //   int memo[] = new int[n+1];
        //   Arrays.fill(memo,-1);
        //   return recMemo(n,memo);

        return tabulation(n);
    }


    //working but TLE
    public int rec(int n) {
        if (n <= 0) return 0;

        int min = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) {
            int curr = rec(n - i * i);
            min = Math.min(curr, min);
        }

        return min + 1; //1 for taking curr num
    }

    //memo code still gives TLE  TC O(n * √n) , SC O(N)
    public int recMemo(int n, int[] memo) {
        if (n <= 0) return 0;

        if (memo[n] != -1) return memo[n];

        int min = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) {
            int curr = recMemo(n - i * i, memo);
            min = Math.min(curr, min);
        }

        return min + 1; //1 for taking curr num
    }

    //tabulation works, T(C) N * sqrt(n), SC = O(N)
    public int tabulation(int n) {
        int memo[] = new int[n + 1];

        //base case
        memo[0] = 0;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int curr = memo[i - j * j];
                min = Math.min(min, curr);
            }
            memo[i] = min + 1; // +1 for ans
        }

        return memo[n];

    }
}


