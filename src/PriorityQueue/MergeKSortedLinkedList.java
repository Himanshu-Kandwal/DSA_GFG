/*
Given an array arr[] of n sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list, then return the head of the merged linked list.

Examples:

Input: arr[] = [1 -> 2 -> 3, 4 -> 5, 5 -> 6, 7 -> 8]
Output: 1 -> 2 -> 3 -> 4 -> 5 -> 5 -> 6 -> 7 -> 8
Explanation:
The arr[] has 4 sorted linked list of size 3, 2, 2, 2.
1st list: 1 -> 2-> 3
2nd list: 4 -> 5
3rd list: 5 -> 6
4th list: 7 -> 8
The merged list will be:

Input: arr[] = [1 -> 3, 8, 4 -> 5 -> 6]
Output: 1 -> 3 -> 4 -> 5 -> 6 -> 8
Explanation:
The arr[] has 3 sorted linked list of size 2, 3, 1.
1st list: 1 -> 3
2nd list: 8
3rd list: 4 -> 5 -> 6
The merged list will be:

Constraints
1 <= total no. of nodes <= 105
1 <= node->data <= 103


*/

package PriorityQueue;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {


    class Solution {

        class Node
        {
            int data;
            Node next;

            Node(int key)
            {
                data = key;
                next = null;
            }
        }

        // Function to merge K sorted linked list.
        Node mergeKLists(List<Node> arr) {
            Node mergedHead=new Node(0);

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(Node curr : arr){
                addListToHeap(pq,curr);
            }
            return convertHeapIntoList(pq);
        }

        void addListToHeap(PriorityQueue<Integer> pq, Node list){
            if(list==null) return;

            while(list!=null){

                pq.add(list.data);
                list=list.next;

            }

        }

        Node convertHeapIntoList(PriorityQueue<Integer> pq){
            Node mergedHead=new Node(0);
            Node temp=mergedHead;

            while(!pq.isEmpty()){
                temp.next = new Node(pq.remove());
                temp=temp.next;
            }
            return mergedHead.next;
        }
    }
}
