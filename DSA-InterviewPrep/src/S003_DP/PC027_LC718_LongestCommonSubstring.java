package S003_DP;
//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
public class PC027_LC718_LongestCommonSubstring {
    public static void main(String[] args){
        //call from here...
    }

    //Recusursive approach
    public static int findLengthRec(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        return findLengthR(n-1, m-1,0, nums1, nums2);
    }

    private static int findLengthR(int ind1, int ind2, int len, int[] nums1, int[] nums2){
        //base case
        if(ind1 < 0 || ind2 < 0)    return len;

        int matched = len;
        if(nums1[ind1] == nums2[ind2])
            matched = findLengthR(ind1-1, ind2-1, len+1, nums1, nums2);

        int matchA = findLengthR(ind1-1, ind2, 0, nums1, nums2);
        int matchB = findLengthR(ind1, ind2-1, 0, nums1, nums2);

        return Math.max(matched , Math.max(matchA, matchB));
    }

    //Tabulation approach
    public static int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        return findLengthTabulation(n, m, nums1, nums2);
    }

    private static int findLengthTabulation(int N, int M, int[] nums1, int[] nums2){
        int[][] cache = new int[N+1][M+1];
        int longestCommonSubstring = 0;
        for(int ind1 = 1; ind1 <= N; ind1++){
            for(int ind2 = 1; ind2 <= M; ind2++){
                cache[ind1][ind2] = nums1[ind1-1] == nums2[ind2-1] ? 1 + cache[ind1-1][ind2-1] : 0;
                longestCommonSubstring = Math.max(longestCommonSubstring, cache[ind1][ind2]);
            }
        }

        return longestCommonSubstring;
    }


    //space optimizattion approach
    private static int findLengthSO(int N, int M, int[] nums1, int[] nums2){
        int[] prev = new int[M+1];
        int longestCommonSubstring = 0;
        for(int ind1 = 1; ind1 <= N; ind1++){
            int[] curr = new int[M+1];
            for(int ind2 = 1; ind2 <= M; ind2++){
                curr[ind2] = nums1[ind1-1] == nums2[ind2-1] ? 1 + prev[ind2-1] : 0;
                longestCommonSubstring = Math.max(longestCommonSubstring, curr[ind2]);
            }
            prev = curr;
        }

        return longestCommonSubstring;
    }
}
