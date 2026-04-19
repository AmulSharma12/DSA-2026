package S005_Stack_Queue;
//https://leetcode.com/problems/trapping-rain-water/description/
public class P008_LC42_TrappingRainWater {
    public static void main(String[] args){
        //call from here...
    }


    //Approach 1 - using prefixMax and suffixMax array
    private static int trapBrute(int[] height) {
        int n = height.length;
        int waterTrap = 0;

        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        prefixMax[0] = height[0];
        for(int ind = 1; ind <n; ind++)
            prefixMax[ind] = Math.max(prefixMax[ind-1], height[ind]);

        suffixMax[n-1] = height[n-1];
        for(int ind = n-2; ind>=0; ind--)
            suffixMax[ind] = Math.max(suffixMax[ind+1], height[ind]);


        for(int ind = 0; ind <n; ind++){
            if(height[ind] < prefixMax[ind]  && height[ind] < suffixMax[ind])
                waterTrap += Math.min(prefixMax[ind], suffixMax[ind]) - height[ind];
        }

        return waterTrap;
    }

    //Approach 2 - using two pointer tracking lmax and rmax and making sure
    //if this covered by boundary - then water will be trapped
    //if found anything bigger will update the boundary.
    public static int trap(int[] nums) {
        int n = nums.length;
        int lmax = 0;
        int rmax = 0;
        int l = 0;
        int r = n-1;
        int waterTrap = 0;

        while(l < r){
            if(nums[l] <= nums[r]){
                if(lmax > nums[l])
                    waterTrap += lmax - nums[l];
                else
                    lmax = nums[l];
                l++;
            }else{
                if(rmax > nums[r])
                    waterTrap += rmax - nums[r];
                else
                    rmax = nums[r];
                r--;
            }
        }


        return waterTrap;
    }
}
