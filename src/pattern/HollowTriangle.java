package pattern;

public class HollowTriangle {
    public static void main(String[] args) {

        int m=10;
        hollowRightTriangle(m);
        System.out.println();
        hollowRightMirroredTriangle(m);


    }


    public static void hollowRightTriangle(int m){
        for(int row=1; row<=m ; row++) {

            for(int col=1; col<=row; col++){ //for every row col count depends on row, we dont want space after diagonal border

                if(col==1 || row==col) { //first column i.e left border  && diagonal print
                    System.out.print("*");
                }else if(row==m){ //last row i.e bottom border
                    System.out.print("*");
                }else  System.out.print(" "); //all spaces


            }
            System.out.println();
        }
    }

    public static void hollowRightMirroredTriangle(int m){

        for(int row=1; row<=m ; row++) {

            for(int col=1; col<=m; col++){

                if(row==1 || row==col) { //first row i.e top border  && diagonal print
                    System.out.print("*");
                }else if(col==m){ //last col i.e right border
                    System.out.print("*");
                }else  System.out.print(" "); //all spaces

            }
            System.out.println();
        }
    }


}
