package Recursion;

import java.util.Scanner;

/*

We are given a rope length N, we have to cut it in maximum pieces such that all pieces are either of size a,b or c.

Given
N-> Size of rope.
a,b,c -> Rope piece of size.

0 < a,b,c <= N
*/
public class RopeCutting {
    public static void main(String[] args) {
        System.out.println("Hire me");
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //rope size
        int set[] = new int[3];

        set[0] = sc.nextInt(); //a
        set[1] = sc.nextInt(); //b
        set[2] = sc.nextInt(); //c

        //System.out.println(getMaximumRopePieces(N, set));
    }

    /*static int getMaximumRopePieces(int N, int set[]) {

    }*/
}