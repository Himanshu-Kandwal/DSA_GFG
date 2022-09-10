/*

LINK https://codeforces.com/problemset/problem/1681/D

You are given two integer numbers, n and x. You may perform several operations with the integer x.

Each operation you perform is the following one: choose any digit y that occurs in the decimal representation of x at least once, and replace x by x⋅y.

You want to make the length of decimal representation of x (without leading zeroes) equal to n. What is the minimum number of operations required to do that?

Input
The only line of the input contains two integers n and x (2≤n≤19; 1≤x<10n−1).

Output
Print one integer — the minimum number of operations required to make the length of decimal representation of x (without leading zeroes) equal to n, or −1 if it is impossible.

Examples
inputCopy
2 1
outputCopy
-1
inputCopy
3 2
outputCopy
4
inputCopy
13 42
outputCopy
12
Note
In the second example, the following sequence of operations achieves the goal:

multiply x by 2, so x=2⋅2=4;
multiply x by 4, so x=4⋅4=16;
multiply x by 6, so x=16⋅6=96;
multiply x by 9, so x=96⋅9=864.

 */

import java.util.*;

public class RequiredLengthCodeforces {
    public static void main(String[] args) {
        int x = 75804550;
        int n = 19;
        //System.out.println(digits(13));

        System.out.println(minimum_op(n, x));

    }

    public static int minimum_op(int n, int num) {
        HashSet<Long> visited = new HashSet<>();
        Queue<NumberPair> q = new LinkedList<>();
        q.add(new NumberPair(num, 0));
        //4
        while (!q.isEmpty()) {
            NumberPair nPair = q.remove();

            long number = nPair.num;
            if (visited.contains(number)) continue;
            visited.add(number);

            System.out.println(number);
            while (number != 0) {
                if (number % 10 != 0 || number % 10 != 1) {
                    NumberPair newNum = new NumberPair(nPair.num * (number % 10), nPair.op + 1);
                    if (digits(newNum.num) == n) return newNum.op;
                    if (digits(newNum.num) > n) continue;
                    q.add(newNum);
                }
                number /= 10;
            }

        }
        return -1;
    }

    static int digits(long n) {
        return (int) Math.floor(Math.log10(n) + 1);
    }

}

class NumberPair {
    public long num;
    public int op;

    public NumberPair(long num, int op) {
        this.op = op;
        this.num = num;
    }
}

