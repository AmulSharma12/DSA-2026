package S002_Recursion;

public class P004_Basic_Print1ToN_UsingBacktracking {
    public static void main(String[] args){
        print1ToN(5);
    }

    //1 to N using backtracking
    private static void print1ToN(int n){
        //base condition
        if(n == 0)  return;
        //recursive call
        print1ToN(n-1);
        System.out.println(n);
    }
}
