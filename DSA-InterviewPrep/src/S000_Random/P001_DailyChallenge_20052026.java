package S000_Random;
//https://leetcode.com/problems/minimum-common-value/?envType=daily-question&envId=2026-05-19
public class P001_DailyChallenge_20052026 {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1- using brute force
    public static int getCommon(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int ind1 = 0;
        int ind2 = 0;
        while(ind1 < n1 && ind2 < n2){
            if(nums1[ind1] == nums2[ind2])  return nums1[ind1];
            if(nums1[ind1] > nums2[ind2]) ind2++;
            else ind1++;
        }


        return -1;
    }

}
