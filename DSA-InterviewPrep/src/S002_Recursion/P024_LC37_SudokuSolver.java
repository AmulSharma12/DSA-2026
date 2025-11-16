package S002_Recursion;
import java.util.List;

public class P024_LC37_SudokuSolver {
    public static void main(String[] args){
        //call from here..
    }

    public static void solveSudoku(char[][] board) {
        solve(board, board.length);
    }


    private static boolean solve(char[][] board, int size){
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){

                if(board[i][j] == '.'){
                    for(char ch = '1'; ch <= '9'; ch++){
                        if(isValid(board, i, j, ch)){
                            board[i][j] = ch;
                            if(solve(board, size)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }


    private static  boolean isValid(char[][] board, int row, int col, char ch){
        for(int i = 0; i<9; i++){
            if(board[row][i] == ch)     return false;
            if(board[i][col] == ch)     return false;
            if(board[row-(row%3)+i/3][col-(col%3)+i%3] == ch)   return false;
        }
        return true;
    }
}
