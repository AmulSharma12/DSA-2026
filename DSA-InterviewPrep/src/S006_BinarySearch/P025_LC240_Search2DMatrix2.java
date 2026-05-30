package S006_BinarySearch;
//https://leetcode.com/problems/search-a-2d-matrix-ii/description/
public class P025_LC240_Search2DMatrix2 {
    public static void main(String[] args){
        //call from here..
    }

    //Approach 1 - using brute force solution
    public static boolean searchMatrixUsingBrute(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(matrix[row][col] == target)  return true;
            }
        }

        return false;
    }

    //Approach 2 - using optimized approach
    public static boolean searchMatrixUsingOptimized(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int row = 0; row < m; row++){
            int low = 0;
            int high = n-1;

            while(low <= high){
                int mid = low + (high - low)/2;
                int currElement = matrix[row][mid];
                if(currElement == target) return true;
                else if(target > currElement) low = mid + 1;
                else high = mid - 1;
            }
        }

        return false;
    }


    //Approach 3 - using binary search approach
    public static boolean searchMatrixUsingBinarySearchApproach(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        //top right based on that will eliminate either row or either column
        int row = 0;
        int col = n-1;

        while(row < m && col >= 0){
            int currElement = matrix[row][col];
            if(currElement == target)   return true;
            else if(target > currElement)  row++;
            else col--;
        }


        return false;
    }
}
