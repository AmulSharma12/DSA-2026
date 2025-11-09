package S002_Recursion;

public class P010_Basic_Fibbonaci {
    public static void main(String[] args){
        System.out.println(computeNthFibbonaci(6));
    }

    private static int computeNthFibbonaci(int num){
        if(num <= 1)    return num;
        return computeNthFibbonaci(num-1) + computeNthFibbonaci(num-2);
    }
}
