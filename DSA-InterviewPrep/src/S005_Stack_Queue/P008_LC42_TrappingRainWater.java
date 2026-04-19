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
}
