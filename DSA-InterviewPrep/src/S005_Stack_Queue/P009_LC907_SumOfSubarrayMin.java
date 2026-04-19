package S005_Stack_Queue;
import java.util.Stack;
//https://leetcode.com/problems/sum-of-subarray-minimums/description/
public class P009_LC907_SumOfSubarrayMin {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using brute/naive solution
    public static int sumSubarrayMinsBrute(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int mod = 10000007;
        for(int i = 0; i<n; i++){
            int mini = arr[i];
            for(int j = i; j<n; j++){
                mini = Math.min(mini, arr[j]);
                sum = (sum + mini)%mod;
            }
        }

        return sum;
    }


    //Approach 2 - using pse and nse concept and how many subarray for that element will lead to my total sum
    //avoiding of duplicate subarray so will be update require in any one of the pse or nse
    //so that the duplicate should be picked only once either its pse or nse
    //so for nse we are picking as it is everything  >= will be popped  so only strictly lesser element should be pushed to stack
    //but in pse we are not popping equal element so that it will actually lead me to exclude it  only > will be popped  so lesser or equal will be pushed to stack
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int[] pse = findPSE(arr, n);
        int[] nse = findNSE(arr, n);
        int totalSum = 0;
        final int MOD = 1_000_000_007;

        for(int ind = 0; ind <n; ind++){
            int left = ind - pse[ind];
            int right = nse[ind] - ind;

            totalSum = (totalSum + (left*right*arr[ind]) % MOD) % MOD;
        }

        return totalSum;
    }

    private int[] findNSE(int[] nums, int n){
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        for(int ind = n-1; ind >= 0; ind--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[ind]) st.pop();

            nse[ind] = st.isEmpty() ? n : st.peek();
            st.push(ind);
        }

        return nse;
    }


    private int[] findPSE(int[] nums, int n){
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];

        for(int ind = 0; ind < n; ind++){
            while(!st.isEmpty() && nums[st.peek()] > nums[ind]) st.pop();

            pse[ind] = st.isEmpty() ? -1 : st.peek();

            st.push(ind);
        }

        return pse;
    }
}
