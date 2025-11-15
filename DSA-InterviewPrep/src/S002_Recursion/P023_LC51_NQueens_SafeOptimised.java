package S002_Recursion;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class P023_LC51_NQueens_SafeOptimised {
    public static void main(String[] args){
        //call from here...
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> nQueensResult = new ArrayList<>();
        char[][] board = new char[n][n];
        boolean[] left = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2*n-1];
        boolean[] upperDiagonal = new boolean[2*n-1];
        for(char[] ch: board){
            Arrays.fill(ch, '.');
        }
        placeNQueens(0, board, n, nQueensResult,left, lowerDiagonal, upperDiagonal);
        return nQueensResult;
    }

    private void placeNQueens(int col, char[][] board, int size, List<List<String>> nQueensResult, boolean[] left ,boolean[]lowerDiagonal,boolean[] upperDiagonal){
        //base case
        if(col == size){
            nQueensResult.add(new ArrayList<>(construct(board)));
            return;
        }

        //recursive case
        for(int row = 0 ; row < size; row++){
            if(isSafeToPlace(left, lowerDiagonal, upperDiagonal, row, col,size)){
                // System.out.println(row + " " + col + " " + " safe to place");
                board[row][col] = 'Q';
                left[row] = true;
                lowerDiagonal[row+col] = true;
                upperDiagonal[row-col+size-1] = true;
                placeNQueens(col+1, board, size, nQueensResult,left, lowerDiagonal, upperDiagonal);
                left[row] = false;
                lowerDiagonal[row+col] = false;
                upperDiagonal[row-col+size-1] = false;
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafeToPlace(boolean[] left, boolean[] lowerDiagonal, boolean[] upperDiagonal, int row, int col,int n){
        return !left[row] && !lowerDiagonal[row+col] && !upperDiagonal[row-col+n-1];
    }

    private List<String> construct(char[][] board){
        List<String> result = new ArrayList<>();
        for(char[] ch:board){
            result.add(new String(ch));
        }
        return result;
    }
}
