package pattern;

public class Swastik {
    public static void main(String[] args) {

        /*


        *     * * * *
        *     *
        * * * * * * *
              *     *
        * * * *     *


        */

        int n=9;

        for(int i=0; i<n; i++){

            for(int j=0;j<n;j++){

                if(j==0 && i<n/2-1){ //left-top to half line -1
                    System.out.print("*");
                }else if(i==0 && j>n/2){
                    System.out.print("*"); //top-right line
                }

                //mid top to bottom

                else if(j==n/2){
                    System.out.print("*");
                }

                //mid left to right
                else if(i==n/2){
                    System.out.print("*");
                }

                //bottom-left to center line
               else if(i==n-1 && j<n/2-1){
                    System.out.print("*");
                }

                //right-center to bottom
               else if(j==n-1 && i>n/2){
                    System.out.print("*");
                }
               else System.out.print(" "); //if no * print space so properly whole spaces are printed
            }

            System.out.println();
        }

    }
}
