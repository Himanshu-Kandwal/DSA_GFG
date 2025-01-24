/*
https://www.geeksforgeeks.org/problems/detect-loop-in-linked-list/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
You are given the head of a singly linked list. Your task is to determine if the linked list contains a loop. A loop exists in a linked list if the next pointer of the last node points to any other node in the list (including itself), rather than being null.

Custom Input format:
A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. If pos = 0, it means the last node points to null, indicating there is no loop.

Examples:

Input: head: 1 -> 3 -> 4, pos = 2
Output: true
Explanation: There exists a loop as last node is connected back to the second node.

Input: head: 1 -> 8 -> 3 -> 4, pos = 0
Output: false
Explanation: There exists no loop in given linked list.

Input: head: 1 -> 2 -> 3 -> 4, pos = 1
Output: true
Explanation: There exists a loop as last node is connected back to the first node.


Constraints:
1 ≤ number of nodes ≤ 104
1 ≤ node->data ≤ 103
0 ≤ pos ≤ Number of nodes in Linked List

 */
package LinkedList;

public class DetectLoopInLinkedList {

    //T(N), S(1)
    /*
    Take fast(moves by 2 steps) pointer and slow(moves by 1 step) and keep moving them until fast.next or fast itself becomes null
    or
    both pointers collide.

    if they collide it has loop
    if they did not collide means fast is null then it has no loop
     */
    class Solution {

        class Node{
            int data;
            Node next=null;
            Node(int data){
                this.data=data;
            }
        }
        // Function to check if the linked list has a loop.
        public static boolean detectLoop(Node head) {
            Node fast=head;
            Node slow=head;

            while(fast!=null && fast.next!=null){

                fast=fast.next.next;
                slow= slow.next;
                if(fast==slow) return true;

            }

            return false;
        }
    }
}
