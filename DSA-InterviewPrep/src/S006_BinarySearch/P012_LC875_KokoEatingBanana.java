package S006_BinarySearch;
//https://leetcode.com/problems/koko-eating-bananas/description/
public class P012_LC875_KokoEatingBanana {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1- using linear approach way
    public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int num = 1;

        //max track
        int maxi = Integer.MIN_VALUE;
        for(int ind = 0; ind < n; ind++){
            maxi = Math.max(maxi, piles[ind]);
        }


        //now do it for every num
        while(num <= maxi){
            if(isEatableInHHours(num,piles, h))
                return num;
            num++;
        }

        return maxi;
    }

    private static boolean isEatableInHHours(int eatPerHour, int[] piles, int h){
        int n = piles.length;
        int hourSpent = 0;
        for(int ind = 0; ind < n; ind++){
            hourSpent += Math.ceil((double)piles[ind] / eatPerHour);
            if(hourSpent > h)   return false;
        }

        return true;
    }

    //Approach 2 - using binary search approach
    public static int minEatingSpeedUsingBinaryApproach(int[] piles, int h) {
        int n = piles.length;
        int maxi = Integer.MIN_VALUE;

        for(int ind = 0; ind < n; ind++){
            maxi = Math.max(maxi, piles[ind]);
        }

        int low = 1;
        int high = maxi;
        int ans = 1;
        while(low <= high){
            int eatPerHour = low + (high-low)/2;
            if(isEatableInHHours(eatPerHour, piles, h)){
                ans = eatPerHour;
                high = eatPerHour - 1;
            }else{
                low = eatPerHour + 1;   //as i have exceed the limit of h hour and this can't be my ans so anything greater than that
            }
        }


        return ans;
    }



}
