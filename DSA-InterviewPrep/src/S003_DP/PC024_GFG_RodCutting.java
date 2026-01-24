package S003_DP;
//https://www.geeksforgeeks.org/problems/rod-cutting0840/1
public class PC024_GFG_RodCutting {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int cutRodR(int[] price) {
        int N = price.length;
        return cutRodR(N-1, N, price);
    }

    private static int cutRodR(int index, int n, int[] price){
        if(index == 0){
            return n * price[0];
        }

        int excluded = cutRodR(index-1, n, price);
        int included = Integer.MIN_VALUE;
        int rodLength = index+1;

        if(rodLength <= n)
            included = price[index] + cutRodR(index, n- rodLength, price);

        return Math.max(included, excluded);
    }
}
