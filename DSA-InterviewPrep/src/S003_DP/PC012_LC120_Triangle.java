package S003_DP;
import java.util.List;

public class PC012_LC120_Triangle {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        return minPathSumRec(0,0, triangle, n);
    }

    private static int minPathSumRec(int row, int col, List<List<Integer>> triangle, int n){
        //base case
        if(row == n-1)  return triangle.get(row).get(col);

        int downPathSum = triangle.get(row).get(col) + minPathSumRec(row+1, col, triangle, n);
        int diagonalPathSum = triangle.get(row).get(col) + minPathSumRec(row+1, col+1, triangle, n);
        return Math.min(downPathSum, diagonalPathSum);
    }
}
