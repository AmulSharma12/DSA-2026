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
}
