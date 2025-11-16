package S002_Recursion;
import java.util.ArrayList;
public class P026_GFG_RatInAMaze {
    public static void main(String[] args){
        //call from here...
    }

    public static  ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        int size = maze.length;
        boolean[][] isVisited = new boolean[size][size];
        possibleMazePaths(0,0,isVisited, result, new StringBuilder(), maze, size);
        return result;
    }

    private static void possibleMazePaths(int row, int col, boolean[][] isVisited,ArrayList<String> result, StringBuilder direction, int[][] maze, int size){
        //base case
        if(row == size-1 && col == size-1){
            result.add(direction.toString());
            return;
        }

        //down
        if(row+1 < size && !isVisited[row+1][col]  && maze[row+1][col] ==1){
            isVisited[row][col] = true;
            direction.append("D");
            possibleMazePaths(row+1, col, isVisited, result, direction, maze, size);
            direction.deleteCharAt(direction.length() - 1);
            isVisited[row][col] = false;
        }

        //left
        if(col-1>=0 && !isVisited[row][col-1]  && maze[row][col-1] ==1){
            isVisited[row][col] = true;
            direction.append("L");
            possibleMazePaths(row, col-1, isVisited, result, direction, maze, size);
            direction.deleteCharAt(direction.length() - 1);
            isVisited[row][col] = false;
        }


        //right
        if(col+1 < size && !isVisited[row][col+1]  && maze[row][col+1] ==1){
            isVisited[row][col] = true;
            direction.append("R");
            possibleMazePaths(row, col+1, isVisited, result, direction, maze, size);
            direction.deleteCharAt(direction.length() - 1);
            isVisited[row][col] = false;
        }


        //up
        if(row-1>=0 && !isVisited[row-1][col]  && maze[row-1][col] ==1){
            isVisited[row][col] = true;
            direction.append("U");
            possibleMazePaths(row-1, col, isVisited, result, direction, maze, size);
            direction.deleteCharAt(direction.length() - 1);
            isVisited[row][col] = false;
        }
    }
}
