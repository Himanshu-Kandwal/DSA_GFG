/*
Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

Examples:

Input: root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
Output: 42
Explanation:

Max path sum is represented using green colour nodes in the above binary tree.
Input: root[] = [-17, 11, 4, 20, -2, 10]
Output: 31
Explanation:

Max path sum is represented using green colour nodes in the above binary tree.
Constraints:
1 ≤ number of nodes ≤ 103
-104 ≤ node->data ≤ 104

 */
package Tree;

public class MaxPathSumFromAnyNode {
    class Solution {
        int maxSum = Integer.MIN_VALUE; // Global variable to track max path sum

        // Function to find maximum path sum
        int findMaxSum(Node node) {
            helper(node);  // Start recursion
            return maxSum; // Return final max sum
        }

        // Helper function to compute max path sum using recursion
        int helper(Node node) {
            if (node == null) return 0;  // Base case: If node is null, return 0

            // Recursively find max sum from left and right subtrees
            int leftSum = helper(node.left);
            int rightSum = helper(node.right);

            // If a subtree contributes negatively, ignore it (take 0 instead)
            if (leftSum < 0) leftSum = 0;
            if (rightSum < 0) rightSum = 0;

            // Compute max path sum that includes this node and both children
            int sumFromChildren = leftSum + rightSum;
            int currMax = node.data + sumFromChildren; // Path sum including node itself

            // Update global max sum (considering full path passing through this node)
            maxSum = Math.max(maxSum, currMax);

            // Return the max one-side path sum (only left or right, not both)
            return node.data + Math.max(leftSum, rightSum);
        }
    }

}
