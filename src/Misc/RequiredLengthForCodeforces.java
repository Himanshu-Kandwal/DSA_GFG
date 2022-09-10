package Misc;
/*

LINK https://codeforces.com/problemset/problem/1681/D
file for submission
*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RequiredLengthForCodeforces {
    public static void main(String[] args) {
        int N = 19;
        int X = 75804550;
        Scanner sc = new Scanner(System.in);
        int test = 1;
        while (test-- > 0) {
            N = sc.nextInt();
            X = sc.nextInt();
            System.out.println(minimum_op(N, X));
        }
    }

    public static int minimum_op(int n, int num) {
        HashSet<Long> visited = new HashSet<>();
        Queue<Long> q = new LinkedList<>();
        q.add((long) num);
        int steps = 0;
        while (!q.isEmpty()) {
            //System.out.println(number);
            int size = q.size(); // size of queue, to try all numbers stored on a curr level

            while (size-- > 0) {
                long currNumber = q.remove();
                if (visited.contains(currNumber)) continue;
                visited.add(currNumber);
                long number = currNumber;

                while (number != 0) {
                    if (number % 10 != 0 || number % 10 != 1) {
                        long newNum = currNumber * (number % 10); //multiplying currNum by every digit
                        if (digits(newNum) == n) return steps+1;
                        if (digits(newNum) > n) continue; //newNum has more digits than n so continue
                        q.add(newNum);
                    }
                    number /= 10;
                }
            }
            steps++;
        }
        return -1;
    }

    static int digits(long n) {
        return (int) Math.floor(Math.log10(n) + 1);
    }

}