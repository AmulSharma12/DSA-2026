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
}
