package CodingChallenge.POTD;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/problems/zigzag-tree-traversal/1

Given a binary tree with n nodes. Find the zig-zag level order traversal of the binary tree.

Example 1:

Input:
         1
       /    \
      2      3
    /  \    /   \
   4    5   6    7

Output:
1 3 2 4 5 6 7
Example 2:

Input:
           7
        /     \
       9      7
     /  \      /
    8   8  6
   /  \
  10  9
Output:
7 7 9 8 8 6 9 10
Your Task:
You don't need to read input or print anything. Your task is to complete the function zigZagTraversal() which takes the root node of the Binary Tree as its input and returns a list containing the node values as they appear in the zig-zag level-order traversal of the tree.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 <= n <= 105

 */
public class ZigZagTreeTraversal {
    public static void main(String[] args) {
        GFG obj = new GFG();

        //building tree
        /*

         1
       /    \
      2      3
    /  \    /  \
   4    5  6    7

Zig Zag = [1, 3, 2, 4, 5, 6, 7]

         */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(obj.zigZagTraversal(root));
    }
}

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    //Function to store the zig zag order traversal of tree in a list.
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> zigZagList = new ArrayList<Integer>();
        if (root == null) return zigZagList;
        Queue<Node> nodeQueue = new LinkedList<>();

        boolean isLTR = true; //LTR=Left To Right
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            //arrayList to save current node;
            int currRowSize = nodeQueue.size();
            List<Integer> currRowList = new LinkedList<>();

            for (int i = 0; i < currRowSize; i++) {
                Node currNode = nodeQueue.remove();

                int idx = isLTR ? i : 0; /*small trick to find index to store value based on isLTR flag
                if flag is true insert from ith index otherwise from the start i.e 0. so no need to explicitly reverse the
                curr arraylist, by adding at zero, arraylist shifts 1st item at 2nd and curr item at 0th idx, hence we changed to linkedlist
                */
                currRowList.add(idx, currNode.data);

                if (currNode.left != null) {
                    nodeQueue.add(currNode.left);
                }

                if (currNode.right != null) {
                    nodeQueue.add(currNode.right);
                }
            }

            isLTR = !isLTR;
            zigZagList.addAll(currRowList); //adding curr row to answer list
        }

        return zigZagList;
    }
}
