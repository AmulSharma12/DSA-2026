package S002_Recursion;

public class P007_Basic_FactorialOfN {
    public static void main(String[] args){
        computeFactorialOfN(5);
    }

    private static void computeFactorialOfN(int n){
        parameteriseWay(n, 1);
        System.out.println(functionalWay(n));
    }

    private static void parameteriseWay(int num , int fact){
        if(num == 1){
            System.out.println(fact);
            return;
        }


        parameteriseWay(num - 1 , fact * num);
    }


    private static int functionalWay(int num){
        if(num == 1)    return 1;
        return num * functionalWay(num - 1);
    }
}
