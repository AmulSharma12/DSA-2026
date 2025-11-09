package S002_Recursion;

public class P005_Basic_PrintNTo1_UsingBacktracking {
    public static void main(String[] args){
        printNto1(1,5);
    }

    //printing the N to 1 using backtracking
    private static void printNto1(int i, int n){
        //base condition
        if(i > n)   return;
        //recursive call
        printNto1(i+1,n);
        System.out.println(i);
    }
}
