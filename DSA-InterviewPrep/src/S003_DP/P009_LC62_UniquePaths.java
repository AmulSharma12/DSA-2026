package S003_DP;

public class P009_LC62_UniquePaths {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int uniquePaths(int m, int n) {
        return numberOfUniquePaths(m-1, n-1);
    }

    private static int numberOfUniquePaths(int row, int col){
        //base cases
        if(row == 0 && col == 0)    return 1;
        if(row < 0 || col < 0)  return 0;


        int upDirectionPaths = numberOfUniquePaths(row-1, col);
        int leftDirectionPaths = numberOfUniquePaths(row, col-1);

        return upDirectionPaths + leftDirectionPaths;
    }
}
