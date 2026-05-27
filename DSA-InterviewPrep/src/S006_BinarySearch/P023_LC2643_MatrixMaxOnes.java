package S006_BinarySearch;
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
}
