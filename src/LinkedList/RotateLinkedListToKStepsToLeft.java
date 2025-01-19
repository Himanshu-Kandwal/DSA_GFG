/*

Given the head of a singly linked list, your task is to left rotate the linked list k times.

Examples:

Input: head = 10 -> 20 -> 30 -> 40 -> 50, k = 4
Output: 50 -> 10 -> 20 -> 30 -> 40
Explanation:
Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
Rotate 4: 50 -> 10 -> 20 -> 30 -> 40

Input: head = 10 -> 20 -> 30 -> 40 , k = 6
Output: 30 -> 40 -> 10 -> 20

Constraints:

1 <= number of nodes <= 105
0 <= k <= 109
0 <= data of node <= 109

 */
package LinkedList;

public class RotateLinkedListToKStepsToLeft {

/*

Node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

    class Solution {

        class Node{
            int data;
            Node next;
            Node(int d){
                data=d;
                next=null;
            }
        }
        public Node rotate(Node head, int k)
        {
            if (k == 0 || head == null || head.next == null) { // Added check for null or single node list
                return head;
            }

            int totalNodes = 1;
            Node curr = head;

            // Count nodes, and also make curr pointer reach tail
            while (curr.next != null) {
                totalNodes++;
                curr = curr.next;
            }

            k = k % totalNodes;
            if (k == 0) { // Simplified the condition to check only if k is 0
                return head;
            }

            // Make the linked list circular
            curr.next = head;

            // Calculate the position of the new head
            int positionOfNewHead = totalNodes - k;

            // Move to the node just before the new head
            for (int i = 1; i < k; i++) {
                head = head.next;
            }

            // Get the new head
            Node newHead = head.next;

            // Break the circular list
            head.next = null;

            return newHead;
        }
    }
}
