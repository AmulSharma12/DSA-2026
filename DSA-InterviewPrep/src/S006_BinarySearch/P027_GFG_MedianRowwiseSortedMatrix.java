package S006_BinarySearch;
import java.util.Arrays;
//https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1

public class P027_GFG_MedianRowwiseSortedMatrix {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1- using brute force approach
    public static int medianUsingBruteApproach(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int x = n * m;
        int[] result = new int[x];
        int currInd = 0;

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                result[currInd++] = mat[row][col];
            }
        }

        Arrays.sort(result);
        return result[x/2];
    }


    //Approach 2 - using binary search approach

    private static int upperBound(int[] row, int target) {

        int low = 0;
        int high = row.length - 1;
        int ans = row.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (row[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static int countSmallThanMid(int[][] mat, int n, int m, int x){
        int cnt = 0;

        for(int row = 0; row < n; row++){
            cnt += upperBound(mat[row], x);
        }

        return cnt;
    }

    public static int medianUsingBinarySearchApproach(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int row = 0; row < n; row++){
            low = Math.min(low, mat[row][0]);
            high = Math.max(high, mat[row][m-1]);
        }

        int required = (n*m)/2;

        while(low <= high){
            int mid = low + (high - low)/2;
            int smallCount = countSmallThanMid(mat, n, m, mid);
            if(smallCount <= required)
                low = mid + 1;
            else
                high = mid - 1;
        }


        return low;

    }
}
