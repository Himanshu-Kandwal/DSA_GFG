/*
Given a doubly linked list. Your task is to reverse the doubly linked list and return its head.

Examples:

Input: LinkedList: 3 <-> 4 <-> 5
Output: 5 <-> 4 <-> 3

Input: LinkedList: 75 <-> 122 <-> 59 <-> 196
Output: 196 <-> 59 <-> 122 <-> 75

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 <= number of nodes <= 106
0 <= node->data <= 104


 */
package LinkedList;

public class ReverseDoublyLinkedList {

    class Solution {
        class DLLNode {
            int data;
            DLLNode next;
            DLLNode prev;

            DLLNode(int val) {
                data = val;
                next = null;
                prev = null;
            }
        }

        public DLLNode reverseDLL(DLLNode head) {
            if (head.next == null) return head;

            DLLNode curr = head;
            DLLNode temp = null;
            while (curr != null) {
                temp = curr.prev; //saving prev link so we dont lose it

//both following line switch links, i.e prev becomes next and vice versa
                curr.prev = curr.next;
                curr.next = temp;

                curr = curr.prev; //curr moves to another node , since we have swapped nodes
            }

            return temp.prev; //since curr is null, and temp is just before curr, so return temp.prev as head of new DLL
        }

    }
}
