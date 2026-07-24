package pattern;

public class HollowRhombus {
    public static void main(String[] args) {

        int m=5;

        for(int row=1;row<=m;row++){

            for(int i=1;i<=m-row;i++){
                System.out.print(" ");
            }


            for(int j=1; j<=m;j++){
                if(row==1 || j==1|| j==m || row==m) { //border top, left , bottom right
                    System.out.print("*");
                }else System.out.print(" "); //internal of rhombus is empty
            }

            System.out.println();

        }
    }
}
