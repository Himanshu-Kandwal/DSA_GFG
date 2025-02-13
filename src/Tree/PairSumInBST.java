/*
Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target.

Examples:

Input: root = [7, 3, 8, 2, 4, N, 9], target = 12
       bst
Output: True
Explanation: In the binary tree above, there are two nodes (8 and 4) that add up to 12.
Input: root = [9, 5, 10, 2, 6, N, 12], target = 23
          bst-3
Output: False
Explanation: In the binary tree above, there are no such two nodes exists that add up to 23.
Constraints:

1 ≤ Number of Nodes ≤ 105
1 ≤ target ≤ 106


 */
package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PairSumInBST {


    //Solution 1 : T(N) S(N)
    /*
    Store inorder of BST into an arraylist and then use two pointers approach to find if pairs exist having sum upto target.
     */

    class Solution1 {
        public boolean findTarget(Node root, int target) {
            //return findTargetBruteForce(root, target);
            return findTargeteInorderApproach(root, target);
        }

        private boolean findTargeteInorderApproach(Node root, int target) {
            ArrayList<Integer> nodesDataList = new ArrayList<>();
            inorderTraversal(nodesDataList, root);
            return isPairSumEqualsToTargetExists(nodesDataList, target);
        }

        //inorder traversal of BST gets us all nodes in sorted order into arraylist
        private void inorderTraversal(ArrayList<Integer> nodesDataList, Node root) {
            if (root == null) return;
            inorderTraversal(nodesDataList, root.left);
            nodesDataList.add(root.data);
            inorderTraversal(nodesDataList, root.right);
        }

        //two pointers approach to find if there exist a target
        private boolean isPairSumEqualsToTargetExists(ArrayList<Integer> list, int target) {
            if (list == null || list.isEmpty()) return false;

            int start = 0;
            int end = list.size() - 1;

            while (start < end) {
                int currSum = list.get(start) + list.get(end);
                //if target  sum found return true
                if (currSum == target) return true;

                //If target sum not found
                //and it bigger than target
                if (currSum > target) {
                    end--;
                } else {
                    start++;
                }
            }

            return false;
        }
    }

    //Solution 2 : T(N) S(N)
    /*
    Traverse BST in inorder way check if (target minus currentData) in hashSet, if yes return true, otherwise add curr node's data to hashset
     and do left and right call.
     */
    class Solution2 {
        public boolean findTarget(Node root, int target) {
            Set<Integer> set = new HashSet<>();
            return Solution2.findTargetHelper(root, set, target);
        }

        private static boolean findTargetHelper(Node root, Set<Integer> set, int target) {
            if (root == null) return false;

            int currNodeData = root.data;

            int remaining = target - currNodeData;

            if (set.contains(remaining)) return true;

            set.add(currNodeData);

            return findTargetHelper(root.left, set, target) || findTargetHelper(root.right, set, target);

        }
    }

    //Solution T(N) S(H)
    /*
    Take two pointers left and right respectively to smallest node and largest node, and use two pointers approach this way.
    we dont need to store all nodes in arraylist
     */
    class Solution3 {
        public boolean findTarget(Node root, int target) {
            if (root == null) return false;

            // Set up two BST pointers
            BSTPointer left = new BSTPointer(root, true);  // Moves left to find smallest values
            BSTPointer right = new BSTPointer(root, false); // Moves right to find largest values

            // Get initial values without moving the pointers
            int lValue = left.value();
            int rValue = right.value();

            while (lValue < rValue) {
                int currSum = lValue + rValue;

                if (currSum == target) return true; // Found a valid pair

                if (currSum < target) { // Need a larger sum, move left pointer forward
                    left.next();
                    lValue = left.value();  // Get the updated value
                } else { // Need a smaller sum, move right pointer backward
                    right.next();
                    rValue = right.value(); // Get the updated value
                }
            }
            return false; // No valid pair found
        }
    }

    // BSTPointer behaves like a pointer rather than an iterator
    class BSTPointer {
        private Stack<Node> stack = new Stack<>();
        private boolean isForward; // True for inorder (left to right), False for reverse inorder (right to left)

        // Constructor initializes the stack to start from smallest/largest node
        public BSTPointer(Node root, boolean isForward) {
            this.isForward = isForward;
            pushNodesIntoStack(root);
        }

        // Pushes nodes into the stack (either for leftmost or rightmost traversal)
        private void pushNodesIntoStack(Node node) {
            while (node != null) {
                stack.push(node);  // Push current node onto the stack
                node = isForward ? node.left : node.right;  // Move in correct direction
            }
        }

        // Returns the current top value without moving the pointer
        public int value() {
            return stack.peek().data; // Return the top value without popping
        }

        // Moves the pointer to the next element in the traversal
        public void next() {
            Node curr = stack.pop(); // Move pointer by popping the top node

            // If moving forward (inorder), push right subtree
            if (isForward) {
                pushNodesIntoStack(curr.right);
            }
            // If moving backward (reverse inorder), push left subtree
            else {
                pushNodesIntoStack(curr.left);
            }
        }

    }


}
