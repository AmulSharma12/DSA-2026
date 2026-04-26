package S005_Stack_Queue;
//https://leetcode.com/problems/sliding-window-maximum/description/
public class P016_LC239_SlidingWindowMaximum {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - tracking max for every k window from very starting to very end
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];

        for(int ind = 0; ind <= n-k; ind++){
            int maxi = nums[ind];
            for(int j = ind; j<ind+k; j++){
                maxi = Math.max(maxi, nums[j]);
            }

            result[ind] = maxi;
        }

        return result;
    }
}
