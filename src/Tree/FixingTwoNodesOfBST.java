/*
Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original Binary search tree(BST).

Examples :
Input: root = [10, 5, 8, 2, 20]

Output: 1


Explanation: The nodes 20 and 8 were swapped.
Input: root = [5, 10, 20, 2, 8]

Output: 1

Explanation: The nodes 10 and 5 were swapped.
Constraints:
1 ≤ Number of nodes ≤ 103


 */
package Tree;

public class FixingTwoNodesOfBST {
    class Solution {

        Node first=null,middle=null,last=null;
        Node prev=null;

        void correctBST(Node curr) {

            inorderHelper(curr);

            if(first!=null && last!=null){
                int temp=last.data;
                last.data = first.data;
                first.data = temp;
            }else if(first!=null && middle!=null){
                int temp=middle.data;
                middle.data = first.data;
                first.data = temp;
            }

        }

        void inorderHelper(Node curr){

            if(curr==null) return;

            inorderHelper(curr.left);

            if(prev!= null && prev.data>curr.data){
                if(first==null){
                    first=prev;
                    middle=curr;
                }else{
                    last=curr;
                }
            }
            prev=curr;

            inorderHelper(curr.right);
        }
    }
}
