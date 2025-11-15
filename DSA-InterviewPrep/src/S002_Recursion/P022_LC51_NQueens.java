package S002_Recursion;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class P022_LC51_NQueens {
    public static void main(String[] args){
        //call from here...
    }


    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> nQueensResult = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] ch: board){
            Arrays.fill(ch, '.');
        }
        placeNQueens(0, board, n, nQueensResult);
        return nQueensResult;
    }

    private static void placeNQueens(int col, char[][] board, int size, List<List<String>> nQueensResult){
        //base case
        if(col == size){
            nQueensResult.add(new ArrayList<>(construct(board)));
            return;
        }

        //recursive case
        for(int row = 0 ; row < size; row++){
            if(isSafeToPlace(board, row, col, size)){
                // System.out.println(row + " " + col + " " + " safe to place");
                board[row][col] = 'Q';
                placeNQueens(col+1, board, size, nQueensResult);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafeToPlace(char[][] board, int row , int col, int n){
        int tempRow = row;
        int tempCol = col;
        //left
        while(col >= 0)         if(board[row][col--] == 'Q')    return false;
        //lower diagonal

        row = tempRow;
        col = tempCol;
        while(col >= 0 && row < n)    if(board[row++][col--] == 'Q') return false;

        row = tempRow;
        col = tempCol;
        //upper diagonal
        while(col >= 0 && row >= 0)   if(board[row--][col--] == 'Q') return false;
        return true;
    }

    private static  List<String> construct(char[][] board){
        List<String> result = new ArrayList<>();
        for(char[] ch:board){
            result.add(new String(ch));
        }
        return result;
    }
}
