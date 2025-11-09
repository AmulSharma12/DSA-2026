package S002_Recursion;

public class P006_Basic_SumOfNNaturalNumber {
    public static void main(String[] args){
        sumOfFirstNNaturalNumber(5);
    }

    private static void sumOfFirstNNaturalNumber(int n){
        parameterizedWay(n, 0);
        System.out.println(functionalWay(n));
    }

    private static void parameterizedWay(int n, int sum){
        //base condition
        if(n == 0)  {
            System.out.println(sum);
            return;
        }
        //recursive calls
        parameterizedWay(n-1, sum + n);

    }

    private static int functionalWay(int n){
        if(n == 0)  return 0;
        return n + functionalWay(n-1);
    }
}
