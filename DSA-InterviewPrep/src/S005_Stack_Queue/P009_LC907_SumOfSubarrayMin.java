package S005_Stack_Queue;
//https://leetcode.com/problems/sum-of-subarray-minimums/description/
public class P009_LC907_SumOfSubarrayMin {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using brute/naive solution
    public static int sumSubarrayMins(int[] arr) {
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
}
