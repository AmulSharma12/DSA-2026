package S003_DP;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/largest-divisible-subset/description/
public class PC044_LC368_LDS {
    public static void main(String[] args){
        //call from here...
    }

    //using tabulation approach for the
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] hash = new int[n];
        int maxi = 1; int lastInd = 0;
        for(int ind = 1; ind < n; ind++){
            hash[ind] = ind;
            for(int prevInd = 0; prevInd < ind; prevInd++){
                if(nums[ind] % nums[prevInd] == 0 && 1+dp[prevInd] > dp[ind]){
                    dp[ind] = 1 + dp[prevInd];
                    hash[ind] = prevInd;
                }
            }

            if(dp[ind] > maxi){
                maxi = dp[ind];
                lastInd = ind;
            }
        }


        //backtrack based on the prevInd stored will add the element to the list
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[lastInd]);

        while(hash[lastInd] != lastInd){
            lastInd = hash[lastInd];
            ans.add(nums[lastInd]);
        }

        //Collections.reverse(ans);
        return ans;
    }
}
