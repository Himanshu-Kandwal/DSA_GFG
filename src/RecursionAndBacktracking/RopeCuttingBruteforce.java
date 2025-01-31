package RecursionAndBacktracking;

import java.util.Scanner;

/*

We are given a rope length N, we have to cut it in maximum pieces such that all pieces are either of size a,b or c.

Given
N-> Size of rope.
a,b,c -> Rope piece of size.

0 < a,b,c <= N

*/
public class RopeCuttingBruteforce {

    public static void inputAndProcessFurther() {
        System.out.println("Taking input");
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //rope size
        int set[] = new int[3];

        set[0] = sc.nextInt(); //a
        set[1] = sc.nextInt(); //b
        set[2] = sc.nextInt(); //c
        RopeCuttingBruteforce obj = new RopeCuttingBruteforce();
        System.out.println(obj.getMaximumRopePieces(N, set));
    }

    //T(N^3) S(height of the tree)
    public static int getMaximumRopePieces(int N, int set[]) {
        if (N == 0) return 0; //successful testcase cut
        if (N < 0) return -1; //impossible to cut negative length rope

        int ans1 = getMaximumRopePieces(N - set[0], set); //try a size cut
        int ans2 = getMaximumRopePieces(N - set[1], set);//try b size cut
        int ans3 = getMaximumRopePieces(N - set[2], set); //try c size cut

        int result = Math.max(Math.max(ans1, ans2), ans3); //max of all options
        if (result < 0) //if result is invalid(or no cuts are posisble)
            return -1;

        return result + 1; //add 1 to result as we have taken 1 cut in rope ;
    }
}