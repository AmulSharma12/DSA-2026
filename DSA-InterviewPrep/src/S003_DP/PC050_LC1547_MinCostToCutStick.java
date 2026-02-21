package S003_DP;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
public class PC050_LC1547_MinCostToCutStick {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int minCostRec(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        for (int i = 0; i < m; i++) arr[i + 1] = cuts[i];
        Arrays.sort(arr);

        return minCostR(1, m,  arr, n);
    }


    private static int minCostR(int i, int j, int[] cuts, int n){
        if(i > j)   return 0;

        int mini = Integer.MAX_VALUE;
        for(int k = i; k<=j; k++){
            int cost = cuts[j+1] - cuts[i-1] + minCostR(i, k-1, cuts, n) + minCostR(k+1, j,  cuts, n);
            mini = Math.min(mini, cost);
        }

        return mini;
    }
}
