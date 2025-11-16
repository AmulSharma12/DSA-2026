package S002_Recursion;
import java.util.ArrayList;

public class P027_GFG_RatInAMaze_Refactored {
    public static void main(String[] args){
        //call from here...
    }

    public static ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        int size = maze.length;
        boolean[][] isVisited = new boolean[size][size];
        int[] dirRow = new int[]{1,0,0,-1};
        int[] dirCol = new int[]{0,-1,1,0};
        possibleMazePaths(0,0,isVisited,dirRow,dirCol,result, new StringBuilder(), maze, size);
        return result;
    }

    private static void possibleMazePaths(int row, int col, boolean[][] isVisited,
                                   int[] dirRow, int[] dirCol,ArrayList<String> result, StringBuilder direction, int[][] maze, int size){
        //base case
        if(row == size-1 && col == size-1){
            result.add(direction.toString());
            return;
        }
        String directions = "DLRU";

        for(int dirIndex = 0; dirIndex < 4; dirIndex++){
            int newRow = row + dirRow[dirIndex];
            int newCol = col + dirCol[dirIndex];
            if(newRow >= 0 && newCol >= 0 && newRow < size && newCol < size && !isVisited[newRow][newCol]
                    && maze[newRow][newCol] == 1){
                isVisited[row][col] = true;
                direction.append(directions.charAt(dirIndex));
                possibleMazePaths(newRow, newCol, isVisited, dirRow, dirCol, result, direction, maze, size);
                direction.deleteCharAt(direction.length() - 1);
                isVisited[row][col] = false;
            }

        }

    }
}
