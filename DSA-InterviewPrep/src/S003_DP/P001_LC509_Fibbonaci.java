package S003_DP;

public class P001_LC509_Fibbonaci {
    public static void main(String[] args){

    }

    //recursive way
    public static int fib(int n) {
        if(n <= 1)   return n;
        return fib(n - 1) + fib(n - 2);
    }


}
