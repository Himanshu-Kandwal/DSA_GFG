/*
https://www.geeksforgeeks.org/problems/powx-n/1
Implement the function power(b, e), which calculates b raised to the power of e (i.e. be).

Examples:

Input: b = 3.00000, e = 5
Output: 243.00000
Input: b = 0.55000, e = 3
Output: 0.16638
Input: b = -0.67000, e = -7
Output: -16.49971
Constraints:

-100.0 < b < 100.0
-109 <= e <= 109
Either b is not zero or e > 0.
-104 <= be <= 104

 */
package RecursionAndBacktracking;

public class ImplementPow {

    class Solution {

        double power(double base, int power) {

            int absPower = Math.abs(power);

            double result  = helper(base,absPower);

            if(power<0)
            {
                return 1.0/result; //negative power so return 1/result
            }

            return result;
        }

        //T(log n) , S(log n)
        double helper(double base, int power) {

            if(power==0) return 1.0d;

            double curr;

            double half = helper(base,power/2);

            if(power%2==0){ //power is even e.g 2^10 = 2^5 * 2^5
                curr = half * half;
            }else {
                curr = base * half * half; // 2^11 = 2 * 2^5 * 2^5;
            }
            return curr;
        }
    }
}
