package S006_BinarySearch;
//https://leetcode.com/problems/search-a-2d-matrix/description/
public class P024_LC74_Search2DMatrix {
    public static void main(String[] args){
        // call from here...
    }

    //Approach 1 - using brute approach
    public static boolean searchMatrixUsingBrute(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean isTargetFound = false;

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(matrix[row][col] == target){
                    isTargetFound = true;
                    break;
                }
            }
        }

        return isTargetFound;
    }


    //Approach 2 - using binary search approach
    private static boolean binarySearch(int[] nums, int target , int low , int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return true;
            else if(target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }

    public static boolean searchMatrixUsingBinarySearch(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int startRow = 0;
        int endRow = n-1;

        while(startRow <= endRow){
            int midRow = startRow + (endRow - startRow)/2;
            if(target >= matrix[midRow][0] && target <= matrix[midRow][m-1])
                return binarySearch(matrix[midRow] , target, 0, m-1);
            else if(target > matrix[midRow][m-1])
                startRow = midRow + 1;
            else
                endRow = midRow - 1;
        }

        return false;
    }
}
