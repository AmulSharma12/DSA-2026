package S005_Stack_Queue;
import java.util.Stack;
//https://leetcode.com/problems/sum-of-subarray-ranges/description/

public class P010_LC2104_SumOfSubarrayRanges {
    public static void main(String[] args){
        //call from here...
    }


    //Approach 1 - using brute/naive approach generating all subarray from every element
    public static long subArrayRanges(int[] nums) {
        long sum = 0;
        int n = nums.length;

        for(int i = 0; i<n; i++){
            int largest = nums[i];
            int smallest = nums[i];
            for(int j = i+1; j<n; j++){
                largest = Math.max(largest, nums[j]);
                smallest = Math.min(smallest, nums[j]);

                sum = sum + (largest - smallest);
            }
        }

        return sum;
    }


    //Approach 2 - using optimisation based on previous problems
    //sum of subarray maximum - sum of subarray minimum
    public long subArrayRangesOptimised(int[] nums) {
        int n = nums.length;
        long max = sumSubArrayMax(nums, n);
        long min = sumSubArrayMin(nums, n);
        System.out.println(max + " " + min);
        return max - min;
    }

    private int[] PSE(int[] nums, int n){
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];
        for(int ind = 0; ind < n; ind++){
            while(!st.isEmpty() && nums[st.peek()] > nums[ind]) st.pop();
            pse[ind] = st.isEmpty() ? -1 : st.peek();
            st.push(ind);
        }

        return pse;
    }

    private int[] NSE(int[] nums, int n){
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];

        for(int ind = n-1; ind >= 0; ind--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[ind]) st.pop();
            nse[ind] = st.isEmpty() ? n : st.peek();
            st.push(ind);
        }

        return nse;
    }

    private long sumSubArrayMin(int[] nums, int n){
        int[] pse = PSE(nums, n);
        int[] nse = NSE(nums, n);
        long total = 0;

        for(int ind = 0; ind < n; ind++){
            int left = ind - pse[ind];
            int right = nse[ind] - ind;
            total = total + (long)left*right*nums[ind];
        }

        return total;
    }

    private int[] PGE(int[] nums, int n){
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        for(int ind = 0; ind <n; ind++){
            while(!st.isEmpty() && nums[st.peek()] < nums[ind])  st.pop();
            nge[ind] = st.isEmpty() ? -1 : st.peek();
            st.push(ind);
        }

        return nge;
    }

    private int[] NGE(int[] nums, int n){
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        for(int ind = n-1; ind >= 0; ind--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[ind])     st.pop();
            nge[ind] = st.isEmpty() ? n : st.peek();
            st.push(ind);
        }

        return nge;
    }

    private long sumSubArrayMax(int[] nums, int n){
        int[] pge = PGE(nums, n);
        int[] nge = NGE(nums, n);
        long total = 0;

        for(int ind = 0; ind < n; ind++){
            int left = ind - pge[ind];
            int right = nge[ind] - ind;
            total = total + (long)left*right*nums[ind];
        }

        return total;
    }
}
