package array;
/*
https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/description/
We have a wooden plank of the length n units. Some ants are walking on the plank, each ant moves with a speed of 1 unit per second. Some of the ants move to the left, the other move to the right.

When two ants moving in two different directions meet at some point, they change their directions and continue moving again. Assume changing directions does not take any additional time.

When an ant reaches one end of the plank at a time t, it falls out of the plank immediately.

Given an integer n and two integer arrays left and right, the positions of the ants moving to the left and the right, return the moment when the last ant(s) fall out of the plank.



Example 1:


Input: n = 4, left = [4,3], right = [0,1]
Output: 4
Explanation: In the image above:
-The ant at index 0 is named A and going to the right.
-The ant at index 1 is named B and going to the right.
-The ant at index 3 is named C and going to the left.
-The ant at index 4 is named D and going to the left.
The last moment when an ant was on the plank is t = 4 seconds. After that, it falls immediately out of the plank. (i.e., We can say that at t = 4.0000000001, there are no ants on the plank).
Example 2:


Input: n = 7, left = [], right = [0,1,2,3,4,5,6,7]
Output: 7
Explanation: All ants are going to the right, the ant at index 0 needs 7 seconds to fall.
Example 3:


Input: n = 7, left = [0,1,2,3,4,5,6,7], right = []
Output: 7
Explanation: All ants are going to the left, the ant at index 7 needs 7 seconds to fall.


Constraints:

1 <= n <= 104
0 <= left.length <= n + 1
0 <= left[i] <= n
0 <= right.length <= n + 1
0 <= right[i] <= n
1 <= left.length + right.length <= n + 1
All values of left and right are unique, and each value can appear only in one of the two arrays.

 */
public class LastMomentBeforeAllAntsFalloutOfAPlank {
    class Solution {
        public int getLastMoment(int n, int[] left, int[] right) {
            int maxtimeLeftAntsNeedToFall = 0;

            // The ant furthest from 0 (i.e. with the largest value in `left`) will take the longest to fall.
            // Others are closer to 0 and will fall off earlier. So we only care about the max(left[i]).
            for (int i = 0; i < left.length; i++) {
                maxtimeLeftAntsNeedToFall = Math.max(maxtimeLeftAntsNeedToFall, left[i]);
            }

            int maxtimeRightAntsNeedToFall = 0;

            // Ants moving right fall off at position n. The one furthest from n (i.e. with smallest right[j]) takes the longest.
            // So, we compute n - right[j] for each ant, and take the max.
            for (int j = 0; j < right.length; j++) {
                maxtimeRightAntsNeedToFall = Math.max(maxtimeRightAntsNeedToFall, n - right[j]);
            }

            // The last moment any ant falls is the later of the above two max times.
            // No other ant can fall later than the slowest of these two ends.
            return Math.max(maxtimeRightAntsNeedToFall, maxtimeLeftAntsNeedToFall);
        }
    }

}
