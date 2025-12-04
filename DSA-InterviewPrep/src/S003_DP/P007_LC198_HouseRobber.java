package S003_DP;

public class P007_LC198_HouseRobber {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int robR(int[] nums) {
        int n = nums.length;
        return maxRobbingR(n-1, nums);
    }

    private static int maxRobbingR(int position, int[] moneyStreet){
        if(position == 0)   return moneyStreet[position];
        if(position < 0)    return 0;

        int moneyPicked = moneyStreet[position] + maxRobbingR(position -2, moneyStreet);
        int moneyNotPicked = 0 + maxRobbingR(position-1, moneyStreet);
        return Math.max(moneyPicked, moneyNotPicked);
    }

}
