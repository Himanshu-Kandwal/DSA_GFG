/*
You are given a special linked list with n nodes where each node has two pointers a next pointer that points to the next node of the singly linked list, and a random pointer that points to the random node of the linked list.

Construct a copy of this linked list. The copy should consist of the same number of new nodes, where each new node has the value corresponding to its original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list, such that it also represent the same list state. None of the pointers in the new list should point to nodes in the original list.

Return the head of the copied linked list.

NOTE : Original linked list should remain unchanged.

Examples:

Input: head = [[1, 3], [3, 3], [5, NULL], [9, 3]]

Output: head = [[1, 3], [3, 3], [5, NULL], [9, 3]]
Explanation:
Node 1 points to Node 2 as its NEXT and Node 3 as its RANDOM.
Node 2 points to Node 3 as its NEXT and Node 3 as its RANDOM.
Node 3 points to Node 4 as its NEXT and NULL as its RANDOM.
Node 4 points to NULL as its NEXT and Node 3 as its RANDOM.
Input: head = [[1, 3], [2, 1], [3, 5], [4, 3], [5, 2]]


Output: head = [[1, 3], [2, 1], [3, 5], [4, 3], [5, 2]]
Explanation:
Node 1 points to Node 2 as its NEXT and Node 3 as its RANDOM.
Node 2 points to Node 3 as its NEXT and Node 1 as its RANDOM.
Node 3 points to Node 4 as its NEXT and Node 5 as its RANDOM.
Node 4 points to Node 5 as its NEXT and Node 3 as its RANDOM.
Node 5 points to NULL as its NEXT and Node 2 as its RANDOM.
Input: head = [[7, NULL], [7, NULL]]
Output: head = [[7, NULL], [7, NULL]]
Explanation:
Node 1 points to Node 2 as its NEXT and NULL as its RANDOM.
Node 2 points to NULL as its NEXT and NULL as its RANDOM.
Constraints:
1 <= n <= 100
0 <= node->data <= 1000


 */
package LinkedList;

public class CloneListWithNextAndRandomPointers {


    class Node {
        int data;
        Node next;
        Node random;

        Node(int x) {
            data = x;
            next = null;
            random = null;
        }
    }

    //T(N) S(1)
    class Solution {
        public Node cloneLinkedList(Node head) {

       /*step1 -> clone every node just next to original
       i.e 1->2->3->null will be 1->1->2->2->3->3->null
       */
            Node curr=head;
            while(curr!=null){
                Node currNext= curr.next;
                curr.next = new Node(curr.data); //adding duplicate node with curr's data
                curr.next.next=currNext; //adding old "next" of curr to next of duplicate node
                curr=curr.next.next; //curr jumps to two steps i.e to next original node skipping the duplicate node
            }

       /*
       step2 ->
       connect random pointer the way they are connected in original nodes by connecting to random node's next;
       */

            curr=head; //setting curr to first node
            while(curr!=null && curr.next!=null){
                Node random = curr.random;
                curr.next.random = random==null? null : random.next; //connecting duplicate node's random pointer with curr's random's next(or null if random is null);
                curr=curr.next.next; //moving curr to next.next i.e next original node
            }

            // Step 3: Separate the original list from the cloned list
            curr = head; // Start from the original head
            Node cloneHead = head.next; // Save the head of the cloned list
            Node cloneCurr = cloneHead; // Pointer to traverse the cloned list

            while (curr != null) {
                curr.next = curr.next.next; // Restore the original node's next pointer
                cloneCurr.next = (cloneCurr.next != null) ? cloneCurr.next.next : null; // Set cloned node's next pointer
                curr = curr.next; // Move to the next original node
                cloneCurr = cloneCurr.next; // Move to the next cloned node
            }

            return cloneHead; // Return the head of the cloned list


        }
    }
}
