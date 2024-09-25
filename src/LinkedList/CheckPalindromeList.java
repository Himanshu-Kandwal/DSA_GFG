package LinkedList;

public class CheckPalindromeList {

    public static void main(String[] args) {
        CheckPalindromeList obj = new CheckPalindromeList();
        Solution sol = obj.new Solution();

        //oddlist
        Node oddList = obj.new Node(1);
        oddList.next = obj.new Node(2);
        oddList.next.next = obj.new Node(3);
        oddList.next.next.next = obj.new Node(2);
        oddList.next.next.next.next = obj.new Node(1);

        //evenlist
        Node evenList = obj.new Node(2);
        evenList.next = obj.new Node(4);
        evenList.next.next = obj.new Node(6);
        evenList.next.next.next = obj.new Node(8);
        evenList.next.next.next.next = obj.new Node(10);
        evenList.next.next.next.next.next = obj.new Node(12);
        evenList.next.next.next.next.next.next = obj.new Node(14);
        evenList.next.next.next.next.next.next.next = obj.new Node(16);
        evenList.next.next.next.next.next.next.next.next = obj.new Node(18);
        evenList.next.next.next.next.next.next.next.next.next = obj.new Node(20);


        System.out.println(sol.isPalindrome(oddList));
        System.out.println(sol.isPalindrome(oddList));


    }

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /*T(N), S(1)

    Approach is simple,
    1) find middle node of linked list, if list is even then 2nd middle node will be returned
    2) reverse list from middle(also included) node to last, it breaks linked list into two lists, original half and reversed half
    3) compare original linked list nodes with reversed half linked list to check palindrome or noy

     */
    class Solution {

        boolean isPalindrome(Node head) {
            Node mid = middleOfList(head);
            Node tail = reverse(mid);

            while (head != null && tail != null) {
                if (head.data != tail.data) return false;
                head = head.next;
                tail = tail.next;
            }

            return true;
        }

        Node middleOfList(Node headNode) {
            Node fast, slow;
            fast = slow = headNode;

            while (fast != null && fast.next != null) {
                slow = slow.next; // Move slow by one step
                fast = fast.next.next; // Move fast by two steps
            }

            return slow;
        }

        Node reverse(Node headNode) {
            if (headNode == null) return null;
            Node prev = null;
            Node temp = null;

            while (headNode != null) {
                temp = headNode.next;
                headNode.next = prev;
                prev = headNode;
                headNode = temp;
            }

            return prev;
        }
    }
}
