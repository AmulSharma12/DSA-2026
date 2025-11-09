package S002_Recursion;

public class P003_Basic_PrintNTo1 {
    public static void main(String[] args){
        //calling the function that has been going to made
        printNTo1(5);
    }


    private static void printNTo1(int n){
        //base condition
        if(n == 0)  return;
        System.out.println(n);
        //recursive call
        printNTo1(n-1);
    }
}
