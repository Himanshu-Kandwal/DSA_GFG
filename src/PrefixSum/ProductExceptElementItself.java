/*

Given an array, arr[] construct a product array, res[] where each element in res[i] is the product of all elements in arr[] except arr[i]. Return this resultant array, res[].
Note: Each element is res[] lies inside the 32-bit integer range.

Examples:

Input: arr[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
Explanation: For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.
Input: arr[] = [12, 0]
Output: [0, 12]
Explanation: For i = 0, res[i] is 0.
For i = 1, res[i] is 12.
Constraints:
2 <= arr.size() <= 105
-100 <= arr[i] <= 100

 */
package PrefixSum;

public class ProductExceptElementItself {

    //T(N), S(1) no extra space except output demanded
    class Solution {
        public static int[] productExceptSelf(int[] arr) {
            int[] product = new int[arr.length];

            product[0] = 1; //since this element has no left element to multiply with

            //product from left
            for (int i = 1; i < arr.length; i++) {
                product[i] = product[i - 1] * arr[i - 1];
            }


            int suffixProduct = 1;
//product from right
            for (int i = arr.length - 1; i >= 0; i--) {

                product[i] = product[i] * suffixProduct;
                suffixProduct *= arr[i];
            }

            return product;
        }
    }

}
