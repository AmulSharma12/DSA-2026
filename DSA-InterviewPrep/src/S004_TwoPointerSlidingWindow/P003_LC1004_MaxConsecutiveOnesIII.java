package S004_TwoPointerSlidingWindow;
//https://leetcode.com/problems/max-consecutive-ones-iii/description/
public class P003_LC1004_MaxConsecutiveOnesIII {
    public static void main(String[] args){
        //call from here...
    }

    private static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        for(int ind = 0; ind < n; ind++){
            int limit = k;
            int lastWindowInd = ind - 1;
            for(int r = ind; r < n; r++){
                if(nums[r] == 0){
                    if(limit == 0) break;
                    limit--;
                }
                lastWindowInd = r;
            }

            maxLength = Math.max(maxLength, lastWindowInd-ind+1);
            System.out.println(ind + " " + lastWindowInd + " " + maxLength);
        }

        return maxLength;
    }


    //Approach 2 - optimised handling zero in window using while loop
    private static int longestOnesOptimised1(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int maxLength = 0;
        int zero = 0;
        while(r < n){
            if(nums[r] == 0)    zero++;

            while(zero > k){
                if(nums[l] == 0) zero--;
                l++;
            }

            if(zero <= k)
                maxLength = Math.max(maxLength, r-l+1);

            r++;
        }

        return maxLength;
    }
}
