/*
https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order:

Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node. You must prefer the left child over the right child when traversing. Do not include leaf nodes in this section.

Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.

Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root, traversed in reverse order. You must prefer the right child over the left child when traversing. Do not include the root in this section if it was already included in the left boundary.

Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary.

Examples:

Input: root[] = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
Output: [1, 2, 4, 8, 9, 6, 7, 3]
Explanation:

Input: root[] = [1, 2, N, 4, 9, 6, 5, N, 3, N, N, N, N 7, 8]
Output: [1, 2, 4, 6, 5, 7, 8]
Explanation:












As the root doesn't have a right subtree, the right boundary is not included in the traversal.
Input: root[] = [1, N, 2, N, 3, N, 4, N, N]
    1
     \
      2
       \
        3
         \
          4

Output: [1, 4, 3, 2]
Explanation:
Left boundary: [1] (as there is no left subtree)
Leaf nodes: [4]
Right boundary: [3, 2] (in reverse order)
Final traversal: [1, 4, 3, 2]
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105


 */
package Tree;

import java.util.ArrayList;

public class TreeBoundaryTraversal {
    class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    class Solution {

        /**
         * This method returns the boundary traversal of a binary tree in anti-clockwise order.
         * <p>
         * Boundary traversal consists of:
         * 1. The root node.
         * 2. The left boundary (excluding leaf nodes).
         * 3. The leaf nodes (from left to right).
         * 4. The right boundary (excluding leaf nodes, added in reverse order).
         */
        ArrayList<Integer> boundaryTraversal(Node node) {

            ArrayList<Integer> boundaryTraversalNodes = new ArrayList<Integer>();

            // If the tree is empty, return an empty list
            if (node == null) return boundaryTraversalNodes;

            // Step 1: Add the root node
            boundaryTraversalNodes.add(node.data);

            // Step 2: Add the left boundary (excluding leaf nodes)
            Solution.visitLeftBoundary(boundaryTraversalNodes, node.left);

            // Step 3: Add the leaf nodes (left subtree first, then right)
            // This step ensures that if the tree has only one node, it is not counted twice.
            Solution.visitLeafBoundary(boundaryTraversalNodes, node.left);
            Solution.visitLeafBoundary(boundaryTraversalNodes, node.right);

            // Step 4: Add the right boundary (excluding leaf nodes)
            Solution.visitRightBoundary(boundaryTraversalNodes, node.right);

            return boundaryTraversalNodes;
        }

        /**
         * Traverses and adds the left boundary nodes in top-down order,
         * excluding the leaf nodes.
         */
        static void visitLeftBoundary(ArrayList<Integer> list, Node node) {
            if (node == null) return;  // Base case: null node

            if (node.left == null && node.right == null) return;  // Stop at leaf nodes

            list.add(node.data); // Add current node

            // Recur for left child if exists, otherwise recur for right child
            if (node.left != null) {
                visitLeftBoundary(list, node.left);
            } else {
                visitLeftBoundary(list, node.right);
            }
        }

        /**
         * Traverses and adds all the leaf nodes (bottom boundary).
         * It ensures left subtree leaves are added first, followed by right subtree leaves.
         */
        static void visitLeafBoundary(ArrayList<Integer> list, Node node) {
            if (node == null) return;  // Base case: null node

            // If it's a leaf node, add it to the list
            if (node.left == null && node.right == null) {
                list.add(node.data);
            } else {
                // First process left subtree, then right subtree (ensures correct order)
                visitLeafBoundary(list, node.left);
                visitLeafBoundary(list, node.right);
            }
        }

        /**
         * Traverses and adds the right boundary nodes in bottom-up order,
         * excluding the leaf nodes.
         */
        static void visitRightBoundary(ArrayList<Integer> list, Node node) {
            if (node == null) return;  // Base case: null node

            if (node.left == null && node.right == null) return;  // Stop at leaf nodes

            // Recur for right child if exists, otherwise recur for left child
            if (node.right != null) {
                visitRightBoundary(list, node.right);
            } else {
                visitRightBoundary(list, node.left);
            }

            // Add the node after recursion to get the correct bottom-up order
            list.add(node.data);
        }
    }

}
