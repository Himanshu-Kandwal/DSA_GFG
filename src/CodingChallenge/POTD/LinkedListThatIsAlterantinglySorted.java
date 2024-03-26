package CodingChallenge.POTD;

/*

https://www.geeksforgeeks.org/problems/linked-list-that-is-sorted-alternatingly/1

You are given a Linked list of size n. The list is in alternating ascending and descending orders. Sort the given linked list in non-decreasing order.

Example 1:

Input:
n = 6
LinkedList = 1->9->2->8->3->7
Output: 1 2 3 7 8 9
Explanation:
After sorting the given list will be 1->2->3->7->8->9.
Example 2:

Input:
n = 5
LinkedList = 13->99->21->80->50
Output: 13 21 50 80 99
Explanation:
After sorting the given list will be 13->21->50->80->99.
Your Task:
You do not need to read input or print anything. The task is to complete the function sort() which should sort the linked list of size n in non-decreasing order.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= Number of nodes <= 100
0 <= Values of the elements in linked list <= 103

*/

public class LinkedListThatIsAlterantinglySorted {
    public static void main(String[] args) {
        //making list
        Node head = new Node(1);
        head.next = new Node(9);
        head.next.next = new Node(2);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(7);

        Solution obj = new LinkedListThatIsAlterantinglySorted().new Solution();

        obj.print(obj.sort(head));
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
//solution class for GFG
    class Solution {

        public Node sort(Node head) {
            Node temp = head; //for traversing whole list

            Node head1 = new Node(0); //head for increasing nodes list
            Node head2 = new Node(0); // head for decreasing nodes list

            Node temp1 = head1; //for traversing increasing nodes list
            Node temp2 = head2; //for traversing decreasing nodes list

            Node increasingLastNode = null; //keep track of last node increasing list

            boolean isIncreasingNode = true; //toggle which will tell if we are on increasing node or decreasing node in alternatingly sorted list

            //1-8-2-7-3-6-4-5

            while (temp != null) {
                if (isIncreasingNode) {
                    temp1.next = temp;
                    temp1 = temp1.next;
                    isIncreasingNode = false;
                    increasingLastNode = temp;
                } else {
                    temp2.next = temp;
                    temp2 = temp2.next;
                    isIncreasingNode = true;
                }
                temp = temp.next;
            }

            Node reversedHead = reverse(head2.next);
            increasingLastNode.next = reversedHead; //joining reversed of decreasing list with last node of increasing last node

            return head1.next;
        }

        public Node reverse(Node head) {
            //1-2-3-4-5-6
            Node prev = null;
            Node next;
            Node curr = head;

            while (curr != null) {
                next = curr.next;
                Node temp = curr;
                curr.next = prev;
                prev = temp;
                curr = next;
            }

            return prev;
        }

        //not needed in GFG but for debugging
        public void print(Node head) {
            while (head != null) {
                System.out.print(head.data + "->");
                head = head.next;
            }
        }
    }
}
