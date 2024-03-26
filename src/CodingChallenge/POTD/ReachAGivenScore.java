package CodingChallenge.POTD;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find number of distinct combinations to reach the given score.

Example 1:

Input
n = 10
Output
2
Explanation
There are two ways {5,5} and {10}.
Example 2:

Input
n = 20
Output
4
Explanation
There are four possible ways. {5,5,5,5}, {3,3,3,3,3,5}, {10,10}, {5,5,10}.
Your Task:
You don't need to read input or print anything. Your task is to complete the function count( ) which takes n as input parameter and returns the answer to the problem.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:

1 ≤ n ≤ 106

 */

public class ReachAGivenScore {
    public static void main(String[] args) {
        System.out.println(new ReachAGivenScore().new Geeks().count(20));
    }
//todo count unique combination only
    class Geeks {

        public long count(int n) {
            return helper(n, new ArrayList<>());
        }

        public long helper(int n, List<Integer> list) {

            if (n == 0) {
                System.out.println(list);
                if(!list.isEmpty()) list.remove(list.size() - 1);
                return 1;
            }

            if (n < 0) {
                if(!list.isEmpty()) list.remove(list.size() - 1);
                return 0;
            }

            list.add(3);
            long ans1 = helper(n - 3, list);

            list.add(5);
            long ans2 = helper(n - 5, list);

            list.add(10);
            long ans3 = helper(n - 10, list);

            if(!list.isEmpty()) list.remove(list.size() - 1);
            return ans1 + ans2 + ans3;
        }

    }
}
