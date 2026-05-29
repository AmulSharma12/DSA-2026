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
}
