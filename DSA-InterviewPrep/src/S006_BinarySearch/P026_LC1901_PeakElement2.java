package S006_BinarySearch;
//https://leetcode.com/problems/find-a-peak-element-ii/description/
public class P026_LC1901_PeakElement2 {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using linear search approach
    public static int[] findPeakGridUsingLinearApproach(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                int up = row-1 >= 0 ? mat[row-1][col] : -1;
                int left = col-1 >= 0 ? mat[row][col-1] : -1;
                int down = row+1 < m ? mat[row+1][col] : -1;
                int right = col+1 < n? mat[row][col+1] : -1;
                int element = mat[row][col];
                if(element > up && element > left && element > down && element > right)
                    return new int[] {row, col};
            }
        }

        return new int[] {-1,-1};
    }
}
