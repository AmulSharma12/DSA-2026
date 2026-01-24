package S003_DP;
//https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
public class PC023_GFG_UnboundedKnapsack {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int knapSackR(int val[], int wt[], int capacity) {
        int n = val.length;
        return unboundedKnapSackR(n-1, capacity, wt, val);
    }

    private static int unboundedKnapSackR(int index, int maxWeight, int[] wt, int[] val){
        //base case
        if(index == 0){
            return (maxWeight/wt[0]) * val[0];
        }

        //fill the knapsack
        int excluded = unboundedKnapSackR(index-1, maxWeight, wt, val);
        int included = Integer.MIN_VALUE;
        if(wt[index] <= maxWeight)
            included = val[index] + unboundedKnapSackR(index, maxWeight-wt[index], wt, val);

        return Math.max(excluded, included);
    }
}
