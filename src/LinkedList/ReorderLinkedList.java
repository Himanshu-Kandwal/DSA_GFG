package LinkedList;

/*
https://leetcode.com/problems/reorder-list/description/
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.



Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]


Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000

 */
public class ReorderLinkedList {

    class Solution {
        public void reorderList(ListNode head) {
            ListNode mid = getMid(head);
            ListNode headOfRightHalf = mid.next;
            //break link
            mid.next = null;

            ListNode headOfReversedRightHalf = reverse(headOfRightHalf);

            mergeLists(head, headOfReversedRightHalf);
        }

        public ListNode reverse(ListNode head) {
            if (head == null)
                return null;

            ListNode curr = head;
            ListNode prev = null;
            ListNode next = null;

            while (curr != null) {
                next = curr.next; // store next node
                curr.next = prev; // reverse pointer
                prev = curr; // move prev forward
                curr = next; // move curr forward
            }

            return prev; // new head
        }

        //for even list return first middle node i.e 2 in 1,2,3,4 and for odd return mid in 1,2,3,4,5 it will give 3
        public ListNode getMid(ListNode head) {

            if (head == null)
                return null;

            ListNode temp = head;

            ListNode fast = temp, slow = temp;

            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow;
        }

        public void mergeLists(ListNode head1, ListNode head2) {
            while (head1 != null && head2 != null) {
                ListNode temp1 = head1.next;
                ListNode temp2 = head2.next;

                head1.next = head2;
                if (temp1 == null) break;
                head2.next = temp1;

                head1 = temp1;
                head2 = temp2;
            }
        }


    }
}