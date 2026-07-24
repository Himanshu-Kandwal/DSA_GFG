package pattern;

public class HollowSquare {
    public static void main(String[] args) {

        int m=5; //for square its row and col, for rectangle we can have different for row and col

        for(int row=1; row<=m ; row++) {

            for(int col=1; col<=m; col++){

                if(row==1 || row ==m){ //if its first and last row
                    System.out.print("*");
                }else if (col==1 || col==m){ //first and last col
                    System.out.print("*");
                }else System.out.print(" "); //all non-border cell

            }
            System.out.println();
        }

    }
}
