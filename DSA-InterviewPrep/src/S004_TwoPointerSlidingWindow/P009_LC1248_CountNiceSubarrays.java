package S004_TwoPointerSlidingWindow;
//https://leetcode.com/problems/count-number-of-nice-subarrays/
public class P009_LC1248_CountNiceSubarrays {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using brute naive solution - generating all subarrays
    private static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i<n; i++){
            int oddCount = 0;

            for(int j = i; j<n; j++){
                if(nums[j] % 2 != 0)    oddCount++;

                if(oddCount == k){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
