package TwoPointer;

/*
https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people. A square matrix mat[][] of size n*n is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.

Note: Follow 0-based indexing.

Examples:

Input: mat[][] = [[1, 1, 0],
                [0, 1, 0],
                [0, 1, 1]]
Output: 1
Explanation: 0th and 2nd person both know 1st person and 1st person does not know anyone. Therefore, 1 is the celebrity person.
Input: mat[][] = [[1, 1],
                [1, 1]]
Output: -1
Explanation: Since both the people at the party know each other. Hence none of them is a celebrity person.
Input: mat[][] = [[1]]
Output: 0
Constraints:
1 ≤ mat.size() ≤ 1000
0 ≤ mat[i][j] ≤ 1
mat[i][i] = 1

 */
public class TheCelebrityProblem
{
    //T(N) just traversing matrix, S(1) no extra space

    class Solution {
        public int celebrity(int mat[][]) {

            //range p1 = start , p2 = end which includes all people
            int p1=0;
            int p2= mat.length-1;

            //use two pointer approach to eliminate those who can not be celebrity
            //1) those who know even one person
            //2) those who are known by even one person

            while(p1<p2){ //check until both dont collide i.e both person are different

                if(mat[p1][p2]==1){ //p1 knows p2 -> p1 can't b celebrity as celebrity don't know anyone
                    p1++; //skip p1
                }else{ //p1 does not know p2 so p2 can't be celebrity as celebirity is known to everyone
                    p2--; //skip p2;
                }

            }

            //loop terminated p1=p2 condition

            int potentialCelebrity= p1; //or p2 as both are same

            //final check if potentialCelebrity is truly a celebrity or we don't even have celebrity
            //also make sure we dont check for ourself i.e we know ourself or not, or we dont know ourself or not etc
            //mens mat[X][X] = 1 or 0 does not matter because X knowing or notknowing X make no sense.

            for(int i=0;i<mat.length;i++){

                //check if potentialCelebrity knows anyone
                if(potentialCelebrity!=i && mat[potentialCelebrity][i]==1){
                    return -1; //some people exist who celebrity knows so it cant be celebrity
                }

                //check if some people exist who does not know it ,

                if(potentialCelebrity!=i && mat[i][potentialCelebrity]==0){
                    return -1; //some people exist who dont know celebrity so cant be celebrity
                }

            }

            return potentialCelebrity; //all checks done, every knows celebrity and celebrity knows nobody

        }
    }
}
