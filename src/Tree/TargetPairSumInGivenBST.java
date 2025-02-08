/*
https://www.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1
Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target.

Examples:

Input: root[] = [7, 3, 8, 2, 4, N, 9], target = 12
       bst
Output: True
Explanation: In the binary tree above, there are two nodes (8 and 4) that add up to 12.
Input: root[] = [9, 5, 10, 2, 6, N, 12], target = 23
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

public class TargetPairSumInGivenBST {

    class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }


    class Solution {

        public boolean findTarget(Node root, int target) {
            //return findTargetBruteForce(root, target);
            return findTargetBruteForceInorder(root, target);
        }


        //APPROACH 1 - Bruteforce //  T(N) S(N) for storing all nodes in inorder into list
        /*
        Traverse whole BST in inorder traversal so we get a sorted array list of all nodes.
        Now use two pointer approach to check if sum exists or not
         */
        private boolean findTargetBruteForceInorder(Node root, int target) {
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


        //APPROACH 2 - Optimal, T(N), S(N) for extra HashSet of all nodes

        /*
        We simply add data to hashset while traversing whole tree and check remaining i.e target - node.data available in hashset or not
        If yes we return true otherwise traverse other nodes.
        This is like Two Sum problem of arrays in BSTs
         */
        public boolean findTargetOptimal(Node root, int target) {
            Set<Integer> set = new HashSet<>();
            return Solution.findTargetOptimalHelper(root, set, target);
        }

        private static boolean findTargetOptimalHelper(Node root, Set<Integer> set, int target) {
            if (root == null) return false;

            int currNodeData = root.data;

            int remaining = target - currNodeData;

            if (set.contains(remaining)) return true;

            set.add(currNodeData);

            return findTargetOptimalHelper(root.left, set, target) || findTargetOptimalHelper(root.right, set, target);

        }

    }
}
