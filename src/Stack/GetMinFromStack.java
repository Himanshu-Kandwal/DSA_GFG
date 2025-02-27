/*

Given q queries, You task is to implement the following four functions for a stack:

push(x) – Insert an integer x onto the stack.
pop() – Remove the top element from the stack.
peek() - Return the top element from the stack. If the stack is empty, return -1.
getMin() – Retrieve the minimum element from the stack in O(1) time. If the stack is empty, return -1.
Each query can be one of the following:

1 x : Push x onto the stack.
2 : Pop the top element from the stack.
3: Return the top element from the stack. If the stack is empty, return -1.
4: Return the minimum element from the stack.
Examples:

Input: q = 7, queries = [[1, 2], [1, 3], [3], [2], [4], [1, 1], [4]]
Output: [3, 2, 1]
Explanation:
push(2): Stack is [2]
push(3): Stack is [2, 3]
peek(): Top element is 3
pop(): Removes 3, stack is [2]
getMin(): Minimum element is 2
push(1): Stack is [2, 1]
getMin(): Minimum element is 1
Input: q = 4, queries = [[1, 4], [1, 2], [4], [3]]
Output: [2, 2]
Explanation:
push(4): Stack is [4]
push(2): Stack is [4, 2]
getMin(): Minimum element is 2
peek(): Top element is 2
Input: q = 5, queries = [[1, 10], [4], [1, 5], [4], [2]]
Output: [10, 5]
Explanation:
push(10): Stack is [10]
getMin(): Minimum element is 10
push(5): Stack is [10, 5]
getMin(): Minimum element is 5
pop(): Removes 5, stack is [10]
Constraints:
1 <= q <= 105
0 <= values on the stack <= 109


 */
package Stack;
import java.util.Stack;

public class GetMinFromStack {

    class Solution {

        public Solution() {}

        Stack<Integer> stack=new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        // Add an element to the top of Stack
        public void push(int x) {
            stack.push(x);
            //add x to min stack if min stack is empty, OR min stack's top element is bigger than x
            if(minStack.isEmpty() || x <= minStack.peek()){
                minStack.push(x);
            }
        }

        // Remove the top element from the Stack
        public void pop() {
            if(!stack.isEmpty()){
                int removed = stack.pop(); //remove top from stack
                if(removed==minStack.peek()) minStack.pop(); //check if minStack has removed value on top, if yes remove it from here also
            }
        }

        // Returns top element of the Stack
        public int peek() {
            return stack.isEmpty()? -1 : stack.peek();
        }

        // Finds minimum element of Stack
        public int getMin() {
            return minStack.isEmpty()? -1 : minStack.peek();
        }
    }
}
