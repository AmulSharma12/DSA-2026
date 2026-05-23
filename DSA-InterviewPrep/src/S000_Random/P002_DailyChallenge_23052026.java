package S000_Random;
//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/?envType=daily-question&envId=2026-05-23
public class P002_DailyChallenge_23052026 {
    public static void main(String[] args){
        //call from here...
    }


    //scan through entier array there will be either 0 rotation then no conflict and if there is some rotations ther will be exact one conflict . Greater than one will not been considered
    public static boolean check(int[] nums) {
        int n = nums.length;
        int conflict = 0;
        for(int ind = 0; ind < n; ind++){
            if(nums[ind] > nums[(ind+1)%n]) conflict++;
        }

        return conflict <= 1;
    }
}
