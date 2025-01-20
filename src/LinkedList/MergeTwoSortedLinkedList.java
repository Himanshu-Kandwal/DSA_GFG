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

public class MergeTwoSortedLinkedList {


/*
  Node is defined as
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

    class Solution {
        class Node
        {
            int data;
            Node next;
            Node(int d) {data = d; next = null; }
        }
        Node sortedMerge(Node head1, Node head2) {

            Node curr1=head1;
            Node curr2=head2;
            Node sortedHead;

            if(curr1.data < curr2.data) {
                sortedHead = new Node(curr1.data);
                curr1= curr1.next;
            }else {
                sortedHead = new Node(curr2.data);
                curr2= curr2.next;
            }

            Node sortedCurr = sortedHead;

            while(curr1!=null && curr2 != null){
                if(curr1.data < curr2.data) {
                    sortedCurr.next = new Node(curr1.data);
                    curr1 = curr1.next;
                }else {
                    sortedCurr.next = new Node(curr2.data);
                    curr2 = curr2.next;
                }
                sortedCurr = sortedCurr.next;
            }

            //if any list got exhausted, add another list to sorted list

            if(curr1==null){
                sortedCurr.next=curr2;
            }

            if(curr2 == null){
                sortedCurr.next=curr1;
            }

            return sortedHead;
        }

    }
}
