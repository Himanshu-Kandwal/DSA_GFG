/*
Given two arrays representing the inorder and preorder traversals of a binary tree, construct the tree and return the root node of the constructed tree.

Note: The output is written in postorder traversal.

Examples:

Input: inorder[] = [1, 6, 8, 7], preorder[] = [1, 6, 7, 8]
Output: [8, 7, 6, 1]
Explanation: The tree will look like

Input: inorder[] = [3, 1, 4, 0, 2, 5], preorder[] = [0, 1, 3, 4, 2, 5]
Output: [3, 4, 1, 5, 2, 0]
Explanation: The tree will look like

Input: inorder[] = [2, 5, 4, 1, 3], preorder[] = [1, 4, 5, 2, 3]
Output: [2, 5, 4, 3, 1]
Explanation: The tree will look like

Constraints:
1 ≤ number of nodes ≤ 103
0 ≤ nodes -> data ≤ 103
Both the inorder and preorder arrays contain unique values.


 */
package Tree;

import java.util.HashMap;

public class ConstructTreeFromPreOrderInOrder {

}

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Solution {

    static int preorderIndex = 0;
    static HashMap<Integer, Integer> inorderMap;

    public static Node buildTree(int[] inorder, int[] preorder) {
        inorderMap = new HashMap<>();
        preorderIndex = 0;

        // Store inorder indexes in a HashMap for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return constructTree(preorder, 0, inorder.length - 1);
    }

    private static Node constructTree(int[] preorder, int left, int right) {
        // Base condition
        if (left > right) return null;

        // Pick the current root from preorder using preorderIndex
        int rootValue = preorder[preorderIndex++];
        Node root = new Node(rootValue);

        // Get inorder index of the root
        int inorderIndex = inorderMap.get(rootValue);

        // Recursively construct left and right subtrees
        root.left = constructTree(preorder, left, inorderIndex - 1);
        root.right = constructTree(preorder, inorderIndex + 1, right);

        return root;
    }
}

