package S003_DP;

public class P004_LC1137_TribonacciNumber {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int tribonacciR(int n) {
        if(n == 0)   return 0;
        if(n <= 2)  return 1;
        return tribonacciR(n-1) + tribonacciR(n - 2) + tribonacciR(n - 3);
    }
}
