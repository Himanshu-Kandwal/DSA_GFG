/*
Given a head of the singly linked list. If a loop is present in the list then return the first node of the loop else return NULL.

Custom Input format:
A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. If pos = 0, it means the last node points to null, indicating there is no loop.

Examples:

Input:

Output: 3
Explanation: We can see that there exists a loop in the given linked list and the first node of the loop is 3.
Input:

Output: -1
Explanation: No loop exists in the above linked list.So the output is -1.
Constraints:
1 <= no. of nodes <= 106
1 <= node->data <= 106

 */
package LinkedList;

public class FirstNodeOfLoopInLinkedList {

    class Solution {

        class Node {
            int data;
            Node next;

            Node(int x) {
                data = x;
                next = null;
            }
        }

        public static Node findFirstNode(Node head) {
            Node fast = head;
            Node slow = head;

            boolean hasLoop = false;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;

                if (slow == fast) {
                    hasLoop = true;
                    break;
                } //flag the variable and break
            }

            //finding first node of loop
            if (hasLoop) {
                slow = head;           //put one pointer to beginning of original linked list
                while (slow != fast) { //moving both pointers at same speed and check if they collide
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow; //return any node as they have collided and it will be beginning of the loop
            }

            return null;

        }
    }
}
