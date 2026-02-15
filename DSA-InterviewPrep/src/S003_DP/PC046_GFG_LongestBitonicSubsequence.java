package S003_DP;
import java.util.Arrays;
//https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
public class PC046_GFG_LongestBitonicSubsequence {
    public static void main(String[] args){
        //call from here...
    }

    public static int longestBitonicSequence(int n, int[] nums) {
        //1.) computing LIS from front
        //2.) computing LIS from back
        //now for each index - we have their max LIS from both sides we can make
        //3.) bitonic for any index - will be sum for both the LIS -1
        //-1 because the common element used in both side that is ind element so taking it for single time
        // take the maximum of bitonic array that is the answer

        int[] LIS = new int[n];
        int[] LDS = new int[n];

        Arrays.fill(LIS,1);
        Arrays.fill(LDS,1);


        for(int ind = 0; ind < n; ind++){
            for(int prevInd = 0; prevInd < ind; prevInd++){
                if(nums[ind] > nums[prevInd] && 1 + LIS[prevInd] > LIS[ind]){

                    LIS[ind] = 1 + LIS[prevInd];
                }
            }
        }


        //LDS - is nothing but LIS from back only if you visualize
        for(int ind = n-1; ind >= 0; ind--){
            for(int prevInd = n-1; prevInd > ind; prevInd--){
                if(nums[ind] > nums[prevInd] && 1 + LDS[prevInd] > LDS[ind]){

                    LDS[ind] = 1 + LDS[prevInd];
                }
            }
        }


        int maxi = 0;
        for(int ind = 0; ind < n; ind++){
            if(LIS[ind] > 1 && LDS[ind] > 1){
                maxi = Math.max(maxi,  LIS[ind] + LDS[ind] - 1);
            }
        }


        return maxi;
    }
}
