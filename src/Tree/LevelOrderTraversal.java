/*
Given a root of a binary tree with n nodes, the task is to find its level order traversal. Level order traversal of a tree is breadth-first traversal for the tree.

Examples:

Input: root[] = [1, 2, 3]

Output: [[1], [2, 3]]
Input: root[] = [10, 20, 30, 40, 50]

Output: [[10], [20, 30], [40, 50]]
Input: root[] = [1, 3, 2, N, N, N, 4, 6, 5]

Output: [[1], [3, 2], [4], [6, 5]]
Constraints:

1 ≤ number of nodes ≤ 105
0 ≤ node->data ≤ 109

 */
package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    //every level separately added to answer list
    public ArrayList<ArrayList<Integer>> levelOrderLevelByLevel(Node root) {
        ArrayList<ArrayList<Integer>> levelOrderList = new ArrayList<>();
        Queue<Node> nodesQueue = new LinkedList<>();

        nodesQueue.add(root);


        while (!nodesQueue.isEmpty()) {
            ArrayList<Integer> currLevelList = new ArrayList<Integer>();

            int totalNodes = nodesQueue.size(); //get total nodes for curr level

            //take all nodes out and add their value to curr level list
            for (int i = 0; i < totalNodes; i++) {
                Node curr = nodesQueue.poll();
                currLevelList.add(curr.data);

                //adding left child if not null to queue
                if (curr.left != null)
                    nodesQueue.add(curr.left);

                //adding right child if not null to queue
                if (curr.right != null)
                    nodesQueue.add(curr.right);

            }

            levelOrderList.add(currLevelList); //add curr level to ans
        }
        return levelOrderList;

    }

    //all level in one array list one after another
    static ArrayList <Integer> levelOrder(Node root)
    {
        ArrayList<Integer> list= new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            Node curr= queue.remove();
            list.add(curr.data);

            //add left node
            if(curr.left!=null)
            {
                queue.add(curr.left);
            }

            //add right node
            if(curr.right!=null)
            {
                queue.add(curr.right);
            }

        }

        return list;
    }


    }
