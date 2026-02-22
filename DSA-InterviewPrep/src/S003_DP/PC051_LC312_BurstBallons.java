package S003_DP;

public class PC051_LC312_BurstBallons {
    public static void main(String[] args){
        //call from here...
    }

    //recursive solution
    public static int maxCoinsRecursive(int[] ballons) {
        int n = ballons.length;
        int[] nums = new int[n+2];
        nums[0] = 1;
        nums[n+1] = 1;
        for(int ind = 0; ind < n; ind++)    nums[ind+1] = ballons[ind];
        return maxCoinsRec(1, n, nums);
    }

    private static int maxCoinsRec(int i, int j, int[] nums){
        if(i > j)   return 0;

        int maxi = 0;
        for(int burst = i; burst<=j; burst++){
            int coins = nums[burst] * nums[i-1] * nums[j+1]
                    + maxCoinsRec(i, burst-1, nums)
                    + maxCoinsRec(burst+1, j, nums);

            maxi = Math.max(maxi, coins);
        }

        return maxi;
    }
}
