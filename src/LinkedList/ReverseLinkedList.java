/*

https://www.geeksforgeeks.org/reverse-a-linked-list/

Given the head of a linked list, the task is to reverse this list and return the reversed head.

Examples:

Input: head: 1 -> 2 -> 3 -> 4 -> NULL
Output: head: 4 -> 3 -> 2 -> 1 -> NULL
Explanation:

Input: head: 2 -> 7 -> 10 -> 9 -> 8 -> NULL
Output: head: 8 -> 9 -> 10 -> 7 -> 2 -> NULL
Explanation:

Input: head: 2 -> NULL
Output: 2 -> NULL
Explanation:

Constraints:
1 <= number of nodes, data of nodes <= 105


 */
package LinkedList;

public class ReverseLinkedList {

    //T(N), S(1)l
    class Solution {

        class Node {
            int data;
            Node next;

            Node(int value) {
                this.data = value;
            }
        }

        /*
        we take prev node at null, and move curr pointer step by step ahead while keeping it's next in temp variable
        at the same time connecting it with prev node, and moving curr to nexttemp and prev to current. this way we reverse direction
        of all nodes. finally return prev node as it is the new head now.
         */
        Node reverseList(Node head) {
            Node prev = null;
            Node curr = head;

            while (curr != null) {
                Node tempNext = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tempNext;
            }

            return prev;
        }
    }
}
