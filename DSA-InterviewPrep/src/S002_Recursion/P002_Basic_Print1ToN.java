package S002_Recursion;

public class P002_Basic_Print1ToN {
    public static void main(String[] args){
        print1ToN(5);
    }

    //1...n
    private static void print1ToN(int n){
        //base condition
        if(n == 0)  return;

        //recursive call
        print1ToN(n-1);
        System.out.println(n);
    }
}
