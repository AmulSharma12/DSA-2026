package S006_BinarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/row-with-maximum-ones/description/
public class P023_LC2643_MatrixMaxOnes {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using brute force solution
    public static int[] rowAndMaximumOnesUsingLinearApproach(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int maxInd = 0;
        int maxOnes = Integer.MIN_VALUE;

        for(int row = 0; row < n; row++){
            int numberOfOne = 0;
            for(int col = 0; col < m; col++){
                if(mat[row][col] == 1)  numberOfOne++;
            }

            if(numberOfOne > maxOnes){
                maxOnes = numberOfOne;
                maxInd = row;
            }
        }

        return new int[]{maxInd, maxOnes};
    }


    private static int findNumberOfOnes(int[] nums, int target){
        Arrays.sort(nums);  //sorting to apply binary search
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return nums.length - low;  //number of elements.
    }
    public static int[] rowAndMaximumOnesUsingBinarySearch(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int maxInd = 0;
        int maxOnes = Integer.MIN_VALUE;

        for(int row = 0; row < n; row++){
            int numberOfOne = findNumberOfOnes(mat[row], 1);
            System.out.println("row " + row  + " " + numberOfOne);
            if(numberOfOne > maxOnes){
                maxOnes = numberOfOne;
                maxInd = row;
            }
        }

        return new int[]{maxInd, maxOnes};
    }
}
