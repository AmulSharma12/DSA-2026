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
}
