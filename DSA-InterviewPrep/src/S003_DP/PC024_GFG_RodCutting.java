package S003_DP;

import java.util.Arrays;

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

    //Memoization solution
    public static int cutRodM(int[] price) {
        int N = price.length;
        int[][] cache = new int[N][N+1];
        for(int[] cacheRow:cache){
            Arrays.fill(cacheRow,-1);
        }
        return cutRodM(N-1, N, price, cache);
    }

    private static int cutRodM(int index, int n, int[] price, int[][] cache){
        if(index == 0){
            return n * price[0];
        }

        int excluded = cutRodM(index-1, n, price, cache);
        int included = Integer.MIN_VALUE;
        int rodLength = index+1;

        if(cache[index][n] != -1)    return cache[index][n];

        if(rodLength <= n)
            included = price[index] + cutRodM(index, n- rodLength, price, cache);

        return cache[index][n] = Math.max(included, excluded);
    }

    //Tabulation solution
    private static int cutRodT(int[] price, int N){
        int[][] cache = new int[N][N+1];

        for(int RL = 0; RL <= N; RL++){
            cache[0][RL] = RL * price[0];
        }

        for(int index = 1; index < N; index++){
            for(int RL = 0; RL <= N; RL++){
                int excluded = cache[index-1][RL];
                int included = Integer.MIN_VALUE;
                int rodLength = index+1;
                if(rodLength <= RL)
                    included = price[index] + cache[index][RL-rodLength];
                cache[index][RL] = Math.max(included, excluded);
            }
        }

        return cache[N-1][N];

    }
}
