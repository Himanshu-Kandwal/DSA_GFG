package PriorityQueue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.


Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0


Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.


Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 */
public class FindMedianFromDataStream {

    public static void main(String[] args) {
        MedianFinder obj = new FindMedianFromDataStream().new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(6);
        obj.addNum(3);
        obj.addNum(4);
        obj.addNum(5);
        obj.addNum(9);
        System.out.println(obj.findMedian());

    }

    class MedianFinder {

        //left half and right half to maintain sorted order, left half will have first half sorted elements and so on
        //we make sure left half contains all element smaller than right half
        // 1,2,3,4,5,6 --> will be left half 1,2,3 , right half 4,5,6
        PriorityQueue<Integer> leftHalf = new PriorityQueue<>(Comparator.reverseOrder()); //max heap so largest of left half stay on top
        PriorityQueue<Integer> rightHalf = new PriorityQueue<>(); //min heap so smallest of left half remain on top


        public MedianFinder() {

        }

        public void addNum(int num) {

            //insertion
            if (leftHalf.isEmpty() || num < leftHalf.peek()) { //if left half is empty or num is smaller than it's largest number
                leftHalf.add(num);
            } else {
                rightHalf.add(num);
            }

            //balance -> make sure heap size difference is not more than 1
            if (leftHalf.size() > rightHalf.size() + 1) {
                rightHalf.add(leftHalf.poll());
            } else if (rightHalf.size() > leftHalf.size() + 1) {
                leftHalf.add(rightHalf.poll());
            }
        }

        public double findMedian() {
            if (leftHalf.size() == rightHalf.size()) {
                return (leftHalf.peek() + rightHalf.peek()) / 2.0;
            }else {
                if(leftHalf.size()>rightHalf.size()) return leftHalf.peek();
                else return rightHalf.peek();
            }
        }

    }

}
