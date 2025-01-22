/*
Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Examples:

Input: num1 = 4 - > 5, num2 = 3 -> 4 -> 5
Output:  3 -> 9 -> 0

Explanation: Given numbers are 45 and 345. There sum is 390.
Input: num1 = 0 -> 0 -> 6 -> 3, num2 = 0 -> 7
Output: 7 -> 0

Explanation: Given numbers are 63 and 7. There sum is 70.
Constraints:
1 <= size of both linked lists <= 106
0 <= elements of both linked lists <= 9


 */
package LinkedList;

public class AddTwoNumberRepresentedByLinkedLists {


    class Solution {

        static class Node {
            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }
        /*

        Approach: reverse both linked lists so we can add from right most digit and go to left most,

        add values node by node and carry by storing in a sum variable, nullify carry and check if sum has new carry.
        if it has then add sum%10 i.e last digit to answer list and take 1 as carry. if no carry is their in sum, add sum directly to answer list
        loop until both or any one linked list gets exhausted.

        if any list exhausted, add other lists digits in same way above mentioned.
        at the end check if carry is still not zero, if non zero add it as new digit in answer list.

        reverse the answer list keeping pointers to head i.e left most digit.

        loop until we remove all leading/beginning zeros from the answer list as problem statement tells.

        return head of answer list node.

         */
        //T(N) S(N)
        static Node addTwoLists(Node ll1, Node ll2) {

            Node revNum1 = reverseList(ll1);
            Node revNum2 = reverseList(ll2);

            Node result = new Node(0);
            Node tempResult = result;
            int carry = 0;

            while (revNum1 != null && revNum2 != null) {

                int num1 = revNum1.data;
                int num2 = revNum2.data;

                int sum = num1 + num2 + carry;
                carry = 0; //old carry nullified

                if (sum >= 10) { //carry is there
                    tempResult.next = new Node(sum % 10); //last digit added
                    carry = 1; //new carry
                } else { //no carry
                    tempResult.next = new Node(sum);
                }

                tempResult = tempResult.next;
                revNum1 = revNum1.next;
                revNum2 = revNum2.next;
            }

            //if any list got exhausted , add it

            while (revNum1 != null) {
                int sum = revNum1.data + carry;
                carry = 0; //nullified

                if (sum >= 10) { //carry is there
                    tempResult.next = new Node(sum % 10); //last digit added
                    carry = 1; //new carry
                } else { //no carry
                    tempResult.next = new Node(sum);
                }
                tempResult = tempResult.next;
                revNum1 = revNum1.next;
            }

            while (revNum2 != null) {
                int sum = revNum2.data + carry;
                carry = 0; //nullified

                if (sum >= 10) { //carry is there
                    tempResult.next = new Node(sum % 10); //last digit added
                    carry = 1; //new carry
                } else { //no carry
                    tempResult.next = new Node(sum);
                }
                tempResult = tempResult.next;
                revNum2 = revNum2.next;
            }

            //if still carry is remaining
            if (carry != 0)
                tempResult.next = new Node(carry);


            Node answer = reverseList(result.next); // result already has initial extra node, which got skipped here, and reverse of result is returned as we solved in reversed order of original lists

            //removing leading/beginning zero in answer if they exists.
            while (answer.data == 0) {
                answer = answer.next;
            }
            return answer;
        }

        static Node reverseList(Node head) {
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
