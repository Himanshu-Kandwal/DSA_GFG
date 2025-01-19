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
