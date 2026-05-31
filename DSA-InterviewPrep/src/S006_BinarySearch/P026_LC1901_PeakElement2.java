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


    //Approach 2 - using binary search approach
    public static int[] findPeakGridUsingBinarySearch(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            int maxRowInd = getMax(mat, m, n, mid);
            int currElement = mat[maxRowInd][mid];
            int leftElement = mid-1 >= 0 ? mat[maxRowInd][mid-1] : -1;
            int rightElement = mid + 1 < n ? mat[maxRowInd][mid+1] : -1;

            if(currElement > leftElement && currElement > rightElement)
                return new int[]{maxRowInd, mid};
            else if(leftElement > currElement)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return new int[]{-1, -1};
    }

    private static int getMax(int[][] mat, int m, int n, int col){
        int maxElement = Integer.MIN_VALUE;
        int maxInd = -1;
        for(int row = 0; row < m; row++){
            if(maxElement < mat[row][col]){
                maxElement = mat[row][col];
                maxInd = row;
            }
        }

        return maxInd;
    }
}
